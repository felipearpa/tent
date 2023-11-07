package com.felipearpa.product.detail.domain

import org.junit.Test
import kotlin.test.assertEquals

class ProductPictureMapperTest {
    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = ProductPictureResponse(
            id = "id",
            url = "felipearpa.com",
            secureUrl = "felipearpa.com",
            size = "100x100"
        )

        val domainModel = dataModel.toProductPicture()

        assertEquals(expected = dataModel.id, actual = domainModel.id)
        assertEquals(expected = dataModel.url, actual = domainModel.url)
        assertEquals(expected = dataModel.secureUrl, actual = domainModel.secureUrl)
        assertEquals(expected = dataModel.size, actual = domainModel.size.value)
    }
}