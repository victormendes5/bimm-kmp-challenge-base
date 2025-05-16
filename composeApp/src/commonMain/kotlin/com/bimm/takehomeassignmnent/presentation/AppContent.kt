package com.bimm.takehomeassignmnent.presentation


import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import com.bimm.takehomeassignmnent.data.ShopRepository
import com.bimm.takehomeassignmnent.data.createDefaultHttpClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.systemBars
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize

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

    Box(modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues())) {
        when (val screen = currentScreen) {
            is Screen.List -> {
                when (val state = viewModel.state) {
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
}
