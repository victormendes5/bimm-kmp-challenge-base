package com.bimm.takehomeassignmnent.domain.repository

import com.bimm.takehomeassignmnent.domain.model.Shop

interface ShopRepository {
    suspend fun getAllShops(): List<Shop>
    suspend fun getShopByName(name: String): Shop?
}