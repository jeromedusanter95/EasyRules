package com.jeromedusanter.youonlyneedcards

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform