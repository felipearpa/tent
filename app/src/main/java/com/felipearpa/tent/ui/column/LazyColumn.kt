package com.felipearpa.tent.ui.column

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.felipearpa.ui.column.RefreshableLazyColumn

private const val DEFAULT_SPACING = 8
private const val NO_SPACING = 0

@Composable
fun <TModel : Any> RefreshableLazyColumn(
    lazyItems: LazyPagingItems<TModel>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(NO_SPACING.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.Bottom,
    filterContent: @Composable (() -> Unit)? = null,
    onLoadingContent: (LazyListScope.() -> Unit)? = null,
    itemContent: LazyListScope.() -> Unit
) {
    RefreshableLazyColumn(
        modifier = modifier,
        lazyItems = lazyItems,
        contentPadding = contentPadding,
        verticalArrangement = verticalArrangement,
        filterContent = filterContent,
        onLoadingContent = onLoadingContent,
        onLoadingAppendContent = {
            ColumnProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(DEFAULT_SPACING.dp)
            )
        },
        onErrorAppendContent = {
            ColumnRetry(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = DEFAULT_SPACING.dp)
            ) { lazyItems.retry() }
        },
        onErrorContent = { exception ->
            println(exception)
            ColumnError(modifier = Modifier.fillMaxWidth()) {
                lazyItems.retry()
            }
        },
        onEmptyContent = {
            ColumnEmpty(modifier = Modifier.fillMaxWidth())
        }
    ) {
        itemContent()
    }
}