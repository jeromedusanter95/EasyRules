package com.jeromedusanter.easyrules.ui.screen.game.filter

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.easyrules.ui.theme.colorDarkBlue
import com.jeromedusanter.easyrules.ui.theme.colorWhite
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
        modifier = modifier.height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorDarkBlue,
            disabledContainerColor = colorDarkBlue.copy(alpha = 0.5f)
        )
    ) {
        Text(
            text = stringResource(Res.string.game_filter_button_see_games_title, gameListSize),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorWhite
        )
    }
}