package com.felipearpa.product.detail.domain

import org.junit.Test
import kotlin.test.assertEquals

class ProductAttributeMapperTest {
    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = ProductAttributeResponse(
            id = "id",
            name = "name",
            valueName = "value name"
        )

        val domainModel = dataModel.toProductAttribute()

        assertEquals(expected = dataModel.id, actual = domainModel.id)
        assertEquals(expected = dataModel.name, actual = domainModel.name)
        assertEquals(expected = dataModel.valueName, actual = domainModel.valueName)
    }
}