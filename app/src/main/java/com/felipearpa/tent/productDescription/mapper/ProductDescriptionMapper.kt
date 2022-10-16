package com.felipearpa.tent.productDescription.mapper

import com.felipearpa.tent.productDescription.data.ProductDescriptionResponse
import com.felipearpa.tent.productDescription.domain.ProductDescription

object ProductDescriptionMapper {

    fun mapFromDataToDomain(dataModel: ProductDescriptionResponse): ProductDescription =
        ProductDescription(plainText = dataModel.plainText)

}