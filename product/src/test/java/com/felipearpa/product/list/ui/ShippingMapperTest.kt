package com.felipearpa.product.list.ui

import com.felipearpa.product.domain.Shipping
import org.junit.Test
import kotlin.test.assertEquals

class ShippingMapperTest {
    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = Shipping(
            isFreeShipping = true
        )

        val viewModel = domainModel.toShippingModel()

        assertEquals(expected = domainModel.isFreeShipping, actual = viewModel.isFreeShipping)
    }
}