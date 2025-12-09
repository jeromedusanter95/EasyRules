package com.jeromedusanter.easyrules.ui.screen.game.filter

data class GameFilterUiModel(
    val numberOfPlayers: Int,
    val gameTagIdSelected: List<Int>,
    val durationRange: IntRange,
    val gameDifficultyLevel: GameDifficultyLevelUiModel?,
)