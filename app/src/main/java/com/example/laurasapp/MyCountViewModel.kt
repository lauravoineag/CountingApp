package com.example.laurasapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class MyCountUiState(val count: String)

class MyCountViewModel : ViewModel() {
    var uiState by mutableStateOf(MyCountUiState("0"))
        private set

    fun incrementCount() {
        uiState = uiState.copy(count = "${uiState.count.toInt() + 1}")
    }
}

