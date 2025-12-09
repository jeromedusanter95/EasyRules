package com.jeromedusanter.easyrules.ui.screen.game.filter

import com.jeromedusanter.easyrules.domain.GameDifficultyLevelModel
import com.jeromedusanter.easyrules.domain.GameFilterModel
import com.jeromedusanter.easyrules.ui.screen.game.GameTagMapper

class GameFilterMapper(private val gameTagMapper: GameTagMapper) {

    fun mapDomainModelToUiModel(
        model: GameFilterModel,
    ): GameFilterUiModel {
        return GameFilterUiModel(
            numberOfPlayers = model.numberOfPlayers,
            gameTagIdSelected = model.tagSelectedList.map { gameTagMapper.mapDomainModelToUiModel(it).ordinal },
            durationRange = model.durationRange,
            gameDifficultyLevel = mapDomainModelToUiModel(model.difficultyLevel),
        )
    }

    private fun mapDomainModelToUiModel(model: GameDifficultyLevelModel?): GameDifficultyLevelUiModel? {
        return when (model) {
            GameDifficultyLevelModel.EASY -> GameDifficultyLevelUiModel.EASY
            GameDifficultyLevelModel.MEDIUM -> GameDifficultyLevelUiModel.MEDIUM
            GameDifficultyLevelModel.HARD -> GameDifficultyLevelUiModel.HARD
            null -> null
        }
    }

    fun mapUiModelToDomainModel(model: GameDifficultyLevelUiModel?): GameDifficultyLevelModel? {
        return when (model) {
            GameDifficultyLevelUiModel.EASY -> GameDifficultyLevelModel.EASY
            GameDifficultyLevelUiModel.MEDIUM -> GameDifficultyLevelModel.MEDIUM
            GameDifficultyLevelUiModel.HARD -> GameDifficultyLevelModel.HARD
            else -> null
        }
    }
}