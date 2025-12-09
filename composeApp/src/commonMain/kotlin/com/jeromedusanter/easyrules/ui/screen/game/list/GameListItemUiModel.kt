package com.jeromedusanter.easyrules.ui.screen.game.list

import com.jeromedusanter.easyrules.ui.screen.game.GameTagUiModel

data class GameListItemUiModel(
    val id: Int,
    val name: String,
    val overview: String,
    val tagUiModelList: List<GameTagUiModel>
)
