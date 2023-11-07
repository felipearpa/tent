package com.felipearpa.tent.home.view.ui

import androidx.lifecycle.ViewModel
import com.felipearpa.core.emptyString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _filterTextFlow = MutableStateFlow(emptyString())
    val filterTextFlow: StateFlow<String>
        get() = _filterTextFlow.asStateFlow()

    fun storeFilterText(filterText: String) {
        _filterTextFlow.value = filterText.trim()
    }
}