package com.felipearpa.product.list.ui

import com.felipearpa.product.domain.Installment

fun Installment.toInstallmentModel() =
    InstallmentModel(quantity = this.quantity, amount = this.amount)
