package com.bimm.takehomeassignmnent.presentation.shop

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import com.bimm.takehomeassignmnent.domain.model.Shop
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.platform.LocalUriHandler
import coil3.compose.AsyncImage
import kmptakehomeassignment.composeapp.generated.resources.Res
import kmptakehomeassignment.composeapp.generated.resources.ic_image_error
import kmptakehomeassignment.composeapp.generated.resources.ic_placeholder
import org.jetbrains.compose.resources.painterResource

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
                Text(
                    text = "\u2190",
                    fontSize = 20.sp,
                    color = Color(0xFF1E88E5),
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
            contentDescription = "Shop image",
            placeholder = painterResource(Res.drawable.ic_placeholder),
            error = painterResource(Res.drawable.ic_image_error),
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
                Text(
                    text = "\u2605",
                    fontSize = 20.sp,
                    color = Color(0xFFFFC107),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "${shop.rating}",
                    fontSize = 16.sp,
                    color = Color(0xFF424242)
                )
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