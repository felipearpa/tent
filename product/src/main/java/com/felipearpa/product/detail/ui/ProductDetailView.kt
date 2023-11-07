package com.felipearpa.product.detail.ui

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felipearpa.product.R
import com.felipearpa.ui.ErrorMessage
import com.felipearpa.ui.isFailure
import com.felipearpa.ui.isInitial
import com.felipearpa.ui.isSuccess
import com.felipearpa.ui.valueOrNull
import com.felipearpa.ui.R as SharedR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppTopBar(onBackClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.product_detail_view_title)) },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    painter = painterResource(id = SharedR.drawable.arrow_back),
                    contentDescription = stringResource(id = R.string.back_action)
                )
            }
        }
    )
}

@Composable
fun ProductDetailView(viewModel: ProductDetailViewModel, onBack: () -> Unit) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        if (state.isInitial()) {
            viewModel.load()
        }
    }

    Scaffold(
        topBar = { AppTopBar(onBackClick = onBack) }
    ) { paddingValues ->
        if (state.isSuccess()) {
            val productDetail = state.valueOrNull()!!
            ProductDetail(
                productDetail = productDetail,
                currencyFormatter = viewModel.currencyFormatter,
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
            )
        } else if (state.isFailure()) {
            ErrorMessage(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(all = 8.dp)
                    .fillMaxWidth()
            )
        } else {
            FakeProductDetail(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppTopBarPreview() {
    AppTopBar(onBackClick = {})
}