package com.felipearpa.product.detail.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.felipearpa.core.formatter.ColombianCurrencyFormatter
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun FakeProductDetail(modifier: Modifier = Modifier) {
    ProductDetail(
        productDetail = fakeProductDetailDummy(),
        currencyFormatter = ColombianCurrencyFormatter(),
        modifier = modifier,
        childModifier = Modifier.placeholder(
            visible = true, highlight = PlaceholderHighlight.shimmer()
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun FakeProductDetailPreview() {
    Surface {
        FakeProductDetail()
    }
}