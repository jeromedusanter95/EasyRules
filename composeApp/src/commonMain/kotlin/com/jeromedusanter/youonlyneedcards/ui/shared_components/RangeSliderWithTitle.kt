package com.jeromedusanter.youonlyneedcards.ui.shared_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RangeSliderWithTitle(
    modifier: Modifier = Modifier,
    range: IntRange,
    value: IntRange,
    onValueChange: (IntRange) -> Unit = {},
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
    RangeSlider(
        enabled = enabled,
        value = value.toFloatRange(),
        onValueChange = { floatRange ->
            val newValue = floatRange
                .toIntRange()
                .snapToNearestStep(5) // Snap to nearest 5-minute step
            onValueChange(newValue)
        },
        valueRange = range.toFloatRange(),
        steps = ((range.last - range.first) / 5) - 1, // Adds steps for 5-minute increments
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

private fun ClosedFloatingPointRange<Float>.toIntRange(): IntRange {
    return this.start.toInt()..this.endInclusive.toInt()
}

private fun IntRange.snapToNearestStep(step: Int): IntRange {
    val snappedStart = (this.first / step) * step
    val snappedEnd = (this.last / step) * step
    return snappedStart..snappedEnd
}