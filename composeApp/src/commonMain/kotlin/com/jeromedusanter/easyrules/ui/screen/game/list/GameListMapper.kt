package com.jeromedusanter.easyrules.ui.screen.game.list

import com.jeromedusanter.easyrules.domain.GameModel
import com.jeromedusanter.easyrules.ui.screen.game.GameTagMapper

class GameListMapper(private val gameTagMapper: GameTagMapper) {

    fun mapDomainModelToUiModel(game: GameModel): GameListItemUiModel {
        return GameListItemUiModel(
            id = game.id,
            name = game.name,
            overview = game.goal,
            tagUiModelList = game.tagList.map { gameTagMapper.mapDomainModelToUiModel(it) }
        )
    }
}