package com.jeromedusanter.easyrules.ui.screen.game.filter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.easyrules.ui.theme.colorDarkBlue
import com.jeromedusanter.easyrules.ui.theme.colorTransparent
import com.jeromedusanter.easyrules.ui.theme.colorWhite
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
            color = colorDarkBlue
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
            val selected = selectedDifficultyLevel == it
            FilterChip(
                enabled = enabled,
                onClick = { onClick(it) },
                label = { Text(text = stringResource(it.res), fontSize = 16.sp) },
                border = BorderStroke(width = 1.dp, color = colorDarkBlue),
                selected = selected,
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = colorTransparent,
                    labelColor = colorDarkBlue,
                    selectedContainerColor = colorDarkBlue,
                    selectedLabelColor = colorWhite,
                    selectedLeadingIconColor = colorWhite,
                    disabledLabelColor = if (selected) colorWhite else colorDarkBlue
                ),
            )
        }
    }
}