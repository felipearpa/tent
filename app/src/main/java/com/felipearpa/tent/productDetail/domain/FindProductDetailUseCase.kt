package com.felipearpa.tent.productDetail.domain

import com.felipearpa.tent.product.data.ProductRepository
import com.felipearpa.tent.productDescription.domain.FindProductDescriptionUseCase
import com.felipearpa.tent.productDetail.mapper.ProductDetailMapper
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

interface FindProductDetailUseCase {

    suspend fun execute(productId: String): ProductDetail

}

class DefaultFindProductDetailUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    private val findProductDescriptionUseCase: FindProductDescriptionUseCase
) :
    FindProductDetailUseCase {

    override suspend fun execute(productId: String): ProductDetail =
        coroutineScope {
            val productDetail =
                ProductDetailMapper.mapFromDataToDomain(productRepository.findDetail(productId = productId))

            val productDescriptionDeferred = async {
                findProductDescriptionUseCase.execute(productId = productId)
            }

            return@coroutineScope productDetail.copy(
                description = productDescriptionDeferred.await()
            )
        }

}