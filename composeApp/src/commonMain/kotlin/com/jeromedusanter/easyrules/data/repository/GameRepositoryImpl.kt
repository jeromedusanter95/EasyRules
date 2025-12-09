package com.jeromedusanter.easyrules.data.repository

import com.jeromedusanter.easyrules.domain.GameDifficultyLevelModel
import com.jeromedusanter.easyrules.domain.GameFilterModel
import com.jeromedusanter.easyrules.domain.GameModel
import com.jeromedusanter.easyrules.domain.GameTagModel
import com.jeromedusanter.easyrules.domain.gameList
import com.jeromedusanter.easyrules.domain.gameListInEnglish
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine

/**
 * Implementation of GameRepository.
 * Manages game data and filtering logic.
 */
class GameRepositoryImpl : GameRepository {

    private val _gameFilter = MutableStateFlow(GameFilterModel.INITIAL_STATE)
    override val gameFilter: StateFlow<GameFilterModel> = _gameFilter.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    override val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _shouldApplyFilter = MutableStateFlow(false)
    override val shouldApplyFilter: StateFlow<Boolean> = _shouldApplyFilter.asStateFlow()

    private val _rawGameList = MutableStateFlow<List<GameModel>>(emptyList())

    override val games: Flow<List<GameModel>> = combine(
        _gameFilter,
        _rawGameList,
        _searchQuery,
        _shouldApplyFilter
    ) { filter, list, query, shouldApply ->
        applyFilters(list, filter, query, shouldApply)
    }

    override suspend fun loadGames(locale: String) {
        val list = when (locale) {
            "fr" -> gameList
            else -> gameListInEnglish
        }
        _rawGameList.value = list
    }

    override fun updateNumberOfPlayers(numberOfPlayers: Int) {
        _gameFilter.value = _gameFilter.value.copy(numberOfPlayers = numberOfPlayers)
    }

    override fun updateDurationRange(durationRange: IntRange) {
        _gameFilter.value = _gameFilter.value.copy(durationRange = durationRange)
    }

    override fun updateDifficultyLevel(difficultyLevel: GameDifficultyLevelModel?) {
        _gameFilter.value = _gameFilter.value.copy(
            difficultyLevel = if (difficultyLevel == _gameFilter.value.difficultyLevel) {
                null
            } else {
                difficultyLevel
            }
        )
    }

    override fun toggleTag(tag: GameTagModel) {
        val currentTags = _gameFilter.value.tagSelectedList.toMutableList()
        if (currentTags.contains(tag)) {
            currentTags.remove(tag)
        } else {
            currentTags.add(tag)
        }
        _gameFilter.value = _gameFilter.value.copy(tagSelectedList = currentTags)
    }

    override fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    override fun clearSearchQuery() {
        _searchQuery.value = ""
    }

    override fun clearFilters() {
        _gameFilter.value = GameFilterModel.INITIAL_STATE
    }

    override fun setShouldApplyFilter(shouldApply: Boolean) {
        _shouldApplyFilter.value = shouldApply
    }

    /**
     * Applies filters to the game list based on current filter state.
     */
    private fun applyFilters(
        list: List<GameModel>,
        filter: GameFilterModel,
        query: String,
        shouldApply: Boolean
    ): List<GameModel> {
        return if (!shouldApply) {
            // Only apply search query
            list.filter { game ->
                game.name.contains(query, ignoreCase = true)
            }
        } else {
            // Apply all filters
            list.filter { game ->
                game.name.contains(query, ignoreCase = true) &&
                        // Check if the exact number of players is within the game's allowed range
                        game.minPlayer <= filter.numberOfPlayers &&
                        game.maxPlayer >= filter.numberOfPlayers &&
                        // Filter by duration range
                        game.durationInMinutes in filter.durationRange &&
                        // Filter by tags if any are selected
                        (filter.tagSelectedList.isEmpty() || game.tagList.containsAll(filter.tagSelectedList)) &&
                        // Filter by difficulty level (if a difficulty is selected)
                        (filter.difficultyLevel == null || game.difficultyLevel == filter.difficultyLevel)
            }
        }
    }
}
