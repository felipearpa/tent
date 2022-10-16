package com.felipearpa.tent.productDetail.mapper

import com.felipearpa.core.type.Identifier
import com.felipearpa.core.type.Url
import com.felipearpa.tent.productDetail.data.ProductPictureResponse
import com.felipearpa.tent.productDetail.domain.ProductPicture
import com.felipearpa.tent.type.PictureSize
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductPictureMapperTest {

    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = ProductPictureResponse(
            id = "id",
            url = "felipearpa.com",
            secureUrl = "felipearpa.com",
            size = "100x100"
        )

        val domainModel = ProductPictureMapper.mapFromDataToDomain(dataModel)

        assertEquals(dataModel.id, domainModel.id.value)
        assertEquals(dataModel.url, domainModel.url.value)
        assertEquals(dataModel.secureUrl, domainModel.secureUrl.value)
        assertEquals(dataModel.size, domainModel.size.value)
    }

    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = ProductPicture(
            id = Identifier("id"),
            url = Url("felipearpa.com"),
            secureUrl = Url("felipearpa.com"),
            size = PictureSize("100x100")
        )

        val viewModel = ProductPictureMapper.mapFromDomainToView(domainModel)

        assertEquals(domainModel.id.value, viewModel.id)
        assertEquals(domainModel.url.value, viewModel.url)
        assertEquals(domainModel.secureUrl.value, viewModel.secureUrl)
        assertEquals(domainModel.size.width, viewModel.width)
        assertEquals(domainModel.size.height, viewModel.height)
    }

}