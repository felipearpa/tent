package com.felipearpa.product.list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.felipearpa.product.R

private const val DEFAULT_SPACING = 8

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppTopBar() {
    TopAppBar(title = { Text(text = stringResource(id = R.string.product_view_title)) })
}

@Composable
fun ProductListView(
    viewModel: ProductListViewModel,
    onDetailRequested: (String) -> Unit,
    onBack: () -> Unit
) {
    val lazyItems = viewModel.productsFlow.collectAsLazyPagingItems()

    Scaffold(
        topBar = { AppTopBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(DEFAULT_SPACING.dp)
        ) {
            Filter(filterText = viewModel.filterText, onBackClick = onBack)

            ProductList(
                lazyProducts = lazyItems,
                onItemClick = { product -> onDetailRequested(product.id) },
                fakeItemCount = viewModel.pageSize,
                currencyFormatter = viewModel.currencyFormatter
            )
        }
    }
}

@Composable
private fun Filter(filterText: String, onBackClick: () -> Unit) {
    Text(text = buildAnnotatedString {
        append("${stringResource(id = R.string.filtered_by)} ")

        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append(filterText)
        }
    },
        modifier = Modifier.clickable { onBackClick() }
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
    Surface {
        Filter(filterText = "motorola", onBackClick = {})
    }
}