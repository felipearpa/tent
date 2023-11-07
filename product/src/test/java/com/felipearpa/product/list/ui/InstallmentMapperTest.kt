package com.felipearpa.product.list.ui

import com.felipearpa.product.domain.Installment
import org.junit.Test
import kotlin.test.assertEquals

class InstallmentMapperTest {
    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = Installment(
            quantity = 1,
            amount = 100000.0
        )

        val viewModel = domainModel.toInstallmentModel()

        assertEquals(expected = domainModel.quantity, actual = viewModel.quantity)
        assertEquals(expected = domainModel.amount, actual = viewModel.amount)
    }
}