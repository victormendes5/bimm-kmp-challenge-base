package com.bimm.takehomeassignmnent

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import com.bimm.takehomeassignmnent.data.ShopRepository
import com.bimm.takehomeassignmnent.data.createDefaultHttpClient
import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.presentation.ErrorScreen
import com.bimm.takehomeassignmnent.presentation.Screen
import com.bimm.takehomeassignmnent.presentation.ShopDetailScreen
import com.bimm.takehomeassignmnent.presentation.ShopListScreen
import com.bimm.takehomeassignmnent.presentation.ShopListState
import com.bimm.takehomeassignmnent.presentation.ShopListViewModel

@Composable
fun AppContent() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.List) }

    val client = remember { createDefaultHttpClient() }
    val repository = remember {
        ShopRepository(
            client = client,
            endpoint = "https://private-4ab845-test11663.apiary-mock.com/sakeshop"
        )
    }
    val viewModel = remember { ShopListViewModel(repository) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        viewModel.load()
    }

    when (val screen = currentScreen) {
        is Screen.List -> {
            when (val state = viewModel.state) {
                is ShopListState.Loading -> CircularProgressIndicator()
                is ShopListState.Error -> ErrorScreen(
                    message = state.message,
                    onRetry = {
                        coroutineScope.launch {
                            viewModel.load()
                        }
                    }
                )
                is ShopListState.Success -> ShopListScreen(
                    shops = state.shops,
                    onShopClick = { selectedShop ->
                        currentScreen = Screen.Detail(selectedShop)
                    }
                )
            }
        }

        is Screen.Detail -> ShopDetailScreen(
            shop = screen.shop,
            onBack = { currentScreen = Screen.List }
        )
    }
}
