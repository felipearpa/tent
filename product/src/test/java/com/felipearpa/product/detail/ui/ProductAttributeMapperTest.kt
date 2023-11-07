package com.felipearpa.product.detail.ui

import com.felipearpa.product.detail.domain.ProductAttribute
import org.junit.Test
import kotlin.test.assertEquals

class ProductAttributeMapperTest {
    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = ProductAttribute(
            id = "id",
            name = "name",
            valueName = "value name"
        )

        val viewModel = domainModel.toProductAttributeModel()

        assertEquals(expected = domainModel.id, actual = viewModel.id)
        assertEquals(expected = domainModel.name, actual = viewModel.name)
        assertEquals(expected = domainModel.valueName, actual = viewModel.valueName)
    }
}