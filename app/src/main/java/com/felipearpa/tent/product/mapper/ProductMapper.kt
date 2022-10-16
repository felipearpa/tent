package com.felipearpa.tent.product.mapper

import com.felipearpa.core.type.Currency
import com.felipearpa.core.type.Identifier
import com.felipearpa.core.type.NonEmptyString
import com.felipearpa.core.type.Url
import com.felipearpa.tent.product.data.ProductResponse
import com.felipearpa.tent.product.domain.Product
import com.felipearpa.tent.product.domain.ProductCondition
import com.felipearpa.tent.product.view.ProductModel

object ProductMapper {

    fun mapFromDataToDomain(dataModel: ProductResponse): Product =
        Product(
            id = Identifier(dataModel.id),
            title = NonEmptyString(dataModel.title),
            price = Currency(dataModel.price.toDouble()),
            salePrice = dataModel.salePrice?.let { salePrice -> Currency(salePrice.toDouble()) },
            condition = ProductCondition.valueOf(dataModel.condition.uppercase()),
            thumbnail = Url(dataModel.thumbnail),
            installment = InstallmentMapper.mapFromDataToDomain(dataModel.installment),
            shipping = ShippingMapper.mapFromDataToDomain(dataModel.shipping)
        )

    fun mapFromDomainToView(domainModel: Product): ProductModel =
        ProductModel(
            id = domainModel.id.value,
            title = domainModel.title.value,
            price = domainModel.price.value.toLong(),
            salePrice = domainModel.salePrice?.value?.toLong(),
            condition = domainModel.condition.toString().lowercase(),
            thumbnail = domainModel.thumbnail.value,
            installment = InstallmentMapper.mapFromDomainToView(domainModel.installment),
            shipping = ShippingMapper.mapFromDomainToView(domainModel.shipping)
        )

}