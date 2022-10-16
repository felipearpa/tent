package com.felipearpa.tent.product.view.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.felipearpa.tent.R

private const val DEFAULT_SPACING = 8
private const val NO_SPACING = 0

@Composable
private fun AppTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.product_view_title)) },
        elevation = NO_SPACING.dp
    )
}

@Composable
fun ProductView(viewModel: ProductViewModel) {
    val lazyItems = viewModel.productsFlow.collectAsLazyPagingItems()

    Scaffold(
        topBar = { AppTopBar() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(DEFAULT_SPACING.dp),
            verticalArrangement = Arrangement.spacedBy(DEFAULT_SPACING.dp)
        ) {
            Filter(filterText = viewModel.filterText, onFilterClick = viewModel::goUp)

            ProductList(
                lazyProducts = lazyItems,
                onItemClick = viewModel::showProduct,
                fakeItemCount = viewModel.pageSize,
                currencyFormatter = viewModel.currencyFormatter
            )
        }
    }
}

@Composable
private fun Filter(filterText: String, onFilterClick: () -> Unit) {
    Text(text = buildAnnotatedString {
        append("${stringResource(id = R.string.filtered_by)} ")

        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append(filterText)
        }
    },
        modifier = Modifier.clickable { onFilterClick() }
    )
}

@Preview(showBackground = true)
@Composable
private fun AppTopBarPreview() {
    AppTopBar()
}

@Preview(showBackground = true)
@Composable
private fun FilterPreview() {
    Filter(filterText = "motorola", onFilterClick = {})
}