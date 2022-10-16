package com.felipearpa.core.type

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class UrlWithValidValuesTest(private val value: String) {

    @Test
    fun `given a valid url string when an Url is created then an Url with the string is returned`() {
        val url = Url(value)
        assertEquals(value, url.value)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("http://www.felipearpa.com"),
                arrayOf("https://www.felipearpa.com"),
                arrayOf("http://felipearpa.com"),
                arrayOf("https://felipearpa.com"),
                arrayOf("http://www.felipearpa.com/co"),
                arrayOf("https://www.felipearpa.com/co"),
                arrayOf("www.felipearpa.com"),
                arrayOf("www.felipearpa.com?p1=1&p10=10"),
                arrayOf("www.felipearpa.com/co?p1=1&p10=10"),
                arrayOf("felipearpa.com")
            )
        }
    }

}

@RunWith(Parameterized::class)
class UrlWithInvalidValuesTest(private val value: String) {

    @Test
    fun `given an invalid string when an Url is created then an exception is raised`() {
        assertThrows(
            IllegalArgumentException::class.java
        ) {
            Url(value)
        }
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(""),
                arrayOf(" "),
                arrayOf("felipearpa")
            )
        }
    }

}