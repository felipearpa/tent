package com.felipearpa.tent.product.data

import com.felipearpa.core.paging.OffsetPage
import com.felipearpa.tent.productDescription.data.ProductDescriptionResponse
import com.felipearpa.tent.productDetail.data.ProductDetailResponse
import javax.inject.Inject

interface ProductRepository {

    suspend fun find(
        filterText: String,
        offset: Int? = null,
        limit: Int? = null
    ): OffsetPage<ProductResponse>

    suspend fun findDetail(productId: String): ProductDetailResponse

    suspend fun findDescription(productId: String): ProductDescriptionResponse

}

class ProductRemoteRepository @Inject constructor(private val productRemoteDataSource: ProductRemoteDataSource) :
    ProductRepository {

    override suspend fun find(
        filterText: String,
        offset: Int?,
        limit: Int?
    ): OffsetPage<ProductResponse> {
        val response =
            productRemoteDataSource.find(filterText = filterText, offset = offset, limit = limit)
        return OffsetPage(
            items = response.results,
            offset = response.paging.offset,
            limit = response.paging.limit,
            total = response.paging.total
        )
    }

    override suspend fun findDetail(productId: String): ProductDetailResponse =
        productRemoteDataSource.findDetail(productId = productId)

    override suspend fun findDescription(productId: String): ProductDescriptionResponse =
        productRemoteDataSource.findDescription(productId = productId)

}