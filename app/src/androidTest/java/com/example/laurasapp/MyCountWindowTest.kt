package com.example.laurasapp

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class MyCountWindowTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun labelCanBePopulated() {
        val expectedCountText = "${System.currentTimeMillis()}"

        rule.setContent {
            MyCountWindow(
                countText = expectedCountText,
                onCounterTapped = {}
            )
        }

        rule.onNodeWithText(expectedCountText).assertIsDisplayed()
    }

    @Test
    fun thereWillBeACountButton() {
        rule.setContent {
            MyCountWindow(
                countText = "",
                onCounterTapped = {}
            )
        }

        rule.onNodeWithText("Count")
            .assertHasClickAction()
            .assertIsDisplayed()
    }

    @Test
    fun canTapCountButton() {
        var onCounterTappedInvoked = false

        rule.setContent {
            MyCountWindow(
                countText = "",
                onCounterTapped = {
                    onCounterTappedInvoked = true
                }
            )
        }

        rule.onNodeWithText("Count")
            .performClick()

        assertTrue(onCounterTappedInvoked)
    }

    @Test
    fun willUseViewModel() {
        rule.setContent {
            MyCountWindow()
        }

        /** Checking that the initial state value is displayed */
        rule.onNodeWithText("0").assertIsDisplayed()

        rule.onNodeWithText("Count").performClick()

        /** Checking that the updated state value from the view model is displayed */
        rule.onNodeWithText("1").assertIsDisplayed()

        rule.onNodeWithText("Count").performClick()

        rule.onNodeWithText("2").assertIsDisplayed()
    }
}