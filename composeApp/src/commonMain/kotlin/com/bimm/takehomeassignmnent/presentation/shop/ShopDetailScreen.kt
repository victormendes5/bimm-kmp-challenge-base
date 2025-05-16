package com.bimm.takehomeassignmnent.presentation.shop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import com.bimm.takehomeassignmnent.domain.model.Shop
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.platform.LocalUriHandler
import com.bimm.takehomeassignmnent.presentation.components.ScreenHeader
import com.bimm.takehomeassignmnent.presentation.components.RatingBar
import com.bimm.takehomeassignmnent.presentation.components.RemoteImage
import com.bimm.takehomeassignmnent.ui.theme.AppColors
import com.bimm.takehomeassignmnent.ui.theme.Dimens
import com.bimm.takehomeassignmnent.ui.Strings

@Composable
fun ShopDetailScreen(
    shop: Shop,
    onBack: () -> Unit
) {

    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .padding(Dimens.Padding.Screen),
        verticalArrangement = Arrangement.spacedBy(Dimens.Spacing.Item)
    ) {
        ScreenHeader(
            title = shop.name,
            onBack = onBack,
            modifier = Modifier.fillMaxWidth()
        )
        RemoteImage(
            model = shop.picture,
            contentDescription = Strings.ShopImageDescription,
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.Image.DetailBanner)
                .clip(RoundedCornerShape(Dimens.Padding.Small))
        )

        Column(verticalArrangement = Arrangement.spacedBy(Dimens.Padding.Small)) {
            Text(
                text = shop.name,
                fontSize = Dimens.Font.Title,
                fontWeight = FontWeight.Bold,
                color = AppColors.PrimaryText
            )

            RatingBar(rating = shop.rating)

            Text(
                text = shop.description,
                fontSize = Dimens.Font.DetailDescription,
                color = AppColors.PrimaryText
            )

            Text(
                text = shop.address,
                color = AppColors.LinkBlue,
                fontSize = Dimens.Font.Body,
                modifier = Modifier.clickable { uriHandler.openUri(shop.googleMapsLink) }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = { uriHandler.openUri(shop.website) },
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.Component.ButtonHeight),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = AppColors.LinkBlue),
            border = BorderStroke(1.dp, AppColors.LinkBlue)
        ) {
            Text(Strings.VisitWebsiteLabel)
        }
    }
}