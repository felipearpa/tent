package com.felipearpa.product.list.application

import com.felipearpa.core.paging.OffsetPage
import com.felipearpa.product.domain.Product
import com.felipearpa.product.domain.ProductRepository
import javax.inject.Inject

class FindProductsUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun execute(
        filterText: String,
        offset: Int? = null,
        limit: Int? = null
    ): Result<OffsetPage<Product>> =
        productRepository.find(filterText = filterText, offset = offset, limit = limit)
}