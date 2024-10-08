package com.jeromedusanter.youonlyneedcards.ui.screen.game.details

import com.jeromedusanter.youonlyneedcards.ui.screen.game.GameDifficultyLevelUiModel
import com.jeromedusanter.youonlyneedcards.ui.screen.game.GameTagUiModel

data class GameDetailsUiModel(
    val name: String,
    val goal: String,
    val end: String,
    val minPlayer: Int,
    val maxPlayer: Int,
    val duration: String,
    val tagUiModelList: List<GameTagUiModel>,
    val difficultyLevel: GameDifficultyLevelUiModel,
    val material: String,
    val howToPlay: String,
    val variants: String? = null,
)
