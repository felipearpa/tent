package com.felipearpa.product.list.infrastructure

import com.felipearpa.core.network.NetworkExceptionHandler
import com.felipearpa.product.description.domain.ProductDescriptionResponse
import com.felipearpa.product.detail.domain.ProductDetailResponse
import com.felipearpa.product.detail.domain.ProductShippingResponse
import com.felipearpa.product.domain.PagingResponse
import com.felipearpa.product.domain.ProductRemoteDataSource
import com.felipearpa.product.domain.ProductSearchResponse
import com.felipearpa.product.infrastructure.ProductRemoteRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.slot
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ProductRemoteRepositoryTest {
    private val productRemoteDataSource = mockk<ProductRemoteDataSource>()

    private val networkExceptionHandler = mockk<NetworkExceptionHandler>()

    private val productRemoteRepository =
        ProductRemoteRepository(
            productRemoteDataSource = productRemoteDataSource,
            networkExceptionHandler = networkExceptionHandler
        )

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `given a filter text when a request to get a list of products is performed then the list of products is returned`() =
        runTest {
            coEvery {
                productRemoteDataSource.find(filterText = any(), offset = any(), limit = any())
            } returns ProductSearchResponse(
                paging = PagingResponse(
                    total = 0,
                    offset = 0,
                    limit = 0
                ),
                results = emptyList()
            )

            val blockSlot = slot<suspend () -> ProductSearchResponse>()
            coEvery { networkExceptionHandler.handle(capture(blockSlot)) } coAnswers {
                Result.success(blockSlot.captured())
            }

            productRemoteRepository.find(filterText = "filter")

            coVerify {
                productRemoteDataSource.find(
                    filterText = any(),
                    offset = any(),
                    limit = any()
                )
            }
        }

    @Test
    fun `given a product id when a request to get the product's description is performed then the product's description is returned`() =
        runTest {
            coEvery { productRemoteDataSource.findDescription(productId = any()) } returns ProductDescriptionResponse(
                plainText = "description"
            )

            val blockSlot = slot<suspend () -> ProductDescriptionResponse>()
            coEvery { networkExceptionHandler.handle(capture(blockSlot)) } coAnswers {
                Result.success(blockSlot.captured())
            }

            productRemoteRepository.findDescription(productId = "id")

            coVerify { productRemoteDataSource.findDescription(productId = any()) }
        }

    @Test
    fun `given a product id when a request to get the product's detail is performed then the product's detail is returned`() =
        runTest {
            coEvery { productRemoteDataSource.findDetail(productId = any()) } returns ProductDetailResponse(
                id = "id",
                title = "title",
                price = 100000.0,
                availableQuantity = 1,
                soldQuantity = 1,
                condition = "new",
                shipping = ProductShippingResponse(isFreeShipping = true),
                pictures = emptyList(),
                attributes = emptyList(),
                isProtectedPurchase = true
            )

            val blockSlot = slot<suspend () -> ProductDetailResponse>()
            coEvery { networkExceptionHandler.handle(capture(blockSlot)) } coAnswers {
                Result.success(blockSlot.captured())
            }

            productRemoteRepository.findDetail(productId = "id")

            coVerify { productRemoteDataSource.findDetail(productId = any()) }
        }
}