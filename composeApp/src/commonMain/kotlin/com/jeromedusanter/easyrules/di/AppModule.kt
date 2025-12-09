package com.jeromedusanter.easyrules.di

import androidx.compose.ui.text.intl.Locale
import com.jeromedusanter.easyrules.data.repository.GameRepository
import com.jeromedusanter.easyrules.data.repository.GameRepositoryImpl
import com.jeromedusanter.easyrules.domain.features.game.ApplyFilterUseCase
import com.jeromedusanter.easyrules.domain.features.game.GetGameListUseCase
import com.jeromedusanter.easyrules.domain.features.game.UpdateGameFilterUseCase
import com.jeromedusanter.easyrules.domain.features.game.UpdateSearchQueryUseCase
import com.jeromedusanter.easyrules.ui.MainViewModel
import com.jeromedusanter.easyrules.ui.screen.game.GameDifficultyLevelMapper
import com.jeromedusanter.easyrules.ui.screen.game.GameTagMapper
import com.jeromedusanter.easyrules.ui.screen.game.details.GameDetailsMapper
import com.jeromedusanter.easyrules.ui.screen.game.filter.GameFilterMapper
import com.jeromedusanter.easyrules.ui.screen.game.list.GameListMapper
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

/**
 * Koin module for dependency injection.
 * Defines how to create and provide dependencies throughout the app.
 */
val appModule = module {
    // Repository - Single instance shared across the app
    single<GameRepository> { GameRepositoryImpl() }

    // Use Cases - Factory instances (new instance each time)
    factory {
        GetGameListUseCase(
            repository = get(),
            locale = Locale.current.language
        )
    }
    factoryOf(::UpdateGameFilterUseCase)
    factoryOf(::UpdateSearchQueryUseCase)
    factoryOf(::ApplyFilterUseCase)

    // Mappers - Single instances (stateless)
    singleOf(::GameTagMapper)
    singleOf(::GameDifficultyLevelMapper)
    single {
        GameListMapper(gameTagMapper = get())
    }
    single {
        GameDetailsMapper(
            gameTagMapper = get(),
            gameDifficultyLevelMapper = get()
        )
    }
    single {
        GameFilterMapper(gameTagMapper = get())
    }

    // ViewModel - Scoped to the composition
    viewModel {
        MainViewModel(
            repository = get(),
            getGameListUseCase = get(),
            gameListMapper = get(),
            gameDetailsMapper = get(),
            gameFilterMapper = get(),
            updateGameFilterUseCase = get(),
            updateSearchQueryUseCase = get(),
            applyFilterUseCase = get()
        )
    }
}
