package com.example.crowdin_sync_centralized

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform