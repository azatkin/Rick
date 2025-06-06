package com.example.sobes.base.compose

import android.app.Activity
import android.os.Build
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.sobes.base.compose.AppColor.Light.ultraLightGray

@Composable
fun AppTheme(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        //darkTheme -> AppDarkScheme
        else -> AppLightScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = ultraLightGray.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    val appColors = if (darkTheme) {
        //darkAppColors()
        // без ее реализации, просто показал подход
        lightAppColors()
    } else {
        lightAppColors()
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = MaterialTheme.typography,
    ) {
        CompositionLocalProvider(
            LocalAppColors provides appColors,
            LocalContentColor provides appColors.textPrimary,
            LocalTextStyle provides LocalTextStyle.current.merge(color = appColors.textPrimary),
            content = content,
        )
    }
}

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current
}

val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("No colors defined")
}
