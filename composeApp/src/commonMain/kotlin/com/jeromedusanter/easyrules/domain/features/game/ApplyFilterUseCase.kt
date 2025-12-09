package com.jeromedusanter.easyrules.domain.features.game

import com.jeromedusanter.easyrules.data.repository.GameRepository

/**
 * Use case for toggling filter application.
 */
class ApplyFilterUseCase(private val repository: GameRepository) {

    fun execute(shouldApplyFilters: Boolean) {
        repository.setShouldApplyFilter(shouldApplyFilters)
    }
}