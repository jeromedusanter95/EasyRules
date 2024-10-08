package com.jeromedusanter.youonlyneedcards.ui.screen.game.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.youonlyneedcards.ui.MainViewModel
import com.jeromedusanter.youonlyneedcards.ui.shared_components.CompottieAnimationByName
import com.jeromedusanter.youonlyneedcards.ui.theme.colorDarkBlue
import com.jeromedusanter.youonlyneedcards.ui.theme.colorWhite
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_list_empty_subtitle
import easyrules.composeapp.generated.resources.game_list_empty_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun GameListScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
    onGameClick: (Int) -> Unit
) {
    val uiModelList by viewModel.gameListUiModel.collectAsState()
    if (uiModelList.isEmpty()) {
        EmptyGameList(modifier = modifier)
    } else {
        GameList(list = uiModelList, onClick = onGameClick)
    }
}

@Composable
private fun EmptyGameList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorDarkBlue)
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CompottieAnimationByName(
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                fileName = "lottie_empty",
            )
            Text(
                text = stringResource(Res.string.game_list_empty_title),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = colorWhite
            )
            Text(
                text = stringResource(Res.string.game_list_empty_subtitle),
                textAlign = TextAlign.Center,
                color = colorWhite
            )
        }
    }
}