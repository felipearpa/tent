package com.felipearpa.tent.productDescription.domain

import com.felipearpa.tent.product.data.ProductRepository
import com.felipearpa.tent.productDescription.mapper.ProductDescriptionMapper
import javax.inject.Inject

interface FindProductDescriptionUseCase {

    suspend fun execute(productId: String): ProductDescription

}

class DefaultFindProductDescriptionUseCase @Inject constructor(private val productRepository: ProductRepository) :
    FindProductDescriptionUseCase {

    override suspend fun execute(productId: String): ProductDescription =
        ProductDescriptionMapper.mapFromDataToDomain(productRepository.findDescription(productId = productId))

}