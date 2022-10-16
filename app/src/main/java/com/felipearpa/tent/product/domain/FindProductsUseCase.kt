package com.felipearpa.tent.product.domain

import com.felipearpa.core.paging.OffsetPage
import com.felipearpa.tent.product.data.ProductRepository
import com.felipearpa.tent.product.mapper.ProductMapper
import javax.inject.Inject

interface FindProductsUseCase {

    suspend fun execute(
        filterText: String,
        offset: Int? = null,
        limit: Int? = null
    ): OffsetPage<Product>

}

class DefaultFindProductsUseCase @Inject constructor(private val productRepository: ProductRepository) :
    FindProductsUseCase {

    override suspend fun execute(
        filterText: String,
        offset: Int?,
        limit: Int?
    ): OffsetPage<Product> =
        productRepository.find(filterText = filterText, offset = offset, limit = limit)
            .map(ProductMapper::mapFromDataToDomain)

}