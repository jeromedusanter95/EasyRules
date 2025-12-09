package com.jeromedusanter.easyrules.domain.features.game

import com.jeromedusanter.easyrules.domain.ApplicationState

class ApplyFilterUseCase {

    fun execute(shouldApplyFilters: Boolean) {
        ApplicationState._shouldApplyFilter.value = shouldApplyFilters
    }
}