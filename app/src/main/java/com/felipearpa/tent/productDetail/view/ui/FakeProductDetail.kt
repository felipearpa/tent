package com.felipearpa.tent.productDetail.view.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import com.felipearpa.tent.formatter.ColombianCurrencyFormatter
import com.felipearpa.tent.product.domain.ProductCondition
import com.felipearpa.tent.productDetail.view.ProductAttributeModel
import com.felipearpa.tent.productDetail.view.ProductDetailModel
import com.felipearpa.tent.productDetail.view.ProductPictureModel
import com.felipearpa.tent.productDetail.view.ProductShippingModel

@Composable
fun FakeProductDetail() {
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
        modifier = Modifier.fillMaxWidth(),
        childModifier = Modifier.placeholder(
            visible = true, highlight = PlaceholderHighlight.shimmer()
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun FakeProductDetailPreview() {
    FakeProductDetail()
}