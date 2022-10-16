package com.felipearpa.tent.product.view.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.felipearpa.tent.formatter.CurrencyFormatter
import com.felipearpa.tent.product.view.ProductModel
import com.felipearpa.tent.ui.column.RefreshableLazyColumn

private const val DEFAULT_SPACING = 8

@Composable
fun ProductList(
    lazyProducts: LazyPagingItems<ProductModel>,
    fakeItemCount: Int? = null,
    currencyFormatter: CurrencyFormatter,
    onItemClick: (String) -> Unit
) {
    RefreshableLazyColumn(
        modifier = Modifier.fillMaxWidth(),
        lazyItems = lazyProducts,
        contentPadding = PaddingValues(all = DEFAULT_SPACING.dp),
        verticalArrangement = Arrangement.spacedBy(space = DEFAULT_SPACING.dp),
        filterContent = null,
        onLoadingContent = {
            fakeItemCount?.let { count ->
                for (i in 1..count) {
                    item {
                        FakeProductItem(modifier = Modifier.fillMaxWidth())
                        Divider(modifier = Modifier.padding(top = DEFAULT_SPACING.dp))
                    }
                }
            }
        }
    ) {
        items(lazyProducts) { product ->
            ProductItem(
                product = product!!,
                onItemClick = onItemClick,
                currencyFormatter = currencyFormatter,
                modifier = Modifier.fillMaxWidth()
            )
            Divider(modifier = Modifier.padding(top = DEFAULT_SPACING.dp))
        }
    }
}