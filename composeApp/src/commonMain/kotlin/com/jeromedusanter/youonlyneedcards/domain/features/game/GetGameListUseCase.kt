package com.jeromedusanter.youonlyneedcards.domain.features.game

import com.jeromedusanter.youonlyneedcards.domain.ApplicationState
import com.jeromedusanter.youonlyneedcards.domain.gameList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class GetGameListUseCase {
    suspend fun execute(): Result<Nothing?> {
        return withContext(Dispatchers.IO) {
            try {
                val list = gameList
                ApplicationState._gameList.value = list
                Result.success(null)
            } catch (t: Throwable) {
                t.printStackTrace()
                Result.failure(t)
            }
        }
    }
}