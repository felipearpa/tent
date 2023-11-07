package com.felipearpa.product.domain

import org.junit.Test
import kotlin.test.assertEquals

class ProductMapperTest {
    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = ProductResponse(
            id = "id",
            title = "title",
            price = 100000.0,
            salePrice = 100000.0,
            condition = "new",
            thumbnail = "felipearpa.com",
            installment = InstallmentResponse(
                quantity = 1,
                amount = 1000000.0
            ),
            shipping = ShippingResponse(
                isFreeShipping = true
            )
        )

        val domainModel = dataModel.toProduct()

        assertEquals(expected = dataModel.id, actual = domainModel.id)
        assertEquals(expected = dataModel.title, actual = domainModel.title)
        assertEquals(expected = dataModel.price, actual = domainModel.price)
        assertEquals(expected = dataModel.salePrice, actual = domainModel.salePrice)
        assertEquals(expected = dataModel.thumbnail, actual = domainModel.thumbnail)
    }
}