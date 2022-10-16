package com.felipearpa.core.type

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class IdentifierWithValidValuesTest(private val value: String) {

    @Test
    fun `given a valid string for identifier when an Identifier is created then an Identifier with the string is returned`() {
        val identifier = Identifier(value)
        assertEquals(value, identifier.value)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("identifier")
            )
        }
    }

}

@RunWith(Parameterized::class)
class IdentifierWithInvalidValuesTest(private val value: String) {

    @Test
    fun `given an invalid string for identifier when an Identifier is created then an exception is raised`() {
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