package com.felipearpa.core

inline fun <Value> Value?.ifNull(block: () -> Unit): Value? {
    if (this == null) block()
    return this@ifNull
}

inline fun <Value> Value?.ifNotNull(block: (Value) -> Unit): Value? {
    this?.let(block)
    return this@ifNotNull
}