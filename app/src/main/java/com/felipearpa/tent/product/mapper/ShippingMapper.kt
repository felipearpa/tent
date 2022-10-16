package com.felipearpa.tent.product.mapper

import com.felipearpa.tent.product.data.ShippingResponse
import com.felipearpa.tent.product.domain.Shipping
import com.felipearpa.tent.product.view.ShippingModel

object ShippingMapper {

    fun mapFromDataToDomain(dataModel: ShippingResponse): Shipping =
        Shipping(isFreeShipping = dataModel.isFreeShipping)

    fun mapFromDomainToView(domainModel: Shipping): ShippingModel =
        ShippingModel(isFreeShipping = domainModel.isFreeShipping)

}