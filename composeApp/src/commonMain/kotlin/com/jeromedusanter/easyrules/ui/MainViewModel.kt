package com.jeromedusanter.easyrules.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeromedusanter.easyrules.data.repository.GameRepository
import com.jeromedusanter.easyrules.domain.GameFilterModel
import com.jeromedusanter.easyrules.domain.features.game.ApplyFilterUseCase
import com.jeromedusanter.easyrules.domain.features.game.GetGameListUseCase
import com.jeromedusanter.easyrules.domain.features.game.UpdateGameFilterUseCase
import com.jeromedusanter.easyrules.domain.features.game.UpdateSearchQueryUseCase
import com.jeromedusanter.easyrules.ui.screen.game.details.GameDetailsMapper
import com.jeromedusanter.easyrules.ui.screen.game.details.GameDetailsUiModel
import com.jeromedusanter.easyrules.ui.screen.game.filter.GameDifficultyLevelUiModel
import com.jeromedusanter.easyrules.ui.screen.game.filter.GameFilterMapper
import com.jeromedusanter.easyrules.ui.screen.game.filter.GameFilterUiModel
import com.jeromedusanter.easyrules.ui.screen.game.list.GameListItemUiModel
import com.jeromedusanter.easyrules.ui.screen.game.list.GameListMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * Main ViewModel for the application.
 * Manages UI state and coordinates between use cases and UI.
 */
class MainViewModel(
    private val repository: GameRepository,
    private val getGameListUseCase: GetGameListUseCase,
    private val gameListMapper: GameListMapper,
    private val gameDetailsMapper: GameDetailsMapper,
    private val gameFilterMapper: GameFilterMapper,
    private val updateGameFilterUseCase: UpdateGameFilterUseCase,
    private val updateSearchQueryUseCase: UpdateSearchQueryUseCase,
    private val applyFilterUseCase: ApplyFilterUseCase
) : ViewModel() {

    val gameListUiModel: StateFlow<List<GameListItemUiModel>> =
        repository.games.map { list ->
            list.map { gameListMapper.mapDomainModelToUiModel(it) }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = emptyList()
        )

    val gameListSize: StateFlow<Int> = gameListUiModel.map { it.size }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = 0
        )

    private val _gameIdSelected = MutableStateFlow<Int?>(null)
    val gameUiDetailsSelected: StateFlow<GameDetailsUiModel?> =
        _gameIdSelected.combine(repository.games) { id, list ->
            val game = list.find { it.id == id }
            game?.let { gameDetailsMapper.mapDomainModelToUiModel(it) }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = null
        )

    val currentFilter: StateFlow<GameFilterUiModel?> =
        repository.gameFilter.map { filter ->
            gameFilterMapper.mapDomainModelToUiModel(filter)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = gameFilterMapper.mapDomainModelToUiModel(
                model = GameFilterModel.INITIAL_STATE,
            )
        )

    private val _showSearchBar = MutableStateFlow(false)
    val showSearchBar = _showSearchBar.asStateFlow()

    val searchQuery: StateFlow<String> = repository.searchQuery.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = ""
    )

    val shouldApplyFilters: StateFlow<Boolean> = repository.shouldApplyFilter.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = false
    )

    init {
        viewModelScope.launch {
            getGameListUseCase.execute()
        }
    }

    fun selectGame(id: Int?) {
        _gameIdSelected.value = id
    }

    fun updateNumberOfPlayersInFilters(numberOfPlayers: Int) {
        updateGameFilterUseCase.updateNumberOfPlayers(numberOfPlayers)
    }

    fun updateTagListInFilters(i: Int) {
        updateGameFilterUseCase.updateTagList(i)
    }

    fun updateDurationRangeInFilters(durationRange: IntRange) {
        updateGameFilterUseCase.updateDurationRange(durationRange)
    }

    fun updateDifficultyLevelInFilters(gameDifficultyLevelUiModel: GameDifficultyLevelUiModel) {
        updateGameFilterUseCase.updateDifficultyLevel(
            gameFilterMapper.mapUiModelToDomainModel(gameDifficultyLevelUiModel)
        )
    }

    fun updateSearchQueryInFilters(query: String) {
        updateSearchQueryUseCase.updateSearchQuery(query)
    }

    fun clearSearchQueryInFilters() {
        updateSearchQueryUseCase.clearSearchQuery()
    }

    fun clearFilters() {
        updateGameFilterUseCase.clearFilters()
    }

    fun toggleShouldApplyFilters(shouldApplyFilter: Boolean) {
        applyFilterUseCase.execute(shouldApplyFilter)
    }

    fun toggleShowSearchBarVisibility() {
        _showSearchBar.value = !_showSearchBar.value
    }
}