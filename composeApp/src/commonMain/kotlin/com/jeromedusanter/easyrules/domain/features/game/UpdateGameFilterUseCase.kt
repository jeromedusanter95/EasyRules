package com.jeromedusanter.easyrules.domain.features.game

import com.jeromedusanter.easyrules.data.repository.GameRepository
import com.jeromedusanter.easyrules.domain.GameDifficultyLevelModel
import com.jeromedusanter.easyrules.domain.GameTagModel

/**
 * Use case for updating game filters.
 */
class UpdateGameFilterUseCase(private val repository: GameRepository) {

    fun updateNumberOfPlayers(numberOfPlayers: Int) {
        repository.updateNumberOfPlayers(numberOfPlayers)
    }

    fun updateDurationRange(durationRange: IntRange) {
        repository.updateDurationRange(durationRange)
    }

    fun updateDifficultyLevel(difficultyLevel: GameDifficultyLevelModel?) {
        repository.updateDifficultyLevel(difficultyLevel)
    }

    fun updateTagList(tagModelId: Int) {
        val tagModel = GameTagModel.entries.firstOrNull { it.ordinal == tagModelId }
        if (tagModel != null) {
            repository.toggleTag(tagModel)
        }
    }

    fun clearFilters() {
        repository.clearFilters()
    }
}