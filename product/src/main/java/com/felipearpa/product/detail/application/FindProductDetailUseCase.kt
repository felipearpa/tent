package com.felipearpa.product.detail.application

import com.felipearpa.product.description.application.FindProductDescriptionUseCase
import com.felipearpa.product.detail.domain.ProductDetail
import com.felipearpa.product.domain.ProductRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class FindProductDetailUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    private val findProductDescriptionUseCase: FindProductDescriptionUseCase
) {
    suspend fun execute(productId: String): Result<ProductDetail> =
        coroutineScope {
            val productDetailResultDeferred = async {
                productRepository.findDetail(productId = productId)
            }

            val productDescriptionResultDeferred = async {
                findProductDescriptionUseCase.execute(productId = productId)
            }

            val productDetailResult = productDetailResultDeferred.await()
            val productDescriptionResult = productDescriptionResultDeferred.await()

            if (productDetailResult.isFailure || productDescriptionResult.isFailure)
                return@coroutineScope Result.failure(RuntimeException())

            val fullProductDetail = productDetailResult.getOrNull()!!.copy(
                description = productDescriptionResult.getOrNull()!!
            )

            return@coroutineScope Result.success(fullProductDetail)
        }
}