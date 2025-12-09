package com.jeromedusanter.easyrules.domain.features.game

import com.jeromedusanter.easyrules.domain.ApplicationState
import com.jeromedusanter.easyrules.domain.GameDifficultyLevelModel
import com.jeromedusanter.easyrules.domain.GameFilterModel
import com.jeromedusanter.easyrules.domain.GameTagModel

class UpdateGameFilterUseCase  {

    fun updateNumberOfPlayers(numberOfPlayers: Int) {
        ApplicationState._gameFilter.value =
            ApplicationState._gameFilter.value.copy(numberOfPlayers = numberOfPlayers)
    }

    fun updateDurationRange(durationRange: IntRange) {
        ApplicationState._gameFilter.value =
            ApplicationState._gameFilter.value.copy(durationRange = durationRange)
    }

    fun updateDifficultyLevel(difficultyLevel: GameDifficultyLevelModel?) {
        ApplicationState._gameFilter.value =
            ApplicationState._gameFilter.value.copy(
                difficultyLevel =
                if (difficultyLevel == ApplicationState.gameFilter.value.difficultyLevel) {
                    null
                } else {
                    difficultyLevel
                }
            )
    }

    fun updateTagList(tagModelId: Int) {
        val tagList = ApplicationState._gameFilter.value.tagSelectedList.toMutableList()
        val tagSelectedOrNull = tagList.find { it.ordinal == tagModelId }

        if (tagSelectedOrNull == null) {
            val tagModelToAddOrNull = GameTagModel.entries.firstOrNull { it.ordinal == tagModelId }
            if (tagModelToAddOrNull == null) return
            tagList.add(tagModelToAddOrNull)
        } else {
            val tagModelToRemoveOrNull =
                GameTagModel.entries.firstOrNull { it.ordinal == tagModelId }
            if (tagModelToRemoveOrNull == null) return
            tagList.remove(tagModelToRemoveOrNull)
        }

        ApplicationState._gameFilter.value =
            ApplicationState._gameFilter.value.copy(tagSelectedList = tagList)
    }

    fun clearFilters() {
        ApplicationState._gameFilter.value = GameFilterModel.INITIAL_STATE
    }
}