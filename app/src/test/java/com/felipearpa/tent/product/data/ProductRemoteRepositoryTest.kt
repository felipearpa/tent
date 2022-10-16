package com.felipearpa.tent.product.data

import com.felipearpa.tent.productDescription.data.ProductDescriptionResponse
import com.felipearpa.tent.productDetail.data.ProductDetailResponse
import com.felipearpa.tent.productDetail.data.ProductShippingResponse
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ProductRemoteRepositoryTest {

    private val productRemoteDataSource = mockk<ProductRemoteDataSource>()

    private val productRemoteRepository =
        ProductRemoteRepository(productRemoteDataSource = productRemoteDataSource)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
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

            productRemoteRepository.find(filterText = "filter")

            coVerify {
                productRemoteDataSource.find(
                    filterText = any(),
                    offset = any(),
                    limit = any()
                )
            }
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `given a product id when a request to get the product's description is performed then the product's description is returned`() =
        runTest {
            coEvery { productRemoteDataSource.findDescription(productId = any()) } returns ProductDescriptionResponse(
                plainText = "description"
            )

            productRemoteRepository.findDescription(productId = "id")

            coVerify { productRemoteDataSource.findDescription(productId = any()) }
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `given a product id when a request to get the product's detail is performed then the product's detail is returned`() =
        runTest {
            coEvery { productRemoteDataSource.findDetail(productId = any()) } returns ProductDetailResponse(
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

            productRemoteRepository.findDetail(productId = "id")

            coVerify { productRemoteDataSource.findDetail(productId = any()) }
        }

}