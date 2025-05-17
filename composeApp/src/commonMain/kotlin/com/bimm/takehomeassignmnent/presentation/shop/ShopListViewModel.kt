package com.bimm.takehomeassignmnent.presentation.shop

import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.domain.repository.ShopRepository
import com.bimm.takehomeassignmnent.ui.Strings
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

sealed class ShopListState {
    data object Idle : ShopListState()
    data object Loading : ShopListState()
    data class Success(val shops: List<Shop>) : ShopListState()
    data class Error(val message: String) : ShopListState()
}

class ShopListViewModel(
    private val repository: ShopRepository,
    private val scope: CoroutineScope = MainScope()
) {

    var state by mutableStateOf<ShopListState>(ShopListState.Idle)
        private set

    fun load() {
        state = ShopListState.Loading
        scope.launch {
            state = try {
                val shops = repository.getAllShops()
                ShopListState.Success(shops)
            } catch (e: Exception) {
                ShopListState.Error(e.message ?: Strings.UnknownErrorLabel)
            }
        }
    }

    fun dispose() {
        scope.cancel()
    }
}
