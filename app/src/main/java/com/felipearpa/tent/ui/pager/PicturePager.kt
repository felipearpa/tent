package com.felipearpa.tent.ui.pager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.felipearpa.core.emptyString
import com.felipearpa.tent.ui.theme.primaryLighter

data class Picture(
    val url: String,
    val width: Int,
    val height: Int
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PicturePager(pictures: List<Picture>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()

    HorizontalPager(count = pictures.size, state = pagerState, modifier = modifier) { page ->
        val picture = pictures[page]

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(size = 2.dp))
                .background(color = MaterialTheme.colors.primaryLighter)
                .padding(all = 8.dp)
        ) {
            Text(text = "${page + 1} / ${pictures.size}")
        }

        AsyncImage(
            model = picture.url,
            contentDescription = emptyString(),
            modifier = modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PicturePagerPreview() {
    PicturePager(
        pictures = listOf(
            Picture(
                url = "https://http2.mlstatic.com/D_855228-MLA44190758269_112020-O.jpg",
                width = 249,
                height = 500
            )
        )
    )
}