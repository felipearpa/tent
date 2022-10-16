package com.felipearpa.ui.column

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun <TModel : Any> RefreshableLazyColumn(
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
    val swipeRefreshState = rememberSwipeRefreshState(false)
    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = {
            swipeRefreshState.isRefreshing = false
            lazyItems.refresh()
        }
    ) {
        LazyColumn(
            modifier = modifier,
            lazyItems = lazyItems,
            filterContent = filterContent,
            contentPadding = contentPadding,
            verticalArrangement = verticalArrangement,
            onLoadingContent = onLoadingContent,
            onLoadingAppendContent = onLoadingAppendContent,
            onErrorAppendContent = onErrorAppendContent,
            onErrorContent = onErrorContent,
            onEmptyContent = onEmptyContent,
            itemContent = itemContent
        )
    }
}