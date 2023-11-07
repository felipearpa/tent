package com.felipearpa.product.list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.felipearpa.core.formatter.ColombianCurrencyFormatter
import com.felipearpa.core.formatter.CurrencyFormatter
import com.felipearpa.product.R
import com.felipearpa.ui.theme.success

private const val DEFAULT_SPACING = 8
private const val PICTURE_WIDTH = 128
private const val PICTURE_HEIGHT = 128
private const val PRICE_FONT_SIZE = 20
private const val INSTALLMENT_FONT_SIZE = 12
private const val NO_DECIMALS = 0

@Composable
fun ProductItem(
    product: ProductModel,
    currencyFormatter: CurrencyFormatter,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.clickable { onItemClick() },
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
                    color = MaterialTheme.colorScheme.success
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
    onItemClick: () -> Unit
) {
    ProductItem(
        product = product,
        onItemClick = onItemClick,
        modifier = modifier,
        currencyFormatter = currencyFormatter,
        childModifier = Modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    Surface {
        ProductItem(
            product = productDummy(),
            currencyFormatter = ColombianCurrencyFormatter(),
            onItemClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}
