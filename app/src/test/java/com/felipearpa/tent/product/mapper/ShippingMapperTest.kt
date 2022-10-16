package com.felipearpa.tent.product.mapper

import com.felipearpa.tent.product.data.ShippingResponse
import com.felipearpa.tent.product.domain.Shipping
import org.junit.Assert.assertEquals
import org.junit.Test

class ShippingMapperTest {

    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = ShippingResponse(
            isFreeShipping = true
        )

        val domainModel = ShippingMapper.mapFromDataToDomain(dataModel)

        assertEquals(dataModel.isFreeShipping, domainModel.isFreeShipping)
    }

    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = Shipping(
            isFreeShipping = true
        )

        val viewModel = ShippingMapper.mapFromDomainToView(domainModel)

        assertEquals(domainModel.isFreeShipping, viewModel.isFreeShipping)
    }

}