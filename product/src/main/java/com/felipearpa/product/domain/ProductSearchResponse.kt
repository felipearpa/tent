package com.felipearpa.product.domain

data class ProductSearchResponse(val paging: PagingResponse, val results: List<ProductResponse>)