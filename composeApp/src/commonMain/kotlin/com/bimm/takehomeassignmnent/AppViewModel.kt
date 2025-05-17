package com.bimm.takehomeassignmnent

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.bimm.takehomeassignmnent.data.ShopRepository
import com.bimm.takehomeassignmnent.data.createDefaultHttpClient
import com.bimm.takehomeassignmnent.data.NetworkConfig
import com.bimm.takehomeassignmnent.presentation.shop.ShopListViewModel
import kotlinx.coroutines.cancel

class AppViewModel(
    val shopListViewModel: ShopListViewModel = ShopListViewModel(
        ShopRepository(createDefaultHttpClient(), NetworkConfig.SakeShopEndpoint)
    ),
    autoLoad: Boolean = true,
    private val scope: CoroutineScope = MainScope()
) {

    var currentScreen by mutableStateOf<Screen>(Screen.List)
        private set

    init {
        if (autoLoad) {
            scope.launch { shopListViewModel.load() }
        }
    }

    fun onShopClick(shop: com.bimm.takehomeassignmnent.domain.model.Shop) {
        currentScreen = Screen.Detail(shop)
    }

    fun onBack() {
        currentScreen = Screen.List
    }

    fun dispose() {
        shopListViewModel.dispose()
        scope.cancel()
    }
}