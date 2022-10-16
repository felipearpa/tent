package com.felipearpa.tent.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Colors.primaryDarker: Color
    get() = if (isLight) Color.Black.copy(alpha = 0.87f) else Color.Black.copy(alpha = 0.87f)

val Colors.primaryDark: Color
    get() = if (isLight) Color.Black.copy(alpha = 0.62f) else Color.Black.copy(alpha = 0.62f)

val Colors.primaryLight: Color
    get() = if (isLight) Color.Black.copy(alpha = 0.37f) else Color.Black.copy(alpha = 0.43f)

val Colors.primaryLighter: Color
    get() = if (isLight) Color.Black.copy(alpha = 0.12f) else Color.Black.copy(alpha = 0.21f)

val Colors.success: Color
    get() = if (isLight) Color(0xFF4BB543) else Color(0xFF4BB543)

val Colors.importantText: Color
    get() = if (isLight) Color(0xFF000080) else Color(0xFF000080)