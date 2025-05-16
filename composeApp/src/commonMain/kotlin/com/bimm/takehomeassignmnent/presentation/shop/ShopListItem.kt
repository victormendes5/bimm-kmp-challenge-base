package com.bimm.takehomeassignmnent.presentation.shop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.presentation.components.RatingBar
import com.bimm.takehomeassignmnent.presentation.components.RemoteImage

@Composable
fun ShopListItem(
    shop: Shop,
    modifier: Modifier = Modifier,
    onClick: (Shop) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(shop) }
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFAFAFA)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RemoteImage(
                model = shop.picture,
                contentDescription = "Shop image",
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
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
                RatingBar(rating = shop.rating)
            }
        }
    }
}


