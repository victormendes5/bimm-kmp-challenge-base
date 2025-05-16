package com.bimm.takehomeassignmnent.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import coil3.compose.rememberAsyncImagePainter

@Composable
actual fun rememberImagePainter(url: String): Painter {
    return rememberAsyncImagePainter(url)
}