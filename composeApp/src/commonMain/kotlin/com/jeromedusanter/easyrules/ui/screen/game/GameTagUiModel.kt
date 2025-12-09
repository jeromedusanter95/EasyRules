package com.jeromedusanter.easyrules.ui.screen.game

import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_tag_cards
import easyrules.composeapp.generated.resources.game_tag_dice
import easyrules.composeapp.generated.resources.game_tag_drinks
import easyrules.composeapp.generated.resources.game_tag_elimination
import easyrules.composeapp.generated.resources.game_tag_hidden_identity
import easyrules.composeapp.generated.resources.game_tag_no_material
import easyrules.composeapp.generated.resources.game_tag_team
import easyrules.composeapp.generated.resources.game_tag_trick
import org.jetbrains.compose.resources.StringResource

enum class GameTagUiModel(val res: StringResource) {
    CARDS(Res.string.game_tag_cards),
    DICE(Res.string.game_tag_dice),
    NO_MATERIAL(Res.string.game_tag_no_material),
    TEAM(Res.string.game_tag_team),
    ELIMINATION(Res.string.game_tag_elimination),
    HIDDEN_IDENTITY(Res.string.game_tag_hidden_identity),
    DRINKS(Res.string.game_tag_drinks),
    TRICK(Res.string.game_tag_trick),
}
