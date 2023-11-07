package com.felipearpa.product.list.ui

import com.felipearpa.core.paging.OffsetPagingQuery
import com.felipearpa.ui.paging.OffsetPagingSource

class ProductPagingSource(query: OffsetPagingQuery<ProductModel>, limit: Int) :
    OffsetPagingSource<ProductModel>(pagingQuery = query, limit = limit)