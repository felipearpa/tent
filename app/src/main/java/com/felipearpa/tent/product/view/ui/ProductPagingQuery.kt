package com.felipearpa.tent.product.view.ui

import com.felipearpa.core.paging.OffsetPage
import com.felipearpa.core.paging.OffsetPagingQuery
import com.felipearpa.tent.product.domain.FindProductsUseCase
import com.felipearpa.tent.product.mapper.ProductMapper
import com.felipearpa.tent.product.view.ProductModel

class ProductPagingQuery(
    private val findProductsUseCase: FindProductsUseCase,
    private val filterFunc: (() -> String)
) :
    OffsetPagingQuery<ProductModel> {

    override suspend fun execute(offset: Int?, limit: Int): OffsetPage<ProductModel> =
        findProductsUseCase.execute(filterText = filterFunc(), offset = offset, limit = limit)
            .map(ProductMapper::mapFromDomainToView)

}