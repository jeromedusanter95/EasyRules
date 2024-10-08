package com.jeromedusanter.youonlyneedcards.ui.screen.game.filter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.youonlyneedcards.ui.shared_components.SliderWithTitle
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_filter_players_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun GameFilterPlayersSection(
    modifier: Modifier = Modifier,
    value: Int,
    onValueChange: (Int) -> Unit = {},
    enabled: Boolean = true
) {
    Column {
        Text(
            text = stringResource(Res.string.game_filter_players_title),
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        PlayerRangeSlider(value, onValueChange, enabled)
    }
}

@Composable
private fun PlayerRangeSlider(
    value: Int,
    onValueChange: (Int) -> Unit,
    enabled: Boolean
) {
    SliderWithTitle(
        enabled = enabled,
        range = 1..20,
        onValueChange = onValueChange,
        value = value,
        title = { PlayerSliderTitle(numberOfPlayersAsString = value.toString()) }
    )
}

@Composable
private fun PlayerSliderTitle(
    modifier: Modifier = Modifier,
    numberOfPlayersAsString: String
) {
    Row {
        Text(
            text = numberOfPlayersAsString,
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                lineHeight = 21.sp,
            )
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = stringResource(Res.string.game_filter_players_title).toLowerCase(),
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W300,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                lineHeight = 21.sp,
                letterSpacing = 0.sp,
            )
        )
    }
}