package com.bimm.takehomeassignmnent.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import io.kamel.core.Resource
import io.kamel.core.config.KamelConfig
import io.kamel.image.asyncPainterResource
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.HttpClient
import io.kamel.core.config.httpUrlFetcher

@Composable
actual fun rememberImagePainter(
    model: String?,
    placeholder: Painter,
    error: Painter
): Painter {
    val resource = asyncPainterResource(model.orEmpty()) {
        KamelConfig {
            httpUrlFetcher(HttpClient(Darwin.create()))
        }
    }

    return when (resource) {
        is Resource.Loading -> placeholder
        is Resource.Success -> resource.value
        is Resource.Failure -> error
    }
}
