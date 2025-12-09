package com.jeromedusanter.easyrules.ui.screen.game

import com.jeromedusanter.easyrules.domain.GameDifficultyLevelModel

class GameDifficultyLevelMapper {

    fun mapDomainModelToUiModel(model: GameDifficultyLevelModel): GameDifficultyLevelUiModel {
        return when (model) {
            GameDifficultyLevelModel.EASY -> GameDifficultyLevelUiModel.EASY
            GameDifficultyLevelModel.MEDIUM -> GameDifficultyLevelUiModel.MEDIUM
            GameDifficultyLevelModel.HARD -> GameDifficultyLevelUiModel.HARD
        }
    }
}