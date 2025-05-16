package com.bimm.takehomeassignmnent.presentation.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bimm.takehomeassignmnent.domain.model.Shop

@Composable
fun ShopListScreen(
    shops: List<Shop>,
    onShopClick: (Shop) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(12.dp)
    ) {
        Text(
            text = "Local Sake Shops",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF212121),
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = "Discover the best places to enjoy sake in your area 🍶",
            fontSize = 16.sp,
            color = Color(0xFF757575),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(shops) { shop ->
                ShopListItem(
                    shop = shop,
                    onClick = onShopClick
                )
            }
        }
    }
}