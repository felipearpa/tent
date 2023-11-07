package com.felipearpa.core

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NullTest {
    @Test
    fun `given a null variable when ifNull is performed then an action is executed`() {
        val nullableVar: Int? = null
        var isExecuted = false

        nullableVar.ifNull {
            isExecuted = true
        }

        assertTrue(actual = isExecuted, message = "ifNull wasn't executed")
    }

    @Test
    fun `given a null variable when ifNotNull is performed then an action isn't executed`() {
        val nullableVar: Int? = null
        var isExecuted = false

        nullableVar.ifNotNull {
            isExecuted = true
        }

        assertFalse(actual = isExecuted, message = "ifNotNull was executed")
    }

    @Test
    fun `given a non null variable when ifNull is performed then an action isn't executed`() {
        val nullableVar: Int?
        nullableVar = 0
        var isExecuted = false

        nullableVar.ifNull {
            isExecuted = true
        }

        assertFalse(actual = isExecuted, message = "ifNull was executed")
    }

    @Test
    fun `given a non null variable when ifNotNull is performed then an action is executed`() {
        val nullableVar: Int?
        nullableVar = 0
        var isExecuted = false

        nullableVar.ifNotNull {
            isExecuted = true
        }

        assertTrue(actual = isExecuted, message = "ifNotNull wasn't executed")
    }
}