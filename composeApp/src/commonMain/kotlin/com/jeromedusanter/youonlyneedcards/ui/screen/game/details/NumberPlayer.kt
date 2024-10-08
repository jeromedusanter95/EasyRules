package com.jeromedusanter.youonlyneedcards.ui.screen.game.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.jeromedusanter.youonlyneedcards.ui.theme.colorDarkBlue
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.ic_number_players_with_background
import org.jetbrains.compose.resources.painterResource

@Composable
fun NumberPlayer(modifier: Modifier = Modifier, minPlayer: Int, maxPlayer: Int) {
    Box {
        Image(
            modifier = modifier.size(80.dp),
            painter = painterResource(Res.drawable.ic_number_players_with_background),
            contentDescription = null
        )
        Text(
            text = if (minPlayer == maxPlayer) minPlayer.toString() else "$minPlayer-$maxPlayer",
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 6.dp),
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