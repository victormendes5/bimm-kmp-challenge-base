package com.bimm.takehomeassignmnent.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.painterResource
import kmptakehomeassignment.composeapp.generated.resources.Res
import kmptakehomeassignment.composeapp.generated.resources.ic_placeholder

@Composable
actual fun rememberImagePainter(url: String): Painter {
    return painterResource(Res.drawable.ic_placeholder)
}