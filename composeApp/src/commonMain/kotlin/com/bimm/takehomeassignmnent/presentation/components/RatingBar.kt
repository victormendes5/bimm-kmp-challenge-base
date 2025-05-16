package com.bimm.takehomeassignmnent.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
            fontSize = 16.sp,
            color = Color(0xFFFFC107)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = rating.toString(),
            fontSize = 14.sp,
            color = Color(0xFF424242)
        )
    }
}