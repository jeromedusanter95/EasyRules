package com.jeromedusanter.youonlyneedcards.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jeromedusanter.youonlyneedcards.ui.MainViewModel
import com.jeromedusanter.youonlyneedcards.ui.screen.game.details.GameDetailScreen
import com.jeromedusanter.youonlyneedcards.ui.screen.game.filter.GameFilterScreen
import com.jeromedusanter.youonlyneedcards.ui.screen.game.list.GameListScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = AppDestinations.GameList.route,
        modifier = modifier
    ) {
        composable(route = AppDestinations.GameList.route) {
            GameListScreen(
                viewModel = viewModel,
                onGameClick = { navController.navigateSingleTopTo("${AppDestinations.GameDetails.route}/$it") }
            )
        }
        composable(
            route = AppDestinations.GameDetails.routeWithArgs,
            arguments = AppDestinations.GameDetails.arguments
        ) { navBackStackEntry ->
            GameDetailScreen(
                viewModel = viewModel,
                gameId = navBackStackEntry.arguments?.getInt(AppDestinations.GameDetails.gameIdArg),
            )
        }
        composable(
            route = AppDestinations.GameFilter.route,
        ) {
            GameFilterScreen(
                viewModel = viewModel,
                onClickButtonSeeGames = { navController.popBackStack() })
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }