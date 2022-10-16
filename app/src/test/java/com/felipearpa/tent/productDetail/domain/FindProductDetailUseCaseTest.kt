package com.felipearpa.tent.productDetail.domain

import com.felipearpa.tent.product.data.ProductRepository
import com.felipearpa.tent.productDescription.domain.FindProductDescriptionUseCase
import com.felipearpa.tent.productDescription.domain.ProductDescription
import com.felipearpa.tent.productDetail.data.ProductDetailResponse
import com.felipearpa.tent.productDetail.data.ProductShippingResponse
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class FindProductDetailUseCaseTest {

    private val productRepository = mockk<ProductRepository>()

    private val findProductDescriptionUseCase = mockk<FindProductDescriptionUseCase>()

    private val findProductDetailUseCase = DefaultFindProductDetailUseCase(
        productRepository = productRepository,
        findProductDescriptionUseCase = findProductDescriptionUseCase
    )

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `given a product id when a use case to get the product's detail is performed then the product's detail is returned`() = runTest {
        coEvery { productRepository.findDetail(productId = any()) } returns ProductDetailResponse(
            id = "id",
            title = "title",
            price = 100000L,
            availableQuantity = 1,
            soldQuantity = 1,
            condition = "new",
            shipping = ProductShippingResponse(isFreeShipping = true),
            pictures = emptyList(),
            attributes = emptyList(),
            isProtectedPurchase = true
        )

        coEvery { findProductDescriptionUseCase.execute(productId = any()) } returns ProductDescription(
            plainText = "description"
        )

        findProductDetailUseCase.execute("id")

        coVerify { productRepository.findDetail(productId = any()) }
        coEvery { findProductDescriptionUseCase.execute(productId = any()) }
    }

}