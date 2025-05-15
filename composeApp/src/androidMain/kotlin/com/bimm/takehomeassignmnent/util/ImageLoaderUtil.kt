package com.bimm.takehomeassignmnent.util

import android.content.Context
import coil3.ImageLoader
import coil3.network.NetworkFetcher
import coil3.util.DebugLogger
import coil3.network.okhttp.OkHttpNetworkFetcherFactory
import coil3.request.crossfade
import okhttp3.OkHttpClient

fun createHttpEnabledImageLoader(context: Context): ImageLoader {
    val okHttpClient = OkHttpClient.Builder().build()
    val fetcherFactory: NetworkFetcher.Factory = OkHttpNetworkFetcherFactory(okHttpClient)

    return ImageLoader.Builder(context)
        .components {
            add(fetcherFactory)
        }
        .crossfade(true)
        .logger(DebugLogger())
        .build()
}
