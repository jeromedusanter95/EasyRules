package com.jeromedusanter.easyrules.ui.screen.game

import com.jeromedusanter.easyrules.domain.GameTagModel

class GameTagMapper {

    fun mapDomainModelToUiModel(model: GameTagModel): GameTagUiModel {
        return when (model) {
            GameTagModel.CARDS -> GameTagUiModel.CARDS
            GameTagModel.DICE -> GameTagUiModel.DICE
            GameTagModel.NO_MATERIAL -> GameTagUiModel.NO_MATERIAL
            GameTagModel.TEAM -> GameTagUiModel.TEAM
            GameTagModel.ELIMINATION -> GameTagUiModel.ELIMINATION
            GameTagModel.HIDDEN_IDENTITY -> GameTagUiModel.HIDDEN_IDENTITY
            GameTagModel.DRINKS -> GameTagUiModel.DRINKS
            GameTagModel.TRICKS -> GameTagUiModel.TRICK
        }
    }
}