package com.jeromedusanter.easyrules.domain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine

object ApplicationState {
    internal val _gameFilter = MutableStateFlow(GameFilterModel.INITIAL_STATE)
    val gameFilter = _gameFilter.asStateFlow()

    internal val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    internal val _shouldApplyFilter = MutableStateFlow(false)
    val shouldApplyFilter = _shouldApplyFilter.asStateFlow()

    internal val _gameList = MutableStateFlow<List<GameModel>>(emptyList())
    val gameList = combine(
        _gameFilter,
        _gameList,
        _searchQuery,
        shouldApplyFilter
    ) { filter, list, searchQuery, shouldApplyFilter ->

        if (!shouldApplyFilter) {
            return@combine list.filter { game ->
                game.name.contains(
                    searchQuery,
                    ignoreCase = true
                )
            }
        } else {
            return@combine list.filter { game ->
                game.name.contains(searchQuery, ignoreCase = true) &&

                        // Check if the exact number of players is within the game's allowed range
                        game.minPlayer <= filter.numberOfPlayers && game.maxPlayer >= filter.numberOfPlayers &&

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