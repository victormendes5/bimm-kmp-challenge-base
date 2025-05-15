package com.bimm.takehomeassignmnent.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.domain.repository.ShopRepository

class ShopListViewModel(
    private val repository: ShopRepository
) {
    var state by mutableStateOf<ShopListState>(ShopListState.Loading)
        private set

    suspend fun load() {
        state = try {
            val shops = repository.getAllShops()
            ShopListState.Success(shops)
        } catch (e: Exception) {
            ShopListState.Error(e.message ?: "Unknown error")
        }
    }
}

sealed class ShopListState {
    object Loading : ShopListState()
    data class Success(val shops: List<Shop>) : ShopListState()
    data class Error(val message: String) : ShopListState()
}