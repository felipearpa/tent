package com.felipearpa.product.description.application

import com.felipearpa.product.description.domain.ProductDescription
import com.felipearpa.product.domain.ProductRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class FindProductDescriptionUseCaseTest {
    private val productRepository = mockk<ProductRepository>()

    private val findProductDescriptionUseCase =
        FindProductDescriptionUseCase(productRepository = productRepository)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `given a product id when a use case to get the product's description is performed then the product's description is returned`() =
        runTest {
            coEvery { productRepository.findDescription(productId = any()) } returns
                    Result.success(
                        ProductDescription(
                            plainText = "description"
                        )
                    )

            findProductDescriptionUseCase.execute("id")

            coVerify { productRepository.findDescription(productId = any()) }
        }
}