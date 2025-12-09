package com.jeromedusanter.easyrules.domain.features.game

import com.jeromedusanter.easyrules.data.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

/**
 * Use case for loading the game list based on user's locale.
 */
class GetGameListUseCase(
    private val repository: GameRepository,
    private val locale: String
) {
    /**
     * Executes the use case to load games.
     * @return Result indicating success or failure
     */
    suspend fun execute(): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                repository.loadGames(locale)
                Result.success(Unit)
            } catch (t: Throwable) {
                // TODO: Add proper logging with Napier
                t.printStackTrace()
                Result.failure(t)
            }
        }
    }
}