package com.jeromedusanter.easyrules.ui.screen.game

import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_difficulty_level_easy
import easyrules.composeapp.generated.resources.game_difficulty_level_hard
import easyrules.composeapp.generated.resources.game_difficulty_level_medium
import org.jetbrains.compose.resources.StringResource

enum class GameDifficultyLevelUiModel(val res: StringResource) {
    EASY(Res.string.game_difficulty_level_easy),
    MEDIUM(Res.string.game_difficulty_level_medium),
    HARD(Res.string.game_difficulty_level_hard)
}