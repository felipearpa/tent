package com.felipearpa.tent.product.view.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.felipearpa.tent.R
import com.felipearpa.tent.formatter.ColombianCurrencyFormatter
import com.felipearpa.tent.formatter.CurrencyFormatter
import com.felipearpa.tent.product.view.InstallmentModel
import com.felipearpa.tent.product.view.ProductModel
import com.felipearpa.tent.product.view.ShippingModel
import com.felipearpa.tent.ui.theme.success
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

private const val DEFAULT_SPACING = 8
private const val PICTURE_WIDTH = 128
private const val PICTURE_HEIGHT = 128
private const val PRICE_FONT_SIZE = 20
private const val INSTALLMENT_FONT_SIZE = 12
private const val NO_DECIMALS = 0

@Composable
private fun ProductItem(
    product: ProductModel,
    currencyFormatter: CurrencyFormatter,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.clickable { onItemClick(product.id) },
        horizontalArrangement = Arrangement.spacedBy(DEFAULT_SPACING.dp)
    ) {
        AsyncImage(
            model = product.thumbnail,
            contentDescription = "",
            modifier = childModifier.size(width = PICTURE_WIDTH.dp, height = PICTURE_HEIGHT.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy((DEFAULT_SPACING / 2).dp)
        ) {
            Text(text = product.title, modifier = childModifier)

            Text(
                text = currencyFormatter.format(product.price, NO_DECIMALS),
                modifier = childModifier,
                fontSize = PRICE_FONT_SIZE.sp
            )

            Text(
                text = stringResource(
                    id = R.string.installment_in_query,
                    product.installment.quantity,
                    currencyFormatter.format(product.installment.amount, NO_DECIMALS)
                ),
                modifier = childModifier,
                fontSize = INSTALLMENT_FONT_SIZE.sp
            )

            if (product.shipping.isFreeShipping) {
                Text(
                    text = stringResource(id = R.string.free_shipping),
                    modifier = childModifier,
                    color = MaterialTheme.colors.success
                )
            }
        }
    }
}

@Composable
fun ProductItem(
    product: ProductModel,
    currencyFormatter: CurrencyFormatter,
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit
) {
    ProductItem(
        product = product,
        onItemClick = onItemClick,
        modifier = modifier,
        currencyFormatter = currencyFormatter,
        childModifier = Modifier
    )
}

@Composable
fun FakeProductItem(modifier: Modifier = Modifier) {
    ProductItem(
        product = ProductModel(
            id = "MCO959602836",
            title = "Celular Motorola G6 16gb",
            price = 250000,
            salePrice = null,
            condition = "used",
            thumbnail = "http://http2.mlstatic.com/D_948488-MCO51510901802_092022-O.jpg",
            installment = InstallmentModel(
                quantity = 36, amount = 6944.44
            ),
            shipping = ShippingModel(
                isFreeShipping = true
            )
        ),
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
private fun ProductItemPreview() {
    ProductItem(
        product = ProductModel(
            id = "MCO959602836",
            title = "Celular Motorola G6 16gb",
            price = 250000,
            salePrice = null,
            condition = "used",
            thumbnail = "http://http2.mlstatic.com/D_948488-MCO51510901802_092022-O.jpg",
            installment = InstallmentModel(
                quantity = 36, amount = 6944.44
            ),
            shipping = ShippingModel(
                isFreeShipping = true
            )
        ),
        currencyFormatter = ColombianCurrencyFormatter(),
        onItemClick = {},
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun FakeProductItemPreview() {
    FakeProductItem(modifier = Modifier.fillMaxWidth())
}