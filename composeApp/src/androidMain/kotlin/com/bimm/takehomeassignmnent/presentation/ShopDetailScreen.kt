package com.bimm.takehomeassignmnent.presentation

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ArrowBack
import coil3.compose.AsyncImage
import com.bimm.takehomeassignmnent.R
import com.bimm.takehomeassignmnent.domain.model.Shop

import androidx.compose.foundation.BorderStroke
import androidx.core.net.toUri

@Composable
fun ShopDetailScreen(shop: Shop, onBack: () -> Unit) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { onBack() }
                    .padding(vertical = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFF1E88E5),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Back",
                    fontSize = 16.sp,
                    color = Color(0xFF1E88E5),
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Shop Details",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212121)
            )
        }

        AsyncImage(
            model = shop.picture,
            contentDescription = "Shop Image",
            placeholder = painterResource(R.drawable.placeholder),
            error = painterResource(R.drawable.image_error),
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(14.dp)),
            contentScale = ContentScale.Crop
        )

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = shop.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF212121)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating",
                    tint = Color(0xFFFFC107),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = "${shop.rating}", fontSize = 16.sp, color = Color(0xFF424242))
            }

            Text(
                text = shop.description,
                fontSize = 16.sp,
                color = Color(0xFF424242)
            )

            Text(
                text = shop.address,
                color = Color(0xFF1E88E5),
                fontSize = 16.sp,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, shop.googleMapsLink.toUri())
                    context.startActivity(intent)
                }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, shop.website.toUri())
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF1E88E5)),
            border = BorderStroke(1.dp, Color(0xFF1E88E5))
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color(0xFF1E88E5),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Visit Website")
        }
    }
}