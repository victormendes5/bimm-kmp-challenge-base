package com.bimm.takehomeassignmnent.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.bimm.takehomeassignmnent.domain.model.Shop

@Composable
fun ShopDetailScreen(shop: Shop, onBack: () -> Unit) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "← Back",
            color = Color.Blue,
            fontSize = 16.sp,
            modifier = Modifier.clickable { onBack() }
        )

        AsyncImage(
            model = shop.picture,
            contentDescription = "Shop Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Text(text = shop.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = shop.description, fontSize = 16.sp)
        Text(text = "⭐ ${shop.rating}", fontSize = 16.sp)

        Text(
            text = shop.address,
            color = Color.Blue,
            modifier = Modifier.clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(shop.googleMapsLink))
                context.startActivity(intent)
            }
        )

        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(shop.website))
            context.startActivity(intent)
        }) {
            Text("Visit Website")
        }
    }
}