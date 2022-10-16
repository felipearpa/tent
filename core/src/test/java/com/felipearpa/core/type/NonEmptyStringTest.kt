package com.felipearpa.core.type

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class NonEmptyStringWithValidValuesTest(private val value: String) {

    @Test
    fun `given a valid string when a NonEmptyString is created then an NonEmptyString with the string is returned`() {
        val nonEmptyString = NonEmptyString(value)
        assertEquals(value, nonEmptyString.value)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("string")
            )
        }
    }

}

@RunWith(Parameterized::class)
class NonEmptyStringWithInvalidValuesTest(private val value: String) {

    @Test
    fun `given an invalid string when a NonEmptyString is created then an exception is raised`() {
        assertThrows(
            IllegalArgumentException::class.java
        ) {
            Identifier(value)
        }
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(""),
                arrayOf(" ")
            )
        }
    }

}