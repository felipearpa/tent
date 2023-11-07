package com.felipearpa.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.felipearpa.core.emptyString
import com.felipearpa.ui.theme.primaryLighter

data class Picture(
    val url: String,
    val width: Int,
    val height: Int
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PicturePager(pictures: List<Picture>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        pictures.size
    }

    HorizontalPager(state = pagerState, modifier = modifier) { page ->
        val picture = pictures[page]

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(size = 2.dp))
                .background(color = MaterialTheme.colorScheme.primaryLighter)
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