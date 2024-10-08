package com.jeromedusanter.youonlyneedcards.ui.screen.game.filter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.jeromedusanter.youonlyneedcards.ui.MainViewModel

@Composable
fun GameFilterScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    onClickButtonSeeGames: () -> Unit
) {
    val currentFilter by viewModel.currentFilter.collectAsState()
    val gameListSize by viewModel.gameListSize.collectAsState()
    val shouldApplyFilters by viewModel.shouldApplyFilters.collectAsState()

    currentFilter?.let {
        GameFilter(
            gameFilterUiModel = it,
            gameListSize = gameListSize,
            shouldApplyFilter = shouldApplyFilters,
            onPlayersValueChange = viewModel::updateNumberOfPlayersInFilters,
            onClickTag = viewModel::updateTagListInFilters,
            onDurationValueChange = viewModel::updateDurationRangeInFilters,
            onDifficultyLevelChange = viewModel::updateDifficultyLevelInFilters,
            onClickButtonSeeGames = onClickButtonSeeGames,
            onClickButtonClearFilters = viewModel::clearFilters,
            onToggleApplyFilter = viewModel::toggleShouldApplyFilters
        )
    }
}