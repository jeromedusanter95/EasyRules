package com.jeromedusanter.youonlyneedcards.ui.shared_components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jeromedusanter.youonlyneedcards.ui.theme.colorAccent
import com.jeromedusanter.youonlyneedcards.ui.theme.colorGrayLight
import com.jeromedusanter.youonlyneedcards.ui.theme.colorPrimaryDark

@Composable
fun HorizontalProgressBarWithGradient(
    modifier: Modifier = Modifier,
    startColor: Color = colorAccent,
    endColor: Color = colorPrimaryDark,
    height: Dp = 16.dp,
    targetProgress: Float,
) {
    var progress by remember { mutableFloatStateOf(0f) }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearOutSlowInEasing
        )
    )

    // Trigger the animation when composable enters the composition
    LaunchedEffect(targetProgress) {
        progress = targetProgress
    }
    val gradientBrush = Brush.horizontalGradient(colors = listOf(startColor, endColor))
    Canvas(modifier = modifier.height(height)) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawRoundRect(
            color = colorGrayLight,
            size = Size(canvasWidth, canvasHeight),
            cornerRadius = CornerRadius((height / 2).toPx(), (height / 2).toPx())
        )
        drawRoundRect(
            brush = gradientBrush,
            size = Size(canvasWidth * animatedProgress, canvasHeight),
            cornerRadius = CornerRadius((height / 2).toPx(), (height / 2).toPx())
        )
    }
}