package com.jeromedusanter.youonlyneedcards.ui.screen.game

import com.jeromedusanter.youonlyneedcards.domain.GameDifficultyLevelModel

class GameDifficultyLevelMapper {

    fun mapDomainModelToUiModel(model: GameDifficultyLevelModel): GameDifficultyLevelUiModel {
        return when (model) {
            GameDifficultyLevelModel.EASY -> GameDifficultyLevelUiModel.EASY
            GameDifficultyLevelModel.MEDIUM -> GameDifficultyLevelUiModel.MEDIUM
            GameDifficultyLevelModel.HARD -> GameDifficultyLevelUiModel.HARD
        }
    }
}