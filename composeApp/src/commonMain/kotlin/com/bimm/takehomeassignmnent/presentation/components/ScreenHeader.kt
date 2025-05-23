package com.bimm.takehomeassignmnent.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.bimm.takehomeassignmnent.ui.theme.AppColors
import com.bimm.takehomeassignmnent.ui.theme.Dimens

@Composable
fun ScreenHeader(
    title: String,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onBack)
            .padding(bottom = Dimens.Padding.Small)
    ) {
        Text(
            text = "\u2B05",
            fontSize = Dimens.Font.ListTitle,
            color = AppColors.LinkBlue
        )
        Spacer(modifier = Modifier.width(Dimens.Padding.Small))
        Text(
            text = title,
            fontSize = Dimens.Font.ListTitle,
            fontWeight = FontWeight.Medium,
            color = AppColors.LinkBlue
        )
    }
}
