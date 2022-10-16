package com.felipearpa.tent.productDetail.mapper

import com.felipearpa.core.type.Identifier
import com.felipearpa.core.type.NonEmptyString
import com.felipearpa.tent.productDetail.data.ProductAttributeResponse
import com.felipearpa.tent.productDetail.domain.ProductAttribute
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductAttributeMapperTest {

    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = ProductAttributeResponse(
            id = "id",
            name = "name",
            valueName = "value name"
        )

        val domainModel = ProductAttributeMapper.mapFromDataToDomain(dataModel)

        assertEquals(dataModel.id, domainModel.id.value)
        assertEquals(dataModel.name, domainModel.name.value)
        assertEquals(dataModel.valueName, domainModel.valueName.value)
    }

    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = ProductAttribute(
            id = Identifier("id"),
            name = NonEmptyString("name"),
            valueName = NonEmptyString("value name")
        )

        val viewModel = ProductAttributeMapper.mapFromDomainToView(domainModel)

        assertEquals(domainModel.id.value, viewModel.id)
        assertEquals(domainModel.name.value, viewModel.name)
        assertEquals(domainModel.valueName.value, viewModel.valueName)
    }

}