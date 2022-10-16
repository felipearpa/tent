package com.felipearpa.core.type

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class CurrencyWithValidValuesTest(private val value: Double) {

    @Test
    fun `given a valid number when a Currency is created then a Currency with the value is returned`() {
        val currency = Currency(value)
        assertEquals(value, currency.value)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(0f),
                arrayOf(100f)
            )
        }
    }

}

@RunWith(Parameterized::class)
class CurrencyWithInvalidValuesTest(private val value: Double) {

    @Test
    fun `given an invalid number when a Currency is created then an exception is raised`() {
        assertThrows(
            IllegalArgumentException::class.java
        ) {
            Currency(value)
        }
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(-1f),
                arrayOf(-100f)
            )
        }
    }

}