package com.felipearpa.core.paging

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class OffsetPagePreviousTest(
    private val offset: Int,
    private val limit: Int,
    private val expectedPrevious: Int?
) {
    @Test
    fun `given an offset and a limit when previous() is performed then previous is returned`() {
        val page = OffsetPage(
            items = emptyList(),
            offset = offset,
            limit = limit,
            total = 0
        )

        val previous = page.previous()

        assertEquals(
            expected = expectedPrevious,
            actual = previous,
            message = "Previous value isn't correct"
        )
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            return listOf(
                arrayOf(0, 10, null),
                arrayOf(5, 10, null),
                arrayOf(10, 10, null),
                arrayOf(20, 10, 10)
            )
        }
    }
}

@RunWith(Parameterized::class)
class OffsetPageNextTest(
    private val offset: Int,
    private val limit: Int,
    private val total: Int,
    private val expectedNext: Int?
) {
    @Test
    fun `given an offset, a limit, and a total when next() is performed then next is returned`() {
        val page = OffsetPage(
            items = emptyList(),
            offset = offset,
            limit = limit,
            total = total
        )

        val next = page.next()

        assertEquals(expected = expectedNext, actual = next, message = "Next page isn't correct")
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            return listOf(
                arrayOf(0, 10, 20, 10),
                arrayOf(0, 10, 10, null),
                arrayOf(0, 10, 5, null)
            )
        }
    }
}