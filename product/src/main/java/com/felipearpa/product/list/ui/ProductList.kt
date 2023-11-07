package com.felipearpa.product.list.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.felipearpa.core.formatter.CurrencyFormatter
import com.felipearpa.ui.lazy.RefreshableLazyColumn

private const val DEFAULT_SPACING = 8

@Composable
fun ProductList(
    lazyProducts: LazyPagingItems<ProductModel>,
    fakeItemCount: Int? = null,
    currencyFormatter: CurrencyFormatter,
    onItemClick: (ProductModel) -> Unit
) {
    RefreshableLazyColumn(
        modifier = Modifier.fillMaxWidth(),
        lazyItems = lazyProducts,
        loadingContent = {
            fakeItemCount?.let { count ->
                for (i in 1..count) {
                    item {
                        ProductFakeItem(modifier = Modifier.fillMaxWidth())
                        Divider(modifier = Modifier.padding(top = DEFAULT_SPACING.dp))
                    }
                }
            }
        }
    ) {
        items(
            count = lazyProducts.itemCount,
            key = lazyProducts.itemKey { product -> product.id },
            contentType = lazyProducts.itemContentType { "Product" }
        ) { index ->
            val product = lazyProducts[index]
            ProductItem(
                product = product!!,
                onItemClick = { onItemClick(product) },
                currencyFormatter = currencyFormatter,
                modifier = Modifier.fillMaxWidth()
            )
            Divider(modifier = Modifier.padding(top = DEFAULT_SPACING.dp))
        }
    }
}