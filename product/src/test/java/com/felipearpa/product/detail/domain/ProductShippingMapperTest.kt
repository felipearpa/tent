package com.felipearpa.product.detail.domain

import org.junit.Test
import kotlin.test.assertEquals

class ProductShippingMapperTest {
    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = ProductShippingResponse(isFreeShipping = true)

        val domainModel = dataModel.toProductShipping()

        assertEquals(expected = dataModel.isFreeShipping, actual = domainModel.isFreeShipping)
    }
}