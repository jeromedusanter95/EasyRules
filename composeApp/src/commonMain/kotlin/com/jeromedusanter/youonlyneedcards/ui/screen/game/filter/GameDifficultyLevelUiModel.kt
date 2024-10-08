package com.jeromedusanter.youonlyneedcards.ui.screen.game.filter

import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_difficulty_level_easy
import easyrules.composeapp.generated.resources.game_difficulty_level_hard
import easyrules.composeapp.generated.resources.game_difficulty_level_medium
import org.jetbrains.compose.resources.StringResource

enum class GameDifficultyLevelUiModel(val res: StringResource) {
    EASY(res = Res.string.game_difficulty_level_easy),
    MEDIUM(res = Res.string.game_difficulty_level_medium),
    HARD(res = Res.string.game_difficulty_level_hard),
}