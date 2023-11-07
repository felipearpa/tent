package com.felipearpa.ui

sealed class LoadableViewState<out Value : Any> {
    data object Initial : LoadableViewState<Nothing>()

    data object Loading : LoadableViewState<Nothing>()

    data class Success<Value : Any>(private val value: Value) : LoadableViewState<Value>() {
        operator fun invoke(): Value = value
    }

    data class Failure(private val throwable: Throwable) : LoadableViewState<Nothing>() {
        operator fun invoke(): Throwable = throwable
    }
}

fun <Value : Any> LoadableViewState<Value>.isInitial() = this is LoadableViewState.Initial

fun <Value : Any> LoadableViewState<Value>.isLoading() = this is LoadableViewState.Loading

fun <Value : Any> LoadableViewState<Value>.isSuccess() = this is LoadableViewState.Success

fun <Value : Any> LoadableViewState<Value>.isFailure() = this is LoadableViewState.Failure

inline fun <Value : Any> LoadableViewState<Value>.onInitial(block: () -> Unit): LoadableViewState<Value> {
    if (isInitial()) {
        block()
    }
    return this
}

inline fun <Value : Any> LoadableViewState<Value>.onLoading(block: () -> Unit): LoadableViewState<Value> {
    if (isLoading()) {
        block()
    }
    return this
}

inline fun <Value : Any> LoadableViewState<Value>.onSuccess(block: (value: Value) -> Unit): LoadableViewState<Value> {
    if (isSuccess()) {
        block((this as LoadableViewState.Success).invoke())
    }
    return this
}

inline fun <Value : Any> LoadableViewState<Value>.onFailure(block: (throwable: Throwable) -> Unit): LoadableViewState<Value> {
    if (isFailure()) {
        block((this as LoadableViewState.Failure).invoke())
    }
    return this
}

inline fun <Value : Any> LoadableViewState<Value>.valueOrNull(): Value? {
    if (isSuccess()) {
        return (this as LoadableViewState.Success).invoke()
    }
    return null
}