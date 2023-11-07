package com.felipearpa.product.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipearpa.core.emptyString
import com.felipearpa.core.formatter.ColombianCurrencyFormatter
import com.felipearpa.core.formatter.CurrencyFormatter
import com.felipearpa.product.R
import com.felipearpa.product.domain.ProductCondition
import com.felipearpa.ui.Picture
import com.felipearpa.ui.PicturePager
import com.felipearpa.ui.theme.importantText
import com.felipearpa.ui.theme.primaryDarker
import com.felipearpa.ui.theme.primaryLight
import com.felipearpa.ui.theme.primaryLighter

private const val DEFAULT_SPACING = 8
private const val STATUS_FONT_SIZE = 12
private const val PRICE_FONT_SIZE = 20
private const val DEFAULT_BORDER_ROUNDING = 2
private const val DEFAULT_QUANTITY = 1
private const val NO_DECIMALS = 0

@Composable
fun ProductDetail(
    productDetail: ProductDetailModel,
    currencyFormatter: CurrencyFormatter,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy((DEFAULT_SPACING / 2).dp),
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(all = DEFAULT_SPACING.dp)
    ) {
        Text(
            text = "${
                when (productDetail.condition) {
                    ProductCondition.NEW -> stringResource(id = R.string.condition_new)
                    ProductCondition.USED -> stringResource(id = R.string.condition_used)
                }
            } | ${stringResource(id = R.string.sold_items, productDetail.soldQuantity)}",
            fontSize = STATUS_FONT_SIZE.sp,
            color = MaterialTheme.colorScheme.primaryLight,
            modifier = childModifier
        )

        Text(text = productDetail.title, modifier = childModifier.fillMaxWidth())

        PicturePager(
            productDetail.pictures.map { picture ->
                Picture(
                    url = picture.secureUrl,
                    width = picture.width,
                    height = picture.height
                )
            }, modifier = childModifier
                .fillMaxWidth()
                .height(280.dp)
        )

        Text(
            text = currencyFormatter.format(productDetail.price, NO_DECIMALS),
            fontSize = PRICE_FONT_SIZE.sp,
            modifier = childModifier
        )

        Spacer(modifier = Modifier.height((DEFAULT_SPACING / 2).dp))

        Text(
            text = stringResource(id = R.string.available_stock),
            fontWeight = FontWeight.Bold,
            modifier = childModifier
        )

        Stock(
            availableQuantity = productDetail.availableQuantity,
            modifier = Modifier.fillMaxWidth(),
            childModifier = childModifier
        )

        if (productDetail.isProtectedPurchase) {
            Spacer(modifier = Modifier.height((DEFAULT_SPACING / 2).dp))
            ProtectedPurchase(modifier = Modifier.fillMaxWidth(), childModifier = childModifier)
        }

        productDetail.description?.let { description ->
            Spacer(modifier = Modifier.height((DEFAULT_SPACING / 2).dp))
            Divider()
            ProductDetailDescription(
                description = description,
                modifier = Modifier.fillMaxWidth(),
                childModifier = childModifier
            )
        }
    }
}

@Composable
private fun Stock(
    availableQuantity: Int,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(DEFAULT_BORDER_ROUNDING.dp))
            .background(color = MaterialTheme.colorScheme.primaryLighter)
            .padding(all = DEFAULT_SPACING.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                append("${stringResource(id = R.string.quantity)} ")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(DEFAULT_QUANTITY.toString())
                }

                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primaryLight)) {
                    append(" (${stringResource(id = R.string.available)} $availableQuantity)")
                }
            },
            modifier = childModifier
        )
    }
}

@Composable
private fun ProtectedPurchase(modifier: Modifier = Modifier, childModifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(DEFAULT_SPACING.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.security),
            contentDescription = emptyString(),
            modifier = childModifier.size(24.dp, 24.dp)
        )

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.importantText)) {
                    append("${stringResource(id = R.string.protected_purchase)}.")
                }

                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primaryDarker)) {
                    append(" ${stringResource(id = R.string.protected_purchase_description)}.")
                }
            },
            modifier = childModifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProtectedPurchasePreview() {
    Surface {
        ProtectedPurchase()
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailPreview() {
    Surface {
        ProductDetail(
            productDetail = productDetailDummy(),
            currencyFormatter = ColombianCurrencyFormatter(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}