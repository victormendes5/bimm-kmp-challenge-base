package com.bimm.takehomeassignmnent.data

import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.domain.repository.ShopRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ShopRepository(
    private val client: HttpClient,
    private val endpoint: String
) : ShopRepository {
    override suspend fun getAllShops(): List<Shop> {
        return client.get(endpoint).body()
    }

    override suspend fun getShopByName(name: String): Shop? {
        return getAllShops().find { it.name == name }
    }
}

fun createDefaultHttpClient() = HttpClient {
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
    }
}