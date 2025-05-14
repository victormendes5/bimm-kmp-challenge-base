package com.bimm.takehomeassignmnent.domain

import com.bimm.takehomeassignmnent.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}