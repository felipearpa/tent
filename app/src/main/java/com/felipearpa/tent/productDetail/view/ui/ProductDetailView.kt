package com.felipearpa.tent.productDetail.view.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.felipearpa.core.ifNonNull
import com.felipearpa.core.ifNull
import com.felipearpa.tent.R

private const val NO_SPACING = 0

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppTopBar(onBackClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.product_detail_view_title)) },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                    contentDescription = stringResource(id = R.string.back_action)
                )
            }
        }
    )
}

@Composable
fun ProductDetailView(viewModel: ProductDetailViewModel) {
    val productDetail by viewModel.productDetailFlow.collectAsState(initial = null)

    Scaffold(
        topBar = { AppTopBar(viewModel::goUp) }
    ) { paddingValues ->
        productDetail.ifNonNull { nonNullProductDetail ->
            ProductDetail(
                productDetail = nonNullProductDetail,
                currencyFormatter = viewModel.currencyFormatter,
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
            )
        }.ifNull {
            FakeProductDetail()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppTopBarPreview() {
    AppTopBar(onBackClick = {})
}