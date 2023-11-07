package com.felipearpa.core.formatter

import io.mockk.clearAllMocks
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class ColombianCurrencyFormatterTest(
    private val value: Any,
    private val decimalsCount: Int,
    private val expectedValue: String
) {
    private val colombianCurrencyFormatter = ColombianCurrencyFormatter()

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `given a number when is formatted as a colombian currency then a formatted string is returned`() {
        val formattedValue =
            colombianCurrencyFormatter.format(value = value, decimalsCount = decimalsCount)
        assertEquals(expected = expectedValue, actual = formattedValue)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(0, 0, "$\u00a00"),
                arrayOf(100, 0, "$\u00a0100"),
            )
        }
    }
}