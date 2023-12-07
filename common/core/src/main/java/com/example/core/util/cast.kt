package com.example.core.util

inline fun <reified T : Any> Any.cast(): T {
    return this as T
}