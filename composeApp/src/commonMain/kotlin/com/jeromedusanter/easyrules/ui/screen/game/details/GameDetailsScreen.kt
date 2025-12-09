package com.jeromedusanter.easyrules.ui.screen.game.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.jeromedusanter.easyrules.ui.MainViewModel

@Composable
fun GameDetailScreen(
    modifier: Modifier = Modifier,
    gameId: Int?,
    viewModel: MainViewModel,
) {

    viewModel.selectGame(gameId)

    val gameDetailsUiModelOrNull by viewModel.gameUiDetailsSelected.collectAsState()
    val uiModel = gameDetailsUiModelOrNull ?: return

    GameDetails(
        modifier,
        title = uiModel.name,
        goal = uiModel.goal,
        material = uiModel.material,
        howToPlay = uiModel.howToPlay,
        variants = uiModel.variants,
        duration = uiModel.duration,
        difficultyLevel = uiModel.difficultyLevel,
        gameTagUiModelList = uiModel.tagUiModelList,
        minPlayer = uiModel.minPlayer,
        maxPLayer = uiModel.maxPlayer,
        end = uiModel.end
    )
}