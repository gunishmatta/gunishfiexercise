package com.gunish.fiandroidexercise.utils

object NumberUtils {
    fun safeInt(text: String, fallback: Int): Int {
        return text.toIntOrNull() ?: fallback
    }
}