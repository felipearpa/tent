package com.felipearpa.tent.type

import com.felipearpa.core.type.Url
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

class PictureSizeWithValidValuesTest {

    @Test
    fun `given a valid size raw when a PictureSize is created then a PictureSize with that dimensions is returned`() {
        val sizeRaw = "100x200"

        val pictureSize = PictureSize(sizeRaw)

        assertEquals(100, pictureSize.width)
        assertEquals(200, pictureSize.height)
    }

}

@RunWith(Parameterized::class)
class PictureSizeWithInvalidValuesTest(private val value: String) {

    @Test
    fun `given an invalid size raw when a PictureSize is created then an exception is raised`() {
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
                arrayOf("100"),
                arrayOf("100x"),
                arrayOf("x100"),
                arrayOf("felipearpa")
            )
        }
    }

}