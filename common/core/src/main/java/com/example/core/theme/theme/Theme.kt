package com.example.core.theme.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
primary = RoyalBlue65,
    secondary = RoyalBlue65,
    tertiary = Color.White,
    background = DarkGrey11,
    inversePrimary = Color.White,
    secondaryContainer = DarkSlateBlue14,
    outline = DarkSlateBlue23,
    onPrimary = RoyalBlue65,
    onSecondary = Grey88,
    onSecondaryContainer = BlueGray23,
    onTertiaryContainer = Color.White,
    onSurface = BlueGrey15,
    surfaceVariant = BlueGrey15,
    inverseSurface = Grey46
)

private val LightColorScheme = lightColorScheme(
    primary = RoyalBlue65,
    secondary = RoyalBlue65,
    tertiary = RoyalBlue65,
    background = Color.White,
    inversePrimary = DarkGrey13,
    secondaryContainer = OffWhite98,
    outline = LightGrey94,
    onPrimary = RoyalBlue65,
    onSecondary = Grey26,
    onSecondaryContainer = Lavender96,
    onTertiaryContainer = Color.Black,
    onSurface = Grey96,
    surfaceVariant = Color.White,
    inverseSurface = Grey75
)

@Composable
fun RedditNewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}