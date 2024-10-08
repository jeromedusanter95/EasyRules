package com.jeromedusanter.youonlyneedcards.ui.shared_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun SliderWithTitle(
    modifier: Modifier = Modifier,
    range: IntRange,
    value: Int,
    onValueChange: (Int) -> Unit = {},
    title: @Composable () -> Unit = {},
    enabled: Boolean = true
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = range.first.toString(),
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
        title()
        Text(
            text = range.last.toString(),
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
    Slider(
        enabled = enabled,
        value = value.toFloat(),
        onValueChange = { newValue -> onValueChange(newValue.toInt()) },
        valueRange = range.toFloatRange(),
        colors = SliderDefaults.colors(
            thumbColor = Color.White,
            activeTrackColor = Color.White,
            inactiveTrackColor = Color(0x55FFFFFF),
            disabledThumbColor = Color.White,
            disabledActiveTrackColor = Color.White,
            disabledInactiveTrackColor = Color(0x55FFFFFF)
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

private fun IntRange.toFloatRange(): ClosedFloatingPointRange<Float> {
    return this.first.toFloat()..this.last.toFloat()
}