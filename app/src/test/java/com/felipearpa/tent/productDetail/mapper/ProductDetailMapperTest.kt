package com.felipearpa.tent.productDetail.mapper

import com.felipearpa.core.type.Currency
import com.felipearpa.core.type.Identifier
import com.felipearpa.core.type.NonEmptyString
import com.felipearpa.core.type.Quantity
import com.felipearpa.tent.product.domain.ProductCondition
import com.felipearpa.tent.productDetail.data.ProductDetailResponse
import com.felipearpa.tent.productDetail.data.ProductShippingResponse
import com.felipearpa.tent.productDetail.domain.ProductDetail
import com.felipearpa.tent.productDetail.domain.ProductShipping
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductDetailMapperTest {

    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = ProductDetailResponse(
            id = "id",
            title = "title",
            price = 100000L,
            availableQuantity = 1,
            soldQuantity = 1,
            condition = "new",
            shipping = ProductShippingResponse(isFreeShipping = true),
            pictures = emptyList(),
            attributes = emptyList(),
            isProtectedPurchase = true
        )

        val domainModel = ProductDetailMapper.mapFromDataToDomain(dataModel)

        assertEquals(dataModel.id, domainModel.id.value)
        assertEquals(dataModel.title, domainModel.title.value)
        assertEquals(dataModel.price, domainModel.price.value.toLong())
        assertEquals(dataModel.availableQuantity, domainModel.availableQuantity.value)
        assertEquals(dataModel.soldQuantity, domainModel.soldQuantity.value)
        assertEquals(dataModel.isProtectedPurchase, domainModel.isProtectedPurchase)
    }

    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = ProductDetail(
            id = Identifier("id"),
            title = NonEmptyString("title"),
            description = null,
            price = Currency(100000.0),
            availableQuantity = Quantity(1),
            soldQuantity = Quantity(1),
            condition = ProductCondition.NEW,
            shipping = ProductShipping(isFreeShipping = true),
            pictures = emptyList(),
            attributes = emptyList(),
            isProtectedPurchase = true
        )

        val viewModel = ProductDetailMapper.mapFromDomainToView(domainModel)

        assertEquals(domainModel.id.value, viewModel.id)
        assertEquals(domainModel.title.value, viewModel.title)
        assertEquals(domainModel.price.value, viewModel.price.toDouble(), 0.0)
        assertEquals(domainModel.availableQuantity.value, viewModel.availableQuantity)
        assertEquals(domainModel.isProtectedPurchase, viewModel.isProtectedPurchase)
    }

}