package com.felipearpa.tent.productDetail.mapper

import com.felipearpa.core.type.Currency
import com.felipearpa.core.type.Identifier
import com.felipearpa.core.type.NonEmptyString
import com.felipearpa.core.type.Quantity
import com.felipearpa.tent.product.domain.ProductCondition
import com.felipearpa.tent.productDetail.data.ProductDetailResponse
import com.felipearpa.tent.productDetail.domain.ProductDetail
import com.felipearpa.tent.productDetail.domain.ProductShipping
import com.felipearpa.tent.productDetail.view.ProductDetailModel
import com.felipearpa.tent.productDetail.view.ProductShippingModel

object ProductDetailMapper {

    fun mapFromDataToDomain(dataModel: ProductDetailResponse): ProductDetail =
        ProductDetail(
            id = Identifier(dataModel.id),
            title = NonEmptyString(dataModel.title),
            description = null,
            price = Currency(dataModel.price.toDouble()),
            availableQuantity = Quantity(dataModel.availableQuantity),
            soldQuantity = Quantity(dataModel.soldQuantity),
            condition = ProductCondition.valueOf(dataModel.condition.uppercase()),
            shipping = ProductShipping(
                isFreeShipping = dataModel.shipping.isFreeShipping
            ),
            pictures = dataModel.pictures.map(ProductPictureMapper::mapFromDataToDomain),
            attributes = dataModel.attributes.map(ProductAttributeMapper::mapFromDataToDomain),
            isProtectedPurchase = dataModel.isProtectedPurchase
        )

    fun mapFromDomainToView(domainModel: ProductDetail): ProductDetailModel =
        ProductDetailModel(
            id = domainModel.id.value,
            title = domainModel.title.value,
            price = domainModel.price.value.toInt(),
            availableQuantity = domainModel.availableQuantity.value,
            soldQuantity = domainModel.soldQuantity.value,
            condition = domainModel.condition,
            shipping = ProductShippingModel(
                isFreeShipping = domainModel.shipping.isFreeShipping
            ),
            pictures = domainModel.pictures.map(ProductPictureMapper::mapFromDomainToView),
            attributes = domainModel.attributes.map(ProductAttributeMapper::mapFromDomainToView),
            isProtectedPurchase = domainModel.isProtectedPurchase,
            description = domainModel.description?.plainText
        )

}