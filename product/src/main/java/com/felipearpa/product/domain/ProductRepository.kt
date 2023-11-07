package com.felipearpa.product.domain

import com.felipearpa.core.paging.OffsetPage
import com.felipearpa.product.description.domain.ProductDescription
import com.felipearpa.product.detail.domain.ProductDetail

interface ProductRepository {
    suspend fun find(
        filterText: String,
        offset: Int? = null,
        limit: Int? = null
    ): Result<OffsetPage<Product>>

    suspend fun findDetail(productId: String): Result<ProductDetail>

    suspend fun findDescription(productId: String): Result<ProductDescription>
}