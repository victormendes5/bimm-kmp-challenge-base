package com.bimm.takehomeassignmnent.presentation.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.ui.theme.AppColors
import com.bimm.takehomeassignmnent.ui.theme.Dimens
import com.bimm.takehomeassignmnent.ui.Strings

@Composable
fun ShopListScreen(
    shops: List<Shop>,
    onShopClick: (Shop) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .padding(Dimens.Padding.Screen)
    ) {
        Text(
            text = Strings.ScreenListTitle,
            fontSize = Dimens.Font.ListTitle,
            fontWeight = FontWeight.Bold,
            color = AppColors.PrimaryText,
            modifier = Modifier.padding(vertical = Dimens.Padding.Small)
        )
        Text(
            text = Strings.ScreenListSubtitle,
            fontSize = Dimens.Font.ListSubtitle,
            color = AppColors.SecondaryText,
            modifier = Modifier.padding(bottom = Dimens.Padding.Small)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimens.Spacing.Item)
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