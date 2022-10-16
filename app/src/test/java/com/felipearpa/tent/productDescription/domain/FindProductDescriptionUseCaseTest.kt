package com.felipearpa.tent.productDescription.domain

import com.felipearpa.tent.product.data.ProductRepository
import com.felipearpa.tent.productDescription.data.ProductDescriptionResponse
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class FindProductDescriptionUseCaseTest {

    private val productRepository = mockk<ProductRepository>()

    private val findProductDescriptionUseCase =
        DefaultFindProductDescriptionUseCase(productRepository = productRepository)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `given a product id when a use case to get the product's description is performed then the product's description is returned`() =
        runTest {
            coEvery { productRepository.findDescription(productId = any()) } returns ProductDescriptionResponse(
                plainText = "description"
            )

            findProductDescriptionUseCase.execute("id")

            coVerify { productRepository.findDescription(productId = any()) }
        }

}