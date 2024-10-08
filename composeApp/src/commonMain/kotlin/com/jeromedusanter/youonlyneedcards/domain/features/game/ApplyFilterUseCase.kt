package com.jeromedusanter.youonlyneedcards.domain.features.game

import com.jeromedusanter.youonlyneedcards.domain.ApplicationState

class ApplyFilterUseCase {

    fun execute(shouldApplyFilters: Boolean) {
        ApplicationState._shouldApplyFilter.value = shouldApplyFilters
    }
}