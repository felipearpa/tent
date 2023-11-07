package com.felipearpa.core.paging

import com.felipearpa.core.MapFunc

data class OffsetPage<Model : Any>(
    val items: List<Model>,
    val offset: Int,
    val limit: Int,
    val total: Int
) {
    fun <Out : Any> map(mapFunc: MapFunc<Model, Out>): OffsetPage<Out> {
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

fun <Model : Any> emptyOffsetPage() = OffsetPage<Model>(
    items = emptyList(),
    offset = 0,
    limit = 0,
    total = 0
)