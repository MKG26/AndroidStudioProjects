package com.example.customtip

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorr() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = 2.0
        val actualTip = calculateTip(amount = amount , tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip,0.0)
    }
}