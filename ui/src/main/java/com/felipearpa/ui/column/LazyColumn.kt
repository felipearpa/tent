package com.felipearpa.ui.column

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.felipearpa.ui.gesturesDisabled

@Composable
fun <TModel : Any> LazyColumn(
    modifier: Modifier = Modifier,
    lazyItems: LazyPagingItems<TModel>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.Bottom,
    filterContent: @Composable (() -> Unit)? = null,
    onLoadingContent: (LazyListScope.() -> Unit)? = null,
    onLoadingAppendContent: @Composable () -> Unit,
    onErrorAppendContent: @Composable () -> Unit,
    onErrorContent: @Composable (Throwable) -> Unit,
    onEmptyContent: @Composable () -> Unit,
    itemContent: LazyListScope.() -> Unit
) {
    LazyColumn(
        modifier = modifier.gesturesDisabled(lazyItems.loadState.refresh is LoadState.Loading),
        contentPadding = contentPadding,
        verticalArrangement = verticalArrangement
    ) {
        filterContent?.let { filterContent ->
            item { filterContent() }
        }

        val defaultContent = {
            itemContent.invoke(this)

            if (lazyItems.itemCount == 0
                && lazyItems.loadState.prepend.endOfPaginationReached
                && lazyItems.loadState.append.endOfPaginationReached
            ) {
                item {
                    onEmptyContent()
                }
            }
        }

        if (lazyItems.loadState.refresh !is LoadState.Loading) {
            defaultContent()
        }

        when {
            lazyItems.loadState.refresh is LoadState.Loading -> {
                onLoadingContent?.invoke(this)
            }

            lazyItems.loadState.refresh is LoadState.Error -> {
                val exception = lazyItems.loadState.refresh as LoadState.Error
                item {
                    onErrorContent(exception.error)
                }
            }

            lazyItems.loadState.append is LoadState.Loading -> {
                item {
                    onLoadingAppendContent()
                }
            }

            lazyItems.loadState.append is LoadState.Error -> {
                item {
                    onErrorAppendContent()
                }
            }
        }
    }
}