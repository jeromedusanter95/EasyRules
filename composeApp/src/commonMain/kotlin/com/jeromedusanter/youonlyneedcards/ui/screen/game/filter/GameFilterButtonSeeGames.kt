package com.jeromedusanter.youonlyneedcards.ui.screen.game.filter

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.youonlyneedcards.ui.theme.colorPurple
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_filter_button_see_games_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun GameFilterButtonSeeGames(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    gameListSize: Int = 0,
    onClick: () -> Unit = {},
) {
    Button(
        enabled = enabled,
        onClick = { onClick() },
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = colorPurple,
            disabledContentColor = colorPurple,
            disabledBackgroundColor = Color.White
        ),
        modifier = modifier
            .height(48.dp)
    ) {
        Text(
            text = stringResource(Res.string.game_filter_button_see_games_title, gameListSize),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorPurple
        )
    }
}