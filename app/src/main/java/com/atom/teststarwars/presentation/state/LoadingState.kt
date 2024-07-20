package com.atom.teststarwars.presentation.state

sealed class LoadingState<out T> {
    data object Loading : LoadingState<Nothing>()
    data class Success<out T>(val data: T) : LoadingState<T>()
    data class Error(val exception: String) : LoadingState<Nothing>()
}