package com.jeromedusanter.easyrules.ui.screen.game.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.jeromedusanter.easyrules.ui.theme.colorWhite

@Composable
fun GameFilter(
    modifier: Modifier = Modifier,
    gameFilterUiModel: GameFilterUiModel,
    shouldApplyFilter: Boolean = false,
    gameListSize: Int = 0,
    onPlayersValueChange: (Int) -> Unit = {},
    onClickTag: (Int) -> Unit = {},
    onDurationValueChange: (IntRange) -> Unit = {},
    onDifficultyLevelChange: (GameDifficultyLevelUiModel) -> Unit = {},
    onClickButtonSeeGames: () -> Unit = {},
    onClickButtonClearFilters: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorWhite)
            .padding(16.dp)
            .alpha(if (shouldApplyFilter) 1f else 0.4f),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GameFilterPlayersSection(
            value = gameFilterUiModel.numberOfPlayers,
            onValueChange = onPlayersValueChange,
            enabled = shouldApplyFilter
        )
        GameFilterTagListSection(
            gameTagIdSelected = gameFilterUiModel.gameTagIdSelected,
            onClickTag = onClickTag,
            enabled = shouldApplyFilter
        )
        GameFilterDuration(
            value = gameFilterUiModel.durationRange,
            onValueChange = onDurationValueChange,
            enabled = shouldApplyFilter
        )
        GameFilterDifficultyLevelSection(
            onDifficultyLevelChange = onDifficultyLevelChange,
            selectedDifficultyLevel = gameFilterUiModel.gameDifficultyLevel,
            enabled = shouldApplyFilter
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            GameFilterClearFilters(
                onClick = onClickButtonClearFilters,
                enabled = shouldApplyFilter
            )
            GameFilterButtonSeeGames(
                gameListSize = gameListSize,
                onClick = onClickButtonSeeGames,
                enabled = shouldApplyFilter
            )
        }
    }
}
