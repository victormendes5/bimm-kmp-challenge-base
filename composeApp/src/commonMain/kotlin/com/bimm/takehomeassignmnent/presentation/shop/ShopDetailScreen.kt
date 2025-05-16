package com.bimm.takehomeassignmnent.presentation.shop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import com.bimm.takehomeassignmnent.domain.model.Shop
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.platform.LocalUriHandler
import com.bimm.takehomeassignmnent.presentation.components.ScreenHeader
import com.bimm.takehomeassignmnent.presentation.components.RatingBar
import com.bimm.takehomeassignmnent.presentation.components.RemoteImage

@Composable
fun ShopDetailScreen(
    shop: Shop,
    onBack: () -> Unit
) {

    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ScreenHeader(
            title = shop.name,
            onBack = onBack,
            modifier = Modifier.fillMaxWidth()
        )
        RemoteImage(
            model = shop.picture,
            contentDescription = "Shop image",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(14.dp))
        )

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = shop.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212121)
            )

            RatingBar(rating = shop.rating)

            Text(
                text = shop.description,
                fontSize = 16.sp,
                color = Color(0xFF424242)
            )

            Text(
                text = shop.address,
                color = Color(0xFF1E88E5),
                fontSize = 16.sp,
                modifier = Modifier.clickable { uriHandler.openUri(shop.googleMapsLink) }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = { uriHandler.openUri(shop.website) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF1E88E5)),
            border = BorderStroke(1.dp, Color(0xFF1E88E5))
        ) {
            Text("Visit Website")
        }
    }
}