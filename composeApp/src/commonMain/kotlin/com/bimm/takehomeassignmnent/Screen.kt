package com.bimm.takehomeassignmnent

import com.bimm.takehomeassignmnent.domain.model.Shop

sealed class Screen {
    object List : Screen()
    data class Detail(val shop: Shop) : Screen()
}