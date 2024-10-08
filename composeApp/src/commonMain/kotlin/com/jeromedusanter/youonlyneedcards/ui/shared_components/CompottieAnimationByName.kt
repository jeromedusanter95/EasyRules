package com.jeromedusanter.youonlyneedcards.ui.shared_components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import easyrules.composeapp.generated.resources.Res
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.animateLottieCompositionAsState
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun CompottieAnimationByName(
    modifier: Modifier = Modifier,
    fileName: String,
    infiniteLoop: Boolean = true
) {
    val composition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/$fileName.json").decodeToString()
        )
    }
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = if (infiniteLoop) Compottie.IterateForever else 1,
    )

    Image(
        modifier = modifier,
        painter = rememberLottiePainter(
            composition = composition,
            progress = { progress },
        ),
        contentDescription = "Lottie animation"
    )
}