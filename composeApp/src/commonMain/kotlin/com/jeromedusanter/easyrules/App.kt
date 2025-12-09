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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jeromedusanter.easyrules.di.appModule
import com.jeromedusanter.easyrules.ui.AppTopBar
import com.jeromedusanter.easyrules.ui.MainViewModel
import com.jeromedusanter.easyrules.ui.navigation.AppDestinations
import com.jeromedusanter.easyrules.ui.navigation.AppNavHost
import com.jeromedusanter.easyrules.ui.navigation.navigateSingleTopTo
import com.jeromedusanter.easyrules.ui.screen.game.list.GameListFloatingActionButton
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        AppContent()
    }
}

@Composable
private fun AppContent() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val viewModel = koinViewModel<MainViewModel>()
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