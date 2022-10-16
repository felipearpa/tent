package com.felipearpa.tent.product.data

import com.felipearpa.tent.productDescription.data.ProductDescriptionResponse
import com.felipearpa.tent.productDetail.data.ProductDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductRemoteDataSource {

    @GET("sites/MCO/search")
    suspend fun find(
        @Query("q") filterText: String,
        @Query("offset") offset: Int? = null,
        @Query("limit") limit: Int? = null
    ): ProductSearchResponse

    @GET("items/{productId}")
    suspend fun findDetail(@Path("productId") productId: String): ProductDetailResponse

    @GET("items/{productId}/description")
    suspend fun findDescription(@Path("productId") productId: String): ProductDescriptionResponse

}