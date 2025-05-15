package com.bimm.takehomeassignmnent.data

import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.domain.repository.ShopRepository
import kotlinx.serialization.json.Json

class LocalJsonShopRepository(
    private val loadJson: suspend () -> String
) : ShopRepository {

    override suspend fun getAllShops(): List<Shop> {
        return Json.decodeFromString(loadJson())
    }

    override suspend fun getShopByName(name: String): Shop? {
        return getAllShops().find { it.name == name }
    }
}
