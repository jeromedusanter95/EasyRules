package com.jeromedusanter.youonlyneedcards.ui.screen.game.details

import com.jeromedusanter.youonlyneedcards.domain.GameModel
import com.jeromedusanter.youonlyneedcards.ui.screen.game.GameDifficultyLevelMapper
import com.jeromedusanter.youonlyneedcards.ui.screen.game.GameTagMapper

class GameDetailsMapper(
    private val gameTagMapper: GameTagMapper,
    private val gameDifficultyLevelMapper: GameDifficultyLevelMapper
) {

    fun mapDomainModelToUiModel(game: GameModel): GameDetailsUiModel {
        return GameDetailsUiModel(
            name = game.name,
            goal = game.goal,
            minPlayer = game.minPlayer,
            maxPlayer = game.maxPlayer,
            duration = "${game.durationInMinutes}min",
            tagUiModelList = game.tagList.map { gameTagMapper.mapDomainModelToUiModel(it) },
            difficultyLevel = gameDifficultyLevelMapper.mapDomainModelToUiModel(game.difficultyLevel),
            howToPlay = game.howToPlay,
            variants = game.variants,
            material = game.material,
            end = game.end
        )
    }
}