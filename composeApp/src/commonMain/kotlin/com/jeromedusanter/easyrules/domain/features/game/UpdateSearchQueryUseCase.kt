package com.jeromedusanter.easyrules.domain.features.game

import com.jeromedusanter.easyrules.data.repository.GameRepository

/**
 * Use case for managing search query.
 */
class UpdateSearchQueryUseCase(private val repository: GameRepository) {

    fun updateSearchQuery(searchQuery: String) {
        repository.updateSearchQuery(searchQuery)
    }

    fun clearSearchQuery() {
        repository.clearSearchQuery()
    }
}