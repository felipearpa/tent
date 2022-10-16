package com.felipearpa.tent.product.mapper

import com.felipearpa.core.type.*
import com.felipearpa.tent.product.data.InstallmentResponse
import com.felipearpa.tent.product.data.ProductResponse
import com.felipearpa.tent.product.data.ShippingResponse
import com.felipearpa.tent.product.domain.Installment
import com.felipearpa.tent.product.domain.Product
import com.felipearpa.tent.product.domain.ProductCondition
import com.felipearpa.tent.product.domain.Shipping
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductMapperTest {

    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = ProductResponse(
            id = "id",
            title = "title",
            price = 100000,
            salePrice = 100000,
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

        val domainModel = ProductMapper.mapFromDataToDomain(dataModel)

        assertEquals(dataModel.id, domainModel.id.value)
        assertEquals(dataModel.title, domainModel.title.value)
        assertEquals(dataModel.price, domainModel.price.value.toLong())
        assertEquals(dataModel.salePrice, domainModel.salePrice?.value?.toLong())
        assertEquals(dataModel.thumbnail, domainModel.thumbnail.value)
    }

    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = Product(
            id = Identifier("id"),
            title = NonEmptyString("title"),
            price = Currency(100000.0),
            salePrice = Currency(100000.0),
            condition = ProductCondition.NEW,
            thumbnail = Url("felipearpa.com"),
            installment = Installment(
                quantity = Quantity(1),
                amount = Currency(1000000.0)
            ),
            shipping = Shipping(
                isFreeShipping = true
            )
        )

        val viewModel = ProductMapper.mapFromDomainToView(domainModel)

        assertEquals(domainModel.id.value, viewModel.id)
        assertEquals(domainModel.title.value, viewModel.title)
        assertEquals(domainModel.price.value.toLong(), viewModel.price)
        assertEquals(domainModel.salePrice?.value?.toLong(), viewModel.salePrice)
        assertEquals(domainModel.thumbnail.value, viewModel.thumbnail)
    }

}