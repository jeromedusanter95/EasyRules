package com.jeromedusanter.easyrules.domain

data class GameModel(
    val id: Int,
    val name: String,
    val tagList: List<GameTagModel>,
    val minPlayer: Int,
    val maxPlayer: Int,
    val goal: String,
    val material: String,
    val howToPlay: String,
    val durationInMinutes: Int,
    val variants: String? = null,
    val end: String,
    val difficultyLevel: GameDifficultyLevelModel,
    val tutorialSteps: List<String> = emptyList()
)

enum class GameTagModel {
    CARDS,
    DICE,
    NO_MATERIAL,
    TEAM,
    ELIMINATION,
    HIDDEN_IDENTITY,
    DRINKS,
    TRICKS
}

enum class GameDifficultyLevelModel {
    EASY, MEDIUM, HARD
}

data class GameFilterModel(
    val numberOfPlayers: Int,
    val durationRange: IntRange,
    val tagSelectedList: List<GameTagModel>,
    val difficultyLevel: GameDifficultyLevelModel?,
) {
    companion object {
        val INITIAL_STATE = GameFilterModel(
            numberOfPlayers = 4,
            durationRange = 10..240,
            tagSelectedList = listOf(),
            difficultyLevel = null
        )
    }
}
