package com.jeromedusanter.easyrules.domain.features.game

import com.jeromedusanter.easyrules.domain.ApplicationState
import com.jeromedusanter.easyrules.domain.gameList
import com.jeromedusanter.easyrules.domain.gameListInEnglish
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class GetGameListUseCase(private val locale: String) {
    suspend fun execute(): Result<Nothing?> {
        return withContext(Dispatchers.IO) {
            try {
                val list = if (locale == "fr") {
                    gameList
                } else {
                    gameListInEnglish
                }
                ApplicationState._gameList.value = list
                Result.success(null)
            } catch (t: Throwable) {
                t.printStackTrace()
                Result.failure(t)
            }
        }
    }
}