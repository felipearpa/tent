package com.felipearpa.product.detail.ui

import com.felipearpa.product.detail.domain.ProductDetail
import com.felipearpa.product.detail.domain.ProductShipping
import com.felipearpa.product.domain.ProductCondition
import org.junit.Test
import kotlin.test.assertEquals

class ProductDetailMapperTest {
    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = ProductDetail(
            id = "id",
            title = "title",
            description = null,
            price = 100000.0,
            availableQuantity = 1,
            soldQuantity = 1,
            condition = ProductCondition.NEW,
            shipping = ProductShipping(isFreeShipping = true),
            pictures = emptyList(),
            attributes = emptyList(),
            isProtectedPurchase = true
        )

        val viewModel = domainModel.toProductDetailModel()

        assertEquals(expected = domainModel.id, actual = viewModel.id)
        assertEquals(expected = domainModel.title, actual = viewModel.title)
        assertEquals(expected = domainModel.price, actual = viewModel.price.toDouble(), 0.0)
        assertEquals(expected = domainModel.availableQuantity, actual = viewModel.availableQuantity)
        assertEquals(
            expected = domainModel.isProtectedPurchase,
            actual = viewModel.isProtectedPurchase
        )
    }
}