package com.felipearpa.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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

@Composable
fun Message(
    @DrawableRes iconResourceId: Int,
    @StringRes messageResourceId: Int,
    modifier: Modifier = Modifier
) {
    Message(
        iconResourceId = iconResourceId,
        message = stringResource(id = messageResourceId),
        modifier = modifier
    )
}

@Composable
fun Message(@DrawableRes iconResourceId: Int, message: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconResourceId),
            contentDescription = emptyString(),
            modifier = Modifier.size(40.dp, 40.dp)
        )

        Text(text = message)
    }
}

@Preview(showBackground = true)
@Composable
fun MessagePreview() {
    Message(
        iconResourceId = R.drawable.sentiment_sad,
        messageResourceId = R.string.unknown_failure_message
    )
}