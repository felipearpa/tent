package com.felipearpa.product.description.application

import com.felipearpa.product.description.domain.ProductDescription
import com.felipearpa.product.domain.ProductRepository
import javax.inject.Inject

class FindProductDescriptionUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun execute(productId: String): Result<ProductDescription> =
        productRepository.findDescription(productId = productId)
}