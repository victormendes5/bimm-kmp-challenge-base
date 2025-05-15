package com.bimm.takehomeassignmnent.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.bimm.takehomeassignmnent.domain.model.Shop

@Composable
fun ShopListScreen(
    shops: List<Shop>,
    onShopClick: (Shop) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(shops) { shop ->
            Card(
                modifier = Modifier.fillMaxWidth().clickable { onShopClick(shop) },
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = shop.picture,
                        contentDescription = "Shop image",
                        modifier = Modifier.size(64.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(shop.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text(shop.address, fontSize = 14.sp)
                        Text("⭐ ${shop.rating}", fontSize = 14.sp)
                    }
                }
            }
        }
    }
}