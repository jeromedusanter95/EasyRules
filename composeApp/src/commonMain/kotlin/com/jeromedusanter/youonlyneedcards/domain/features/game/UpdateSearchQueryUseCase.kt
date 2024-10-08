package com.jeromedusanter.youonlyneedcards.domain.features.game

import com.jeromedusanter.youonlyneedcards.domain.ApplicationState

class UpdateSearchQueryUseCase {

    fun updateSearchQuery(searchQuery: String) {
        ApplicationState._searchQuery.value = searchQuery
    }

    fun clearSearchQuery() {
        ApplicationState._searchQuery.value = ""
    }
}