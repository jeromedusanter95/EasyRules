package com.jeromedusanter.youonlyneedcards.ui.screen.game.filter

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.youonlyneedcards.ui.theme.colorDarkBlue
import com.jeromedusanter.youonlyneedcards.ui.theme.colorTransparent
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_filter_button_clear_filters_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun GameFilterClearFilters(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Button(
        enabled = enabled,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = colorTransparent, disabledContainerColor = colorTransparent),
        modifier = modifier
            .padding(horizontal = 16.dp)
            .border(width = 1.dp, color = colorDarkBlue, shape = RoundedCornerShape(24.dp))
            .height(48.dp)
    ) {
        Text(
            text = stringResource(Res.string.game_filter_button_clear_filters_title),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorDarkBlue
        )
    }
}