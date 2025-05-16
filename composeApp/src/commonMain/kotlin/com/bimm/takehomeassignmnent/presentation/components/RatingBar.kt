package com.bimm.takehomeassignmnent.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bimm.takehomeassignmnent.ui.theme.AppColors
import com.bimm.takehomeassignmnent.ui.theme.Dimens

@Composable
fun RatingBar(
    rating: Double,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "\u2605",
            fontSize = Dimens.Font.DetailDescription,
            color = AppColors.AccentYellow
        )
        Spacer(modifier = Modifier.width(Dimens.Padding.Small))
        Text(
            text = rating.toString(),
            fontSize = Dimens.Font.Body,
            color = AppColors.PrimaryText
        )
    }
}