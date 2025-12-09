package com.jeromedusanter.easyrules

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jeromedusanter.easyrules.domain.features.game.ApplyFilterUseCase
import com.jeromedusanter.easyrules.domain.features.game.GetGameListUseCase
import com.jeromedusanter.easyrules.domain.features.game.UpdateGameFilterUseCase
import com.jeromedusanter.easyrules.domain.features.game.UpdateSearchQueryUseCase
import com.jeromedusanter.easyrules.ui.AppTopBar
import com.jeromedusanter.easyrules.ui.MainViewModel
import com.jeromedusanter.easyrules.ui.navigation.AppDestinations
import com.jeromedusanter.easyrules.ui.navigation.AppNavHost
import com.jeromedusanter.easyrules.ui.navigation.navigateSingleTopTo
import com.jeromedusanter.easyrules.ui.screen.game.GameDifficultyLevelMapper
import com.jeromedusanter.easyrules.ui.screen.game.GameTagMapper
import com.jeromedusanter.easyrules.ui.screen.game.details.GameDetailsMapper
import com.jeromedusanter.easyrules.ui.screen.game.filter.GameFilterMapper
import com.jeromedusanter.easyrules.ui.screen.game.list.GameListFloatingActionButton
import com.jeromedusanter.easyrules.ui.screen.game.list.GameListMapper
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val locale = Locale.current.language
    val viewModel = viewModel {

        MainViewModel(
            getGameListUseCase = GetGameListUseCase(locale),
            gameListMapper = GameListMapper(
                gameTagMapper = GameTagMapper()
            ),
            gameDetailsMapper = GameDetailsMapper(
                gameTagMapper = GameTagMapper(),
                gameDifficultyLevelMapper = GameDifficultyLevelMapper()
            ),
            gameFilterMapper = GameFilterMapper(
                gameTagMapper = GameTagMapper()
            ),
            updateGameFilterUseCase = UpdateGameFilterUseCase(),
            updateSearchQueryUseCase = UpdateSearchQueryUseCase(),
            applyFilterUseCase = ApplyFilterUseCase()
        )
    }
    val searchQuery by viewModel.searchQuery.collectAsState()
    val showSearchBar by viewModel.showSearchBar.collectAsState()
    val shouldApplyFilters by viewModel.shouldApplyFilters.collectAsState()

    Scaffold(
        modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing),
        topBar = {
            AppTopBar(
                title = stringResource(AppDestinations.getLabelByResId(currentDestination?.route)),
                showArrowBackButton = currentDestination?.route != AppDestinations.GameList.route,
                showSearchActionButton = currentDestination?.route == AppDestinations.GameList.route,
                searchQuery = searchQuery,
                onClickArrowBackButton = { navController.popBackStack() },
                onClearSearchQuery = viewModel::clearSearchQueryInFilters,
                onSearchQueryChange = viewModel::updateSearchQueryInFilters,
                onChangeSearchBarVisibility = viewModel::toggleShowSearchBarVisibility,
                showSearchBar = showSearchBar,
                showApplyFilterActionButton = currentDestination?.route == AppDestinations.GameFilter.route,
                shouldApplyFilters = shouldApplyFilters,
                onToggleApplyFilter = viewModel::toggleShouldApplyFilters,
            )
        },
        floatingActionButton = {
            if (currentDestination?.route == AppDestinations.GameList.route)
                GameListFloatingActionButton(
                    onClick = { navController.navigateSingleTopTo(AppDestinations.GameFilter.route) },
                )
        }
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            viewModel = viewModel
        )
    }

}