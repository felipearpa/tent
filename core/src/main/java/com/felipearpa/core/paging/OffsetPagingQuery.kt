package com.felipearpa.core.paging

interface OffsetPagingQuery<TModel : Any> {

    suspend fun execute(offset: Int? = null, limit: Int): OffsetPage<TModel>

}