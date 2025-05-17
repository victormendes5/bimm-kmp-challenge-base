package com.bimm.takehomeassignmnent

import com.bimm.takehomeassignmnent.domain.model.Shop

sealed class Screen {
    data object List : Screen()
    data class Detail(val shop: Shop) : Screen()
}