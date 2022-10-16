package com.felipearpa.tent.productDetail.mapper

import com.felipearpa.core.type.Identifier
import com.felipearpa.core.type.Url
import com.felipearpa.tent.productDetail.data.ProductPictureResponse
import com.felipearpa.tent.productDetail.domain.ProductPicture
import com.felipearpa.tent.productDetail.view.ProductPictureModel
import com.felipearpa.tent.type.PictureSize

object ProductPictureMapper {

    fun mapFromDataToDomain(dataModel: ProductPictureResponse): ProductPicture =
        ProductPicture(
            id = Identifier(dataModel.id),
            url = Url(dataModel.url),
            secureUrl = Url(dataModel.secureUrl),
            size = PictureSize(dataModel.size)
        )

    fun mapFromDomainToView(domainModel: ProductPicture): ProductPictureModel =
        ProductPictureModel(
            id = domainModel.id.value,
            url = domainModel.url.value,
            secureUrl = domainModel.secureUrl.value,
            width = domainModel.size.width,
            height = domainModel.size.height
        )

}