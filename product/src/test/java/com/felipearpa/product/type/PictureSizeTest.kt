package com.felipearpa.product.type

import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

class PictureSizeWithValidValuesTest {
    @Test
    fun `given a valid size raw when a PictureSize is created then a PictureSize with that dimensions is returned`() {
        val sizeRaw = "100x200"

        val pictureSize = PictureSize(sizeRaw)

        assertEquals(expected = 100, actual = pictureSize.width)
        assertEquals(expected = 200, actual = pictureSize.height)
    }
}

@RunWith(Parameterized::class)
class PictureSizeWithInvalidValuesTest(private val sizeRaw: String) {
    @Test
    fun `given an invalid size raw when a PictureSize is created then an exception is raised`() {
        assertThrows(
            IllegalArgumentException::class.java
        ) {
            PictureSize(sizeRaw)
        }
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(""),
                arrayOf("100"),
                arrayOf("100x"),
                arrayOf("x100"),
                arrayOf("felipearpa")
            )
        }
    }
}