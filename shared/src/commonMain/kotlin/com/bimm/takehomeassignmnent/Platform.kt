package com.bimm.takehomeassignmnent

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform