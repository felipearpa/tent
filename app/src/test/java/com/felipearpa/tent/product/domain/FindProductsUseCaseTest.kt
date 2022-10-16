package com.felipearpa.tent.product.domain

import com.felipearpa.core.paging.emptyOffsetPage
import com.felipearpa.tent.product.data.ProductRepository
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class FindProductsUseCaseTest {

    private val productRepository = mockk<ProductRepository>()

    private val findProducts = DefaultFindProductsUseCase(productRepository = productRepository)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `given a filter text when a use case to get a list of products is performed then the list of products is returned`() =
        runTest {
            coEvery {
                productRepository.find(
                    filterText = any(),
                    offset = any(),
                    limit = any()
                )
            } returns emptyOffsetPage()

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