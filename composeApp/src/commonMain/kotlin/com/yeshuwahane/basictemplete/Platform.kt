package com.yeshuwahane.basictemplete

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform