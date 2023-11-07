package com.felipearpa.product.list.application

import com.felipearpa.core.paging.emptyOffsetPage
import com.felipearpa.product.domain.ProductRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class FindProductsUseCaseTest {
    private val productRepository = mockk<ProductRepository>()

    private val findProducts = FindProductsUseCase(productRepository = productRepository)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `given a filter text when a use case to get a list of products is performed then the list of products is returned`() =
        runTest {
            coEvery {
                productRepository.find(
                    filterText = any(),
                    offset = any(),
                    limit = any()
                )
            } returns Result.success(emptyOffsetPage())

            findProducts.execute(filterText = "filter")

            coVerify {
                productRepository.find(
                    filterText = any(),
                    offset = any(),
                    limit = any()
                )
            }
        }
}