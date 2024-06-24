package com.example.laurasapp

import org.junit.Assert.assertEquals
import org.junit.Test

class MyCountViewModelTest {
    @Test
    fun initialUiStateWillBeZero() {
        val viewModel = MyCountViewModel()

        val initialUiState = viewModel.uiState

        assertEquals(MyCountUiState("0"), initialUiState)
    }

    @Test
    fun canIncrementCount() {
        val viewModel = MyCountViewModel()

        viewModel.incrementCount()

        val incrementedState = viewModel.uiState

        assertEquals(MyCountUiState("1"), incrementedState)
    }
}