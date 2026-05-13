package com.sementa.modulo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform