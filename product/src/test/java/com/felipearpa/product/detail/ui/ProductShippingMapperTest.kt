package com.felipearpa.product.detail.ui

import com.felipearpa.product.detail.domain.ProductShipping
import org.junit.Test
import kotlin.test.assertEquals

class ProductShippingMapperTest {
    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = ProductShipping(isFreeShipping = true)

        val viewModel = domainModel.toProductShippingModel()

        assertEquals(expected = domainModel.isFreeShipping, actual = viewModel.isFreeShipping)
    }
}