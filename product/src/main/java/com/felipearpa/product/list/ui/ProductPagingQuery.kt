package com.felipearpa.product.list.ui

import com.felipearpa.core.paging.OffsetPage
import com.felipearpa.core.paging.OffsetPagingQuery
import com.felipearpa.product.list.application.FindProductsUseCase

class ProductPagingQuery(
    private val findProductsUseCase: FindProductsUseCase,
    private val filterFunc: (() -> String)
) :
    OffsetPagingQuery<ProductModel> {
    override suspend fun execute(offset: Int?, limit: Int): Result<OffsetPage<ProductModel>> =
        findProductsUseCase.execute(filterText = filterFunc(), offset = offset, limit = limit)
            .map { page -> page.map { product -> product.toProductModel() } }
}