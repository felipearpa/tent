package com.felipearpa.product.domain

import org.junit.Test
import kotlin.test.assertEquals

class ShippingMapperTest {
    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = ShippingResponse(
            isFreeShipping = true
        )

        val domainModel = dataModel.toShipping()

        assertEquals(expected = dataModel.isFreeShipping, actual = domainModel.isFreeShipping)
    }
}