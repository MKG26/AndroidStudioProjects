package com.example.customtip

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.customtip.ui.theme.CustomTipTheme
import org.junit.Rule
import org.junit.Test

class tipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun addition_isCor() {
        composeTestRule.setContent {
            CustomTipTheme {
                TipTimeLayout()

            }
        }
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        val expectedTip = 2.0
        composeTestRule.onNodeWithText("Tip Amount: \n" +
                "Rs $expectedTip").assertExists("No node with this text was found.")

    }
}