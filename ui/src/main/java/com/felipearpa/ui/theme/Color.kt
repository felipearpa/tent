package com.felipearpa.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val ColorScheme.primaryDarker: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black.copy(alpha = 0.87f) else Color.Black.copy(alpha = 0.87f)

val ColorScheme.primaryDark: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black.copy(alpha = 0.62f) else Color.Black.copy(alpha = 0.62f)

val ColorScheme.primaryLight: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black.copy(alpha = 0.37f) else Color.Black.copy(alpha = 0.43f)

val ColorScheme.primaryLighter: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black.copy(alpha = 0.12f) else Color.Black.copy(alpha = 0.21f)

val ColorScheme.success: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF4BB543) else Color(0xFF4BB543)

val ColorScheme.importantText: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF000080) else Color(0xFF000080)