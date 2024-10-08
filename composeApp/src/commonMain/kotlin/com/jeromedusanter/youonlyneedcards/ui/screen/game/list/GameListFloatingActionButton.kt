package com.jeromedusanter.youonlyneedcards.ui.screen.game.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jeromedusanter.youonlyneedcards.ui.theme.colorAccent
import com.jeromedusanter.youonlyneedcards.ui.theme.colorPrimaryDark
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.ic_filters
import org.jetbrains.compose.resources.painterResource

@Composable
fun GameListFloatingActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = onClick,
        contentColor = Color.White,
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .size(70.dp)
            .clip(CircleShape)
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_filters),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            colorAccent,
                            colorPrimaryDark
                        ),
                    )
                )
                .padding(8.dp)
        )
    }
}

