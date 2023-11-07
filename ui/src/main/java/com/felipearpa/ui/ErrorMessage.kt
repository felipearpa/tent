package com.felipearpa.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ErrorMessage(modifier: Modifier = Modifier) {
    Message(
        iconResourceId = R.drawable.sentiment_sad,
        messageResourceId = R.string.unknown_failure_message,
        modifier = modifier
    )
}