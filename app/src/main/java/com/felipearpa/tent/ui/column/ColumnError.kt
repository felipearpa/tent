package com.felipearpa.tent.ui.column

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felipearpa.core.emptyString
import com.felipearpa.tent.R

private const val DEFAULT_SPACING = 8
private const val DEFAULT_ICON_WIDTH = 48
private const val DEFAULT_ICON_HEIGHT = 48

@Composable
fun ColumnError(modifier: Modifier = Modifier, onRetry: () -> Unit) {
    Box(modifier = modifier, contentAlignment = Alignment.TopCenter) {
        Column(
            verticalArrangement = Arrangement.spacedBy(DEFAULT_SPACING.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_sentiment_very_dissatisfied_24),
                    contentDescription = emptyString(),
                    modifier = Modifier.size(DEFAULT_ICON_WIDTH.dp, DEFAULT_ICON_HEIGHT.dp)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(DEFAULT_SPACING.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.retry_text),
                        textAlign = TextAlign.Start,
                        softWrap = true
                    )

                    Box(
                        contentAlignment = Alignment.BottomEnd,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedButton(onClick = onRetry) {
                            Text(text = stringResource(R.string.retry_action))
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ColumnErrorPreview() {
    ColumnError {}
}