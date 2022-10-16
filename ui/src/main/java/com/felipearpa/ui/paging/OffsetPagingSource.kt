package com.felipearpa.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.felipearpa.core.paging.OffsetPagingQuery

open class OffsetPagingSource<TModel : Any>(
    private val pagingQuery: OffsetPagingQuery<TModel>,
    private val limit: Int
) :
    PagingSource<Int, TModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TModel> {
        return try {
            val offset = params.key ?: 0
            val page = pagingQuery.execute(offset, limit)
            LoadResult.Page(
                data = page.items,
                prevKey = page.previous(),
                nextKey = page.next()
            )
        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TModel>): Int? = null
}