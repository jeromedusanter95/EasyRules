package com.jeromedusanter.youonlyneedcards.ui.screen.game.filter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.jeromedusanter.youonlyneedcards.ui.shared_components.RangeSliderWithTitle
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_details_duration_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun GameFilterDuration(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    value: IntRange,
    onValueChange: (IntRange) -> Unit = {}
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(Res.string.game_details_duration_title),
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        DurationRangeSlider(
            value = value,
            onValueChange = onValueChange,
            enabled = enabled
        )
    }
}

@Composable
private fun DurationRangeSlider(
    value: IntRange,
    onValueChange: (IntRange) -> Unit = {},
    enabled: Boolean = true
) {
    RangeSliderWithTitle(
        enabled = enabled,
        range = 10..240,
        onValueChange = onValueChange,
        value = value,
        title = {
            DurationRangeSliderTitle(
                startRangeAsString = value.first.toString(),
                endRangeAsString = value.last.toString()
            )
        }
    )
}

@Composable
private fun DurationRangeSliderTitle(
    modifier: Modifier = Modifier,
    startRangeAsString: String,
    endRangeAsString: String
) {
    Row {
        Text(
            text = startRangeAsString,
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                lineHeight = 21.sp,
            )
        )
        Text(
            text = " à ",
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W300,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                lineHeight = 21.sp,
            )
        )
        Text(
            text = endRangeAsString,
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                lineHeight = 21.sp,
            )
        )
        Text(
            text = " minutes", style = TextStyle(
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