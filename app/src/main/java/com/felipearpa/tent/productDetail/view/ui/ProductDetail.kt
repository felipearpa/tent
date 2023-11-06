package com.felipearpa.tent.productDetail.view.ui

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
import com.felipearpa.tent.R
import com.felipearpa.tent.formatter.ColombianCurrencyFormatter
import com.felipearpa.tent.formatter.CurrencyFormatter
import com.felipearpa.tent.product.domain.ProductCondition
import com.felipearpa.tent.productDetail.view.ProductAttributeModel
import com.felipearpa.tent.productDetail.view.ProductDetailModel
import com.felipearpa.tent.productDetail.view.ProductPictureModel
import com.felipearpa.tent.productDetail.view.ProductShippingModel
import com.felipearpa.tent.ui.pager.Picture
import com.felipearpa.tent.ui.pager.PicturePager
import com.felipearpa.tent.ui.theme.importantText
import com.felipearpa.tent.ui.theme.primaryDarker
import com.felipearpa.tent.ui.theme.primaryLight
import com.felipearpa.tent.ui.theme.primaryLighter

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
            painter = painterResource(id = R.drawable.ic_baseline_security_24),
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
    ProtectedPurchase()
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailPreview() {
    ProductDetail(
        productDetail = ProductDetailModel(
            id = "MCO944675556",
            title = "Moto G6 Play 16 Gb Índigo Oscuro 2 Gb Ram",
            description = "Momentos únicos, capturas reales\n\nCaptura tus mejores momentos y revívelos cuando quieras con la cámara trasera de 13 Mpx.\n\nAdemás, con la cámara frontal con flash prepárate para compartir selfies más iluminadas en tus redes sociales.\n\nMás para ver\nCon su pantalla IPS de 5.7\", disfruta de colores intensos y mayor nitidez en todos tus contenidos.\n\nTodo lo que necesitas\nSu memoria RAM de 2 GB es justo lo que necesitas para utilizar las funciones más importantes como llamar, enviar mensajes, navegar y ejecutar aplicaciones de uso frecuente como redes sociales o multimedia.\n\nDesbloqueo facial y dactilar\nMáxima seguridad para que solo tú puedas acceder al equipo. Podrás elegir entre el sensor de huella dactilar para habilitar el teléfono en un toque, o el reconocimiento facial que permite un desbloqueo hasta un 30% más rápido.\n\nBatería de duración superior\n¡Desenchúfate! Con la súper batería de 4000 mAh tendrás energía por mucho más tiempo para jugar, ver series o trabajar sin necesidad de realizar recargas.\n\nLleva lo esencial\nSi buscas un dispositivo que te permita almacenar fotos, videos y archivos indispensables, este celular con 16 GB de memoria interna es para ti.",
            price = 599900,
            availableQuantity = 1,
            soldQuantity = 0,
            condition = ProductCondition.NEW,
            shipping = ProductShippingModel(isFreeShipping = true),
            pictures = listOf(
                ProductPictureModel(
                    id = "855228-MLA44190758269_112020",
                    url = "http://http2.mlstatic.com/D_855228-MLA44190758269_112020-O.jpg",
                    secureUrl = "https://http2.mlstatic.com/D_855228-MLA44190758269_112020-O.jpg",
                    width = 249,
                    height = 500
                ),
                ProductPictureModel(
                    id = "603377-MLA44190542668_112020",
                    url = "http://http2.mlstatic.com/D_603377-MLA44190542668_112020-O.jpg",
                    secureUrl = "https://http2.mlstatic.com/D_603377-MLA44190542668_112020-O.jpg",
                    width = 248,
                    height = 500
                ),
                ProductPictureModel(
                    id = "775194-MLA44190542669_112020",
                    url = "http://http2.mlstatic.com/D_775194-MLA44190542669_112020-O.jpg",
                    secureUrl = "https://http2.mlstatic.com/D_775194-MLA44190542669_112020-O.jpg",
                    width = 230,
                    height = 500
                )
            ),
            attributes = listOf(
                ProductAttributeModel(
                    id = "BATTERY_CAPACITY",
                    name = "Capacidad de la batería",
                    valueName = "4000 mAh"
                ),
                ProductAttributeModel(
                    id = "BATTERY_TYPE",
                    name = "Tipo de batería",
                    valueName = "Ion de litio"
                ),
                ProductAttributeModel(
                    id = "BRAND",
                    name = "Marca",
                    valueName = "Motorola"
                )
            ),
            isProtectedPurchase = true
        ),
        currencyFormatter = ColombianCurrencyFormatter(),
        modifier = Modifier.fillMaxWidth()
    )
}