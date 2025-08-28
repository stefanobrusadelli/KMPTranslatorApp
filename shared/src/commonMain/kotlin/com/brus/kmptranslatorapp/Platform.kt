package com.brus.kmptranslatorapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform