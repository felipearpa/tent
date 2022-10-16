package com.felipearpa.tent.productDetail.view.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felipearpa.tent.R

private const val DEFAULT_SPACING = 8
private const val DESCRIPTION_TITLE_FONT_SIZE = 20
private const val BULLET_STRING = "\u2022"
private const val TAB_STRING = "\t"

@OptIn(ExperimentalTextApi::class)
@Composable
fun ProductDetailDescription(
    description: String,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.description_title),
            fontSize = DESCRIPTION_TITLE_FONT_SIZE.sp,
            modifier = childModifier
        )

        Spacer(modifier = Modifier.height((DEFAULT_SPACING / 2).dp))

        Text(
            text = buildAnnotatedString {
                description.split("\n").forEach { paragraph ->
                    if (paragraph.isNotBlank()) {
                        withStyle(style = ParagraphStyle(lineBreak = LineBreak.Paragraph)) {
                            append("$BULLET_STRING$TAB_STRING$TAB_STRING")
                            append(paragraph)
                        }
                    }
                }
            },
            modifier = childModifier
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailDescriptionPreview() {
    ProductDetailDescription(
        description = "Momentos únicos, capturas reales\n\nCaptura tus mejores momentos y revívelos cuando quieras con la cámara trasera de 13 Mpx.\n\nAdemás, con la cámara frontal con flash prepárate para compartir selfies más iluminadas en tus redes sociales.\n\nMás para ver\nCon su pantalla IPS de 5.7\", disfruta de colores intensos y mayor nitidez en todos tus contenidos.\n\nTodo lo que necesitas\nSu memoria RAM de 2 GB es justo lo que necesitas para utilizar las funciones más importantes como llamar, enviar mensajes, navegar y ejecutar aplicaciones de uso frecuente como redes sociales o multimedia.\n\nDesbloqueo facial y dactilar\nMáxima seguridad para que solo tú puedas acceder al equipo. Podrás elegir entre el sensor de huella dactilar para habilitar el teléfono en un toque, o el reconocimiento facial que permite un desbloqueo hasta un 30% más rápido.\n\nBatería de duración superior\n¡Desenchúfate! Con la súper batería de 4000 mAh tendrás energía por mucho más tiempo para jugar, ver series o trabajar sin necesidad de realizar recargas.\n\nLleva lo esencial\nSi buscas un dispositivo que te permita almacenar fotos, videos y archivos indispensables, este celular con 16 GB de memoria interna es para ti.",
        modifier = Modifier.fillMaxWidth()
    )
}