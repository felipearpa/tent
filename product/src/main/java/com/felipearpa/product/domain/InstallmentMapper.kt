package com.felipearpa.product.domain

fun InstallmentResponse.toInstallment() =
    Installment(quantity = this.quantity, amount = this.amount)