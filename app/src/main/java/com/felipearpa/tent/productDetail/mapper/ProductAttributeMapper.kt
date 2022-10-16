package com.felipearpa.tent.productDetail.mapper

import com.felipearpa.core.type.Identifier
import com.felipearpa.core.type.NonEmptyString
import com.felipearpa.tent.productDetail.data.ProductAttributeResponse
import com.felipearpa.tent.productDetail.domain.ProductAttribute
import com.felipearpa.tent.productDetail.view.ProductAttributeModel

object ProductAttributeMapper {

    fun mapFromDataToDomain(dataModel: ProductAttributeResponse): ProductAttribute =
        ProductAttribute(
            id = Identifier(dataModel.id),
            name = NonEmptyString(dataModel.name),
            valueName = NonEmptyString(dataModel.valueName)
        )

    fun mapFromDomainToView(domainModel: ProductAttribute): ProductAttributeModel =
        ProductAttributeModel(
            id = domainModel.id.value,
            name = domainModel.name.value,
            valueName = domainModel.valueName.value
        )

}