package com.felipearpa.tent.productDetail.mapper

import com.felipearpa.tent.productDetail.data.ProductShippingResponse
import com.felipearpa.tent.productDetail.domain.ProductShipping
import com.felipearpa.tent.productDetail.view.ProductShippingModel

object ProductShippingMapper {

    fun mapFromDataToDomain(dataModel: ProductShippingResponse): ProductShipping =
        ProductShipping(isFreeShipping = dataModel.isFreeShipping)

    fun mapFromDomainToView(domainModel: ProductShipping): ProductShippingModel =
        ProductShippingModel(isFreeShipping = domainModel.isFreeShipping)

}