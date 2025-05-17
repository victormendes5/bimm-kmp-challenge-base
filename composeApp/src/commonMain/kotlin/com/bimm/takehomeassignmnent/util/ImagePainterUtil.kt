package com.bimm.takehomeassignmnent.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

@Composable
expect fun rememberImagePainter(
    model: String?,
    placeholder: Painter,
    error: Painter
): Painter