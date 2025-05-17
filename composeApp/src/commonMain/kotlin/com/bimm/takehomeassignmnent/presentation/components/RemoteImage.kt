package com.bimm.takehomeassignmnent.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.bimm.takehomeassignmnent.util.rememberImagePainter
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
    val painter = rememberImagePainter(
        model = model,
        placeholder = painterResource(Res.drawable.ic_placeholder),
        error = painterResource(Res.drawable.ic_image_error)
    )

    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale
    )
}