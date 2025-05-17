package com.bimm.takehomeassignmnent


import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
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
    Box(modifier = Modifier.fillMaxSize()) {
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

                    is ShopListState.Idle -> Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }

            is Screen.Detail -> ShopDetailScreen(
                shop = screen.shop,
                onBack = { appViewModel.onBack() }
            )
        }
    }
}
