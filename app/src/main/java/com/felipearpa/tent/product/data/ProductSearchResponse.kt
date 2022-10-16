package com.felipearpa.tent.product.data

data class ProductSearchResponse(val paging: PagingResponse, val results: List<ProductResponse>)