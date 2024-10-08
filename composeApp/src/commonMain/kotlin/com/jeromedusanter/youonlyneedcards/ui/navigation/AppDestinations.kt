package com.jeromedusanter.youonlyneedcards.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_details_title
import easyrules.composeapp.generated.resources.game_filter_title
import easyrules.composeapp.generated.resources.game_list_title
import org.jetbrains.compose.resources.StringResource

sealed class AppDestinations {
    abstract val route: String
    abstract val labelResId: StringResource

    data object GameList : AppDestinations() {
        override val route = "gameList"
        override val labelResId = Res.string.game_list_title
    }

    data object GameDetails : AppDestinations() {
        override val route = "gameDetails"
        override val labelResId = Res.string.game_details_title
        const val gameIdArg = "game_id"
        val routeWithArgs = "${route}/{${gameIdArg}}"
        val arguments = listOf(
            navArgument(gameIdArg) { type = NavType.IntType }
        )
    }

    data object GameFilter : AppDestinations() {
        override val route: String = "gameFilter"
        override val labelResId = Res.string.game_filter_title
    }


    companion object {
        fun getLabelByResId(route: String?): StringResource {
            return when (route) {
                GameList.route -> GameList.labelResId
                GameDetails.routeWithArgs -> GameDetails.labelResId
                GameFilter.route -> GameFilter.labelResId
                else -> GameList.labelResId
            }
        }
    }
}