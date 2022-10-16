package com.felipearpa.core.type

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class QuantityWithValidValuesTest(private val value: Int) {

    @Test
    fun `given a valid number when a Quantity is created then a Quantity with the value is returned`() {
        val quantity = Quantity(value)
        assertEquals(value, quantity.value)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(0),
                arrayOf(100)
            )
        }
    }

}

@RunWith(Parameterized::class)
class QuantityWithInvalidValuesTest(private val value: Int) {

    @Test
    fun `given an invalid number when a Quantity is created then an exception is raised`() {
        assertThrows(
            IllegalArgumentException::class.java
        ) {
            Quantity(value)
        }
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(-1),
                arrayOf(-100)
            )
        }
    }

}