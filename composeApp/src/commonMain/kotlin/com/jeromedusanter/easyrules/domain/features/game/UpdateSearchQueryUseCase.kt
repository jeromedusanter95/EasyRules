package com.jeromedusanter.easyrules.domain.features.game

import com.jeromedusanter.easyrules.domain.ApplicationState

class UpdateSearchQueryUseCase {

    fun updateSearchQuery(searchQuery: String) {
        ApplicationState._searchQuery.value = searchQuery
    }

    fun clearSearchQuery() {
        ApplicationState._searchQuery.value = ""
    }
}