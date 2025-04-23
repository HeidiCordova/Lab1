
package com.example.lab1.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Colores personalizados basados en tu diseño XML
val Yellow200 = Color(0xFFE9C46A)
val Yellow500 = Color(0xFFFFF9C4)
val Yellow700 = Color(0xFF9D7705)
val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)
val Grey = Color(0xFF78878C)

private val DarkColorScheme = darkColorScheme(
    primary = Yellow700,
    primaryContainer = Yellow200,  // primaryVariant cambia a primaryContainer
    secondary = Black,
    background = Grey,
    surface = Color.DarkGray
)

private val LightColorScheme = lightColorScheme(
    primary = Yellow700,
    primaryContainer = Yellow200,  // primaryVariant cambia a primaryContainer
    secondary = Black,
    background = Yellow500,
    surface = White
)

@Composable
fun MyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}