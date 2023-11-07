package com.felipearpa.product.list.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.felipearpa.core.formatter.ColombianCurrencyFormatter
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun ProductFakeItem(modifier: Modifier = Modifier) {
    ProductItem(
        product = fakeProductDummy(),
        onItemClick = {},
        modifier = modifier.fillMaxWidth(),
        currencyFormatter = ColombianCurrencyFormatter(),
        childModifier = Modifier.placeholder(
            visible = true, highlight = PlaceholderHighlight.shimmer()
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductFakeItemPreview() {
    Surface {
        ProductFakeItem(modifier = Modifier.fillMaxWidth())
    }
}