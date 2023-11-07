package com.felipearpa.product.domain

import org.junit.Test
import kotlin.test.assertEquals

class InstallmentMapperTest {
    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = InstallmentResponse(
            quantity = 1,
            amount = 100000.0
        )

        val domainModel = dataModel.toInstallment()

        assertEquals(expected = dataModel.quantity, actual = domainModel.quantity)
        assertEquals(expected = dataModel.amount, actual = domainModel.amount)
    }
}