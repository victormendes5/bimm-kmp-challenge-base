package com.bimm.takehomeassignmnent


import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import kotlinx.coroutines.launch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.systemBars
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import com.bimm.takehomeassignmnent.presentation.states.ErrorScreen
import com.bimm.takehomeassignmnent.presentation.shop.ShopDetailScreen
import com.bimm.takehomeassignmnent.presentation.shop.ShopListScreen
import com.bimm.takehomeassignmnent.presentation.shop.ShopListState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

@Composable
fun AppContent(
    appViewModel: AppViewModel = remember { AppViewModel() }
) {
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        val screen = appViewModel.currentScreen
        val state = appViewModel.shopListViewModel.state

        when (screen) {
            is Screen.List -> {
                when (state) {
                    is ShopListState.Loading -> Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                    is ShopListState.Error -> ErrorScreen(
                        message = state.message,
                        onRetry = {
                            coroutineScope.launch {
                                appViewModel.shopListViewModel.load()
                            }
                        }
                    )
                    is ShopListState.Success -> ShopListScreen(
                        shops = state.shops,
                        onShopClick = { appViewModel.onShopClick(it) }
                    )
                }
            }

            is Screen.Detail -> ShopDetailScreen(
                shop = screen.shop,
                onBack = { appViewModel.onBack() }
            )
        }
    }
}
