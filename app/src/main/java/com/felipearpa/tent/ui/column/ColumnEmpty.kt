package com.felipearpa.tent.ui.column

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felipearpa.core.emptyString
import com.felipearpa.tent.R

private const val DEFAULT_SPACING = 8
private const val DEFAULT_ICON_WIDTH = 24
private const val DEFAULT_ICON_HEIGHT = 24

@Composable
fun ColumnEmpty(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            (DEFAULT_SPACING / 2).dp,
            Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_sentiment_neutral_24),
            contentDescription = emptyString(),
            modifier = Modifier.size(DEFAULT_ICON_WIDTH.dp, DEFAULT_ICON_HEIGHT.dp)
        )

        Text(text = stringResource(id = R.string.empty_list))
    }
}

@Preview(showBackground = true)
@Composable
private fun ColumnEmptyPreview() {
    ColumnEmpty()
}

