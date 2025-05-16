package com.bimm.takehomeassignmnent.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.util.rememberImagePainter

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
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .clickable { onShopClick(shop) },
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFAFAFA)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        shop.picture?.let { rememberImagePainter(it) }?.let {
                            Image(
                                painter = it,
                                contentDescription = "Shop image",
                                modifier = Modifier
                                    .size(72.dp)
                                    .clip(RoundedCornerShape(12.dp)),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = shop.name,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF212121)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = shop.address,
                                fontSize = 14.sp,
                                color = Color(0xFF616161)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "\u2605",
                                    fontSize = 14.sp,
                                    color = Color(0xFFFFC107)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "${shop.rating}",
                                    fontSize = 14.sp,
                                    color = Color(0xFF424242)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}