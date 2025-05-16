package com.bimm.takehomeassignmnent.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import kmptakehomeassignment.composeapp.generated.resources.Res
import kmptakehomeassignment.composeapp.generated.resources.ic_image_error
import kmptakehomeassignment.composeapp.generated.resources.ic_placeholder
import org.jetbrains.compose.resources.painterResource

@Composable
fun RemoteImage(
    model: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    AsyncImage(
        model = model,
        contentDescription = contentDescription,
        placeholder = painterResource(Res.drawable.ic_placeholder),
        error = painterResource(Res.drawable.ic_image_error),
        modifier = modifier,
        contentScale = contentScale
    )
}
