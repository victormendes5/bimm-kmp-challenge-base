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
import androidx.compose.ui.text.font.FontWeight
import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.presentation.components.RatingBar
import com.bimm.takehomeassignmnent.presentation.components.RemoteImage
import com.bimm.takehomeassignmnent.ui.theme.AppColors
import com.bimm.takehomeassignmnent.ui.theme.Dimens
import com.bimm.takehomeassignmnent.ui.Strings

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
            .padding(vertical = Dimens.Padding.Small),
        colors = CardDefaults.cardColors(containerColor = AppColors.CardBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = Dimens.Padding.Small)
    ) {
        Row(
            modifier = Modifier.padding(Dimens.Padding.Screen),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RemoteImage(
                model = shop.picture,
                contentDescription = Strings.ShopImageDescription,
                modifier = Modifier
                    .size(Dimens.Image.ListItem)
                    .clip(RoundedCornerShape(Dimens.Padding.Small))
            )
            Spacer(modifier = Modifier.width(Dimens.Padding.Screen))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = shop.name,
                    fontSize = Dimens.Font.Title,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.PrimaryText
                )
                Spacer(modifier = Modifier.height(Dimens.Padding.Small))
                Text(
                    text = shop.address,
                    fontSize = Dimens.Font.Body,
                    color = AppColors.SecondaryText
                )
                Spacer(modifier = Modifier.height(Dimens.Padding.Small))
                RatingBar(rating = shop.rating)
            }
        }
    }
}
