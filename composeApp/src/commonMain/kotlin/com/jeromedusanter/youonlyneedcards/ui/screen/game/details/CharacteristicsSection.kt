package com.jeromedusanter.youonlyneedcards.ui.screen.game.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.youonlyneedcards.ui.screen.game.GameDifficultyLevelUiModel
import com.jeromedusanter.youonlyneedcards.ui.theme.colorDarkBlue
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.default_background_rounded_gradient
import easyrules.composeapp.generated.resources.ic_difficulty
import easyrules.composeapp.generated.resources.ic_duration
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun CharacteristicsSection(
    modifier: Modifier = Modifier,
    minPlayer: Int,
    maxPlayer: Int,
    duration: String,
    gameDifficultyLevelUiModel: GameDifficultyLevelUiModel
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        NumberPlayer(minPlayer = minPlayer, maxPlayer = maxPlayer)
        Characteristic(text = duration, res = Res.drawable.ic_duration)
        Characteristic(
            text = stringResource(gameDifficultyLevelUiModel.res),
            res = Res.drawable.ic_difficulty
        )
    }
}

@Composable
fun Characteristic(modifier: Modifier = Modifier, text: String, res: DrawableResource) {
    Box {
        Image(
            modifier = modifier.size(80.dp),
            painter = painterResource(Res.drawable.default_background_rounded_gradient),
            contentDescription = null
        )
        Icon(
            tint = colorDarkBlue,
            painter = painterResource(res),
            contentDescription = null,
            modifier = modifier
                .size(75.dp)
                .align(Alignment.Center)
                .padding(bottom = 12.dp)
        )
        Text(
            text = text,
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = colorDarkBlue,
                textAlign = TextAlign.Center
            )
        )
    }
}