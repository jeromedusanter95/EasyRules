package com.jeromedusanter.youonlyneedcards.ui.screen.game.list

import com.jeromedusanter.youonlyneedcards.ui.screen.game.GameTagUiModel

data class GameListItemUiModel(
    val id: Int,
    val name: String,
    val overview: String,
    val tagUiModelList: List<GameTagUiModel>
)
