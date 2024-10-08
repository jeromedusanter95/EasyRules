package com.jeromedusanter.youonlyneedcards.ui.screen.game.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jeromedusanter.youonlyneedcards.ui.shared_components.HorizontalProgressBarWithGradient
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_details_difficulty_title
import easyrules.composeapp.generated.resources.game_details_lucky_title
import easyrules.composeapp.generated.resources.game_details_strategic_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun GeneralSection(
    modifier: Modifier = Modifier,
    difficultyGradeOnFive: Int,
    luckyGradeOnFive: Int,
    strategicGradeOnFive: Int,
) {
    val difficultyProgress = difficultyGradeOnFive / 5f
    val luckyProgress = luckyGradeOnFive / 5f
    val strategicProgress = strategicGradeOnFive / 5f

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(Res.string.game_details_difficulty_title),
            style = MaterialTheme.typography.h2
        )
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalProgressBarWithGradient(
            modifier = modifier.fillMaxWidth(),
            targetProgress = difficultyProgress
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(Res.string.game_details_lucky_title),
            style = MaterialTheme.typography.h2
        )
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalProgressBarWithGradient(
            modifier = modifier.fillMaxWidth(),
            targetProgress = luckyProgress
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(Res.string.game_details_strategic_title),
            style = MaterialTheme.typography.h2
        )
        HorizontalProgressBarWithGradient(
            modifier = modifier.fillMaxWidth(),
            targetProgress = strategicProgress
        )
    }
}