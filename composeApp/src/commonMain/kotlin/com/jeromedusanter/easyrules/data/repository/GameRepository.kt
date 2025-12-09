package com.jeromedusanter.easyrules.data.repository

import com.jeromedusanter.easyrules.domain.GameDifficultyLevelModel
import com.jeromedusanter.easyrules.domain.GameFilterModel
import com.jeromedusanter.easyrules.domain.GameModel
import com.jeromedusanter.easyrules.domain.GameTagModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface GameRepository {
    /**
     * Observable flow of filtered game list based on current filters.
     */
    val games: Flow<List<GameModel>>

    /**
     * Observable flow of the current game filter state.
     */
    val gameFilter: StateFlow<GameFilterModel>

    /**
     * Observable flow of the search query.
     */
    val searchQuery: StateFlow<String>

    /**
     * Observable flow indicating whether filters should be applied.
     */
    val shouldApplyFilter: StateFlow<Boolean>

    /**
     * Loads the game list based on locale.
     * @param locale The language code (e.g., "fr", "en")
     */
    suspend fun loadGames(locale: String)

    /**
     * Updates the number of players filter.
     * @param numberOfPlayers The desired number of players
     */
    fun updateNumberOfPlayers(numberOfPlayers: Int)

    /**
     * Updates the duration range filter.
     * @param durationRange The duration range in minutes
     */
    fun updateDurationRange(durationRange: IntRange)

    /**
     * Updates or toggles the difficulty level filter.
     * @param difficultyLevel The difficulty level to set/toggle
     */
    fun updateDifficultyLevel(difficultyLevel: GameDifficultyLevelModel?)

    /**
     * Toggles a tag in the tag list filter.
     * @param tag The tag to add or remove
     */
    fun toggleTag(tag: GameTagModel)

    /**
     * Updates the search query.
     * @param query The search text
     */
    fun updateSearchQuery(query: String)

    /**
     * Clears the search query.
     */
    fun clearSearchQuery()

    /**
     * Resets all filters to their initial state.
     */
    fun clearFilters()

    /**
     * Toggles whether filters should be applied.
     * @param shouldApply Whether to apply filters
     */
    fun setShouldApplyFilter(shouldApply: Boolean)
}
