package com.felipearpa.tent.productDetail.mapper

import com.felipearpa.tent.productDetail.data.ProductShippingResponse
import com.felipearpa.tent.productDetail.domain.ProductShipping
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductShippingMapperTest {

    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = ProductShippingResponse(isFreeShipping = true)

        val domainModel = ProductShippingMapper.mapFromDataToDomain(dataModel)

        assertEquals(dataModel.isFreeShipping, domainModel.isFreeShipping)
    }

    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = ProductShipping(isFreeShipping = true)

        val viewModel = ProductShippingMapper.mapFromDomainToView(domainModel)

        assertEquals(domainModel.isFreeShipping, viewModel.isFreeShipping)
    }

}