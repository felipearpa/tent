package com.felipearpa.product.detail.ui

import com.felipearpa.product.detail.domain.ProductPicture
import com.felipearpa.product.type.PictureSize
import org.junit.Test
import kotlin.test.assertEquals

class ProductPictureMapperTest {
    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = ProductPicture(
            id = "id",
            url = "felipearpa.com",
            secureUrl = "felipearpa.com",
            size = PictureSize("100x100")
        )

        val viewModel = domainModel.toProductPictureModel()

        assertEquals(expected = domainModel.id, actual = viewModel.id)
        assertEquals(expected = domainModel.url, actual = viewModel.url)
        assertEquals(expected = domainModel.secureUrl, actual = viewModel.secureUrl)
        assertEquals(expected = domainModel.size.width, actual = viewModel.width)
        assertEquals(expected = domainModel.size.height, actual = viewModel.height)
    }
}