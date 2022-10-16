package com.felipearpa.tent.product.mapper

import com.felipearpa.core.type.Currency
import com.felipearpa.core.type.Quantity
import com.felipearpa.tent.product.data.InstallmentResponse
import com.felipearpa.tent.product.domain.Installment
import org.junit.Assert.assertEquals
import org.junit.Test

class InstallmentMapperTest {

    @Test
    fun `given a data model when is mapped to a domain model then an identical domain model is returned`() {
        val dataModel = InstallmentResponse(
            quantity = 1,
            amount = 100000.0
        )

        val domainModel = InstallmentMapper.mapFromDataToDomain(dataModel)

        assertEquals(dataModel.quantity, domainModel.quantity.value)
        assertEquals(dataModel.amount, domainModel.amount.value, 0.0)
    }

    @Test
    fun `given a domain model when is mapped to a view model then an identical view model is returned`() {
        val domainModel = Installment(
            quantity = Quantity(1),
            amount = Currency(100000.0)
        )

        val viewModel = InstallmentMapper.mapFromDomainToView(domainModel)

        assertEquals(domainModel.quantity.value, viewModel.quantity)
        assertEquals(domainModel.amount.value, viewModel.amount, 0.0)
    }

}