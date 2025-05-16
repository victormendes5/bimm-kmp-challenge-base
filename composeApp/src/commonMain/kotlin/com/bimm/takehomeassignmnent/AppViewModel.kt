package com.bimm.takehomeassignmnent

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import com.bimm.takehomeassignmnent.data.ShopRepository
import com.bimm.takehomeassignmnent.data.createDefaultHttpClient
import com.bimm.takehomeassignmnent.data.NetworkConfig
import com.bimm.takehomeassignmnent.presentation.shop.ShopListViewModel
import com.bimm.takehomeassignmnent.domain.model.Shop

class AppViewModel {
    var currentScreen by mutableStateOf<Screen>(Screen.List)
        private set

    val shopListViewModel: ShopListViewModel

    private val scope = MainScope()

    init {
        val client = createDefaultHttpClient()
        val repository = ShopRepository(
            client = client,
            endpoint = NetworkConfig.SakeShopEndpoint
        )
        shopListViewModel = ShopListViewModel(repository)

        scope.launch {
            shopListViewModel.load()
        }
    }

    fun onShopClick(shop: Shop) {
        currentScreen = Screen.Detail(shop)
    }

    fun onBack() {
        currentScreen = Screen.List
    }

    fun dispose() {
        scope.cancel()
    }
}