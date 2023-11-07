package com.felipearpa.product.detail.application

import com.felipearpa.core.emptyString
import com.felipearpa.product.description.application.FindProductDescriptionUseCase
import com.felipearpa.product.description.domain.ProductDescription
import com.felipearpa.product.detail.domain.ProductDetail
import com.felipearpa.product.detail.domain.ProductShipping
import com.felipearpa.product.domain.ProductCondition
import com.felipearpa.product.domain.ProductRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class FindProductDetailUseCaseTest {

    private val productRepository = mockk<ProductRepository>()

    private val findProductDescriptionUseCase = mockk<FindProductDescriptionUseCase>()

    private val findProductDetailUseCase = FindProductDetailUseCase(
        productRepository = productRepository,
        findProductDescriptionUseCase = findProductDescriptionUseCase
    )

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `given a product id when a use case to get the product's detail is performed then the product's detail is returned`() =
        runTest {
            coEvery { productRepository.findDetail(productId = any()) } returns
                    Result.success(
                        ProductDetail(
                            id = "id",
                            title = "title",
                            price = 100000.0,
                            availableQuantity = 1,
                            soldQuantity = 1,
                            condition = ProductCondition.NEW,
                            shipping = ProductShipping(isFreeShipping = true),
                            pictures = emptyList(),
                            attributes = emptyList(),
                            description = ProductDescription(plainText = emptyString()),
                            isProtectedPurchase = true
                        )
                    )

            coEvery { findProductDescriptionUseCase.execute(productId = any()) } returns
                    Result.success(
                        ProductDescription(
                            plainText = "description"
                        )
                    )

            findProductDetailUseCase.execute("id")

            coVerify { productRepository.findDetail(productId = any()) }
            coEvery { findProductDescriptionUseCase.execute(productId = any()) }
        }
}