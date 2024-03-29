package com.felipearpa.core.network

interface NetworkExceptionHandler {
    suspend fun <T> handle(block: suspend () -> T): Result<T>
}