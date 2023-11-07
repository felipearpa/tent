package com.felipearpa.product.detail.domain

import org.junit.Test
import kotlin.test.assertEquals

class ProductDetailMapperTest {
    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = ProductDetailResponse(
            id = "id",
            title = "title",
            price = 100000.0,
            availableQuantity = 1,
            soldQuantity = 1,
            condition = "new",
            shipping = ProductShippingResponse(isFreeShipping = true),
            pictures = emptyList(),
            attributes = emptyList(),
            isProtectedPurchase = true
        )

        val domainModel = dataModel.toProductDetail()

        assertEquals(expected = dataModel.id, actual = domainModel.id)
        assertEquals(expected = dataModel.title, actual = domainModel.title)
        assertEquals(expected = dataModel.price, actual = domainModel.price)
        assertEquals(expected = dataModel.availableQuantity, actual = domainModel.availableQuantity)
        assertEquals(expected = dataModel.soldQuantity, domainModel.soldQuantity)
        assertEquals(
            expected = dataModel.isProtectedPurchase,
            actual = domainModel.isProtectedPurchase
        )
    }
}