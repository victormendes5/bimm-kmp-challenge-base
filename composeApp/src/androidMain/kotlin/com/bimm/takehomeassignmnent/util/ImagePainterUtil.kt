package com.bimm.takehomeassignmnent.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import coil3.compose.rememberAsyncImagePainter

@Composable
actual fun rememberImagePainter(
    model: String?,
    placeholder: Painter,
    error: Painter
): Painter {
    return rememberAsyncImagePainter(
        model = model,
        placeholder = placeholder,
        error = error
    )
}