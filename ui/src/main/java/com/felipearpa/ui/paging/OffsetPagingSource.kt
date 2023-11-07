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
        val offset = params.key ?: 0
        val result = pagingQuery.execute(offset, limit)
        return result.fold(
            onSuccess = { page ->
                LoadResult.Page(
                    data = page.items,
                    prevKey = page.previous(),
                    nextKey = page.next()
                )
            },
            onFailure = { exception ->
                LoadResult.Error(exception)
            }
        )
    }

    override fun getRefreshKey(state: PagingState<Int, TModel>): Int? = null
}