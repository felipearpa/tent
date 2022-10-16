package com.felipearpa.core.paging

import com.felipearpa.core.MapFunc

data class OffsetPage<TModel : Any>(
    val items: List<TModel>,
    val offset: Int,
    val limit: Int,
    val total: Int
) {

    fun <TOut : Any> map(mapFunc: MapFunc<TModel, TOut>): OffsetPage<TOut> {
        return OffsetPage(
            items = this.items.map(mapFunc),
            offset = 0,
            limit = this.items.size,
            total = this.items.size
        )
    }

    fun previous(): Int? = if (offset - limit <= 0) null else offset - limit

    fun next(): Int? = if (offset + limit < total) offset + limit else null

}

fun <T : Any> emptyOffsetPage() = OffsetPage<T>(
    items = emptyList(),
    offset = 0,
    limit = 0,
    total = 0
)