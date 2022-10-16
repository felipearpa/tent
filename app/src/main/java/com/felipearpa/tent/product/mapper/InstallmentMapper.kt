package com.felipearpa.tent.product.mapper

import com.felipearpa.core.type.Currency
import com.felipearpa.core.type.Quantity
import com.felipearpa.tent.product.data.InstallmentResponse
import com.felipearpa.tent.product.domain.Installment
import com.felipearpa.tent.product.view.InstallmentModel

object InstallmentMapper {

    fun mapFromDataToDomain(dataModel: InstallmentResponse): Installment =
        Installment(quantity = Quantity(dataModel.quantity), amount = Currency(dataModel.amount))

    fun mapFromDomainToView(domainModel: Installment): InstallmentModel =
        InstallmentModel(quantity = domainModel.quantity.value, amount = domainModel.amount.value)

}