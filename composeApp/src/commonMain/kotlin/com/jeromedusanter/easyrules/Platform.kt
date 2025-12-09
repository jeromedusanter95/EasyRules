package com.jeromedusanter.easyrules

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform