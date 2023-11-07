package com.felipearpa.core.paging

interface OffsetPagingQuery<Model : Any> {
    suspend fun execute(offset: Int? = null, limit: Int): Result<OffsetPage<Model>>
}