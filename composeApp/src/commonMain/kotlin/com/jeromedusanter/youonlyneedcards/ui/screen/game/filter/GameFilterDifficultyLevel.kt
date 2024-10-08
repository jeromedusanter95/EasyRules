package com.jeromedusanter.youonlyneedcards.ui.screen.game.filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.youonlyneedcards.ui.theme.colorPurple
import com.jeromedusanter.youonlyneedcards.ui.theme.colorWhite
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_details_difficulty_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun GameFilterDifficultyLevelSection(
    modifier: Modifier = Modifier,
    onDifficultyLevelChange: (GameDifficultyLevelUiModel) -> Unit = {},
    selectedDifficultyLevel: GameDifficultyLevelUiModel? = null,
    enabled: Boolean = false
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = stringResource(Res.string.game_details_difficulty_title),
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(8.dp))
        DifficultyLevel(
            onClick = onDifficultyLevelChange,
            selectedDifficultyLevel = selectedDifficultyLevel,
            enabled = enabled
        )
    }
}

@Composable
private fun DifficultyLevel(
    onClick: (GameDifficultyLevelUiModel) -> Unit = {},
    selectedDifficultyLevel: GameDifficultyLevelUiModel?,
    enabled: Boolean
) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(GameDifficultyLevelUiModel.entries) {
            Button(
                enabled = enabled,
                onClick = { onClick(it) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (it == selectedDifficultyLevel) Color.White else Color(
                        0x33FFFFFF
                    ),
                    contentColor = if (it == selectedDifficultyLevel) Color(0xFF6200EE) else Color.White,
                    disabledBackgroundColor = if (it == selectedDifficultyLevel) Color.White else Color(
                        0x33FFFFFF
                    ),
                    disabledContentColor = if (it == selectedDifficultyLevel) Color(0xFF6200EE) else Color.White
                ),
                shape = RoundedCornerShape(12.dp),
            ) {
                Text(
                    text = stringResource(it.res),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (it == selectedDifficultyLevel) colorPurple else colorWhite
                )
            }
        }
    }
}