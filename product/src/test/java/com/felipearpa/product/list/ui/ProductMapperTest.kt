package com.felipearpa.product.list.ui

import com.felipearpa.product.domain.Installment
import com.felipearpa.product.domain.Product
import com.felipearpa.product.domain.ProductCondition
import com.felipearpa.product.domain.Shipping
import org.junit.Test
import kotlin.test.assertEquals

class ProductMapperTest {
    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = Product(
            id = "id",
            title = "title",
            price = 100000.0,
            salePrice = 100000.0,
            condition = ProductCondition.NEW,
            thumbnail = "felipearpa.com",
            installment = Installment(
                quantity = 1,
                amount = 1000000.0
            ),
            shipping = Shipping(
                isFreeShipping = true
            )
        )

        val viewModel = domainModel.toProductModel()

        assertEquals(expected = domainModel.id, actual = viewModel.id)
        assertEquals(expected = domainModel.title, actual = viewModel.title)
        assertEquals(expected = domainModel.price, actual = viewModel.price)
        assertEquals(expected = domainModel.salePrice, actual = viewModel.salePrice)
        assertEquals(expected = domainModel.thumbnail, actual = viewModel.thumbnail)
    }
}