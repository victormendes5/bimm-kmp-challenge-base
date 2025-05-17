package com.bimm.takehomeassignmnent

import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.domain.repository.ShopRepository

class FakeRepo(
    private val shops: List<Shop> = emptyList(),
    private val throwError: Boolean = false
) : ShopRepository {
    override suspend fun getAllShops(): List<Shop> {
        if (throwError) throw RuntimeException("Test failure")
        return shops
    }
    override suspend fun getShopByName(name: String): Shop? {
        return shops.firstOrNull { it.name == name }
    }
}