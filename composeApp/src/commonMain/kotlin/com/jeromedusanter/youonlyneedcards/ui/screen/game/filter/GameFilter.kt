package com.jeromedusanter.youonlyneedcards.ui.screen.game.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.youonlyneedcards.ui.theme.colorAccent
import com.jeromedusanter.youonlyneedcards.ui.theme.colorPrimaryDark
import com.jeromedusanter.youonlyneedcards.ui.theme.colorWhite
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_filter_switch_apply_filter
import easyrules.composeapp.generated.resources.game_filter_title
import org.jetbrains.compose.resources.stringResource

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
    onToggleApplyFilter: (Boolean) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorAccent,
                        colorPrimaryDark
                    )
                )
            )
            .padding(16.dp),
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = stringResource(Res.string.game_filter_title),
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = 40.sp,
                    lineHeight = 53.sp,
                    color = Color.White,
                )
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(Res.string.game_filter_switch_apply_filter),
                    color = colorWhite
                )
                Spacer(modifier = Modifier.width(8.dp))
                Switch(
                    checked = shouldApplyFilter,
                    onCheckedChange = onToggleApplyFilter,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = colorAccent,
                        checkedTrackColor = colorWhite,
                        uncheckedThumbColor = colorAccent,
                        uncheckedTrackColor = colorWhite,
                        disabledCheckedThumbColor = colorWhite,
                        disabledCheckedTrackColor = colorWhite,
                        disabledUncheckedThumbColor = colorWhite,
                        disabledUncheckedTrackColor = colorWhite,
                    ),
                    /*interactionSource = {
                        if (shouldApplyFilter) Icon(
                            painter = painterResource(Res.drawable.baseline_check_24),
                            contentDescription = null
                        ) else Icon(
                            painter = painterResource(Res.drawable.baseline_close_24),
                            contentDescription = null
                        )
                    }*/
                )
            }
        }
        Column(
            modifier = modifier
                .fillMaxSize()
                .alpha(
                    if (shouldApplyFilter) 1f else 0.4f
                ),
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
}
