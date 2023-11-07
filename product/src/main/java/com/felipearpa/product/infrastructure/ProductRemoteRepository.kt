package com.felipearpa.product.infrastructure

import com.felipearpa.core.network.NetworkExceptionHandler
import com.felipearpa.core.network.recoverNetworkException
import com.felipearpa.core.paging.OffsetPage
import com.felipearpa.product.description.domain.ProductDescription
import com.felipearpa.product.description.domain.toProductDescription
import com.felipearpa.product.detail.domain.ProductDetail
import com.felipearpa.product.detail.domain.toProductDetail
import com.felipearpa.product.domain.Product
import com.felipearpa.product.domain.ProductRemoteDataSource
import com.felipearpa.product.domain.ProductRepository
import com.felipearpa.product.domain.toProduct
import javax.inject.Inject

class ProductRemoteRepository @Inject constructor(
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val networkExceptionHandler: NetworkExceptionHandler
) :
    ProductRepository {
    override suspend fun find(
        filterText: String,
        offset: Int?,
        limit: Int?
    ): Result<OffsetPage<Product>> {
        return networkExceptionHandler.handle {
            val response =
                productRemoteDataSource.find(
                    filterText = filterText,
                    offset = offset,
                    limit = limit
                )
            return@handle OffsetPage(
                items = response.results.map { productResponse -> productResponse.toProduct() },
                offset = response.paging.offset,
                limit = response.paging.limit,
                total = response.paging.total
            )
        }.recoverNetworkException { exception ->
            return Result.failure(exception)
        }
    }

    override suspend fun findDetail(productId: String): Result<ProductDetail> {
        return networkExceptionHandler.handle {
            productRemoteDataSource.findDetail(productId = productId).toProductDetail()
        }.recoverNetworkException { exception ->
            return Result.failure(exception)
        }
    }

    override suspend fun findDescription(productId: String): Result<ProductDescription> {
        return networkExceptionHandler.handle {
            productRemoteDataSource.findDescription(productId = productId).toProductDescription()
        }.recoverNetworkException { exception ->
            return Result.failure(exception)
        }
    }
}