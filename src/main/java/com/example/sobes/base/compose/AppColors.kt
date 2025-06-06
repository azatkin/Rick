package com.example.sobes.base.compose

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

private interface AppColorsContract {
    val primary: Color
    val secondary: Color
    val tertiary: Color
    val textPrimary: Color
    val green: Color
    val red: Color
    val grayText: Color
    val white: Color
    val black: Color
    val lightRed: Color
    val grayDashed: Color
    val tooltipBorder: Color
    val gray: Color
    val lightGray: Color
    val deepGray: Color
    val ultraLightGray: Color
    val paleLavender: Color
    val brightGreen: Color


}

@Suppress("MagicNumber")
object AppColor {

    object Light : AppColorsContract {
        override val primary = Color(0xFF35363A)
        override val secondary = Color(0xFF625b71)
        override val tertiary = Color(0xFF7D5260)
        override val textPrimary: Color = Color(0xFF000000)
        override val green: Color = Color(0xFF4CD964)
        override val red: Color = Color(0xFFFF3B30)
        override val grayText: Color = Color(0xFF909090)
        override val white: Color = Color(0xFFFFFFFF)
        override val black: Color = Color(0xFF000000)
        override val lightRed: Color = Color(0xFFFDA182)
        override val grayDashed: Color = Color(0xFFBDBDBD)
        override val tooltipBorder: Color = Color(0xFFD6D6D6)
        override val gray: Color = Color(0xFF888888)
        override val lightGray: Color = Color(0xFFF0F0F0)
        override val deepGray: Color = Color(0xFF181818)
        override val ultraLightGray: Color = Color(0xFFF6F6F6)
        override val paleLavender: Color = Color(0xFFE7E6EA)
        override val brightGreen: Color = Color(0xFF17DE49)
    }

    // Просто показать, как работать, без реализации
//    object Dark : AppColorsContract {
//        override val primary = Color(0xFF0E0F11)
//        override val secondary = Color(0xFF191B1F)
//    }
}

//fun darkAppColors() = AppColors(
//    primary = AppColor.Dark.primary,
//    secondary = AppColor.Dark.secondary,
//    tertiary = AppColor.Dark.tertiary,
//    textPrimary = AppColor.Dark.textPrimary
//)

fun lightAppColors() = AppColors(
    primary = AppColor.Light.primary,
    secondary = AppColor.Light.secondary,
    tertiary = AppColor.Light.tertiary,
    textPrimary = AppColor.Light.textPrimary,
    green = AppColor.Light.green,
    red = AppColor.Light.red,
    grayText = AppColor.Light.grayText,
    white = AppColor.Light.white,
    black = AppColor.Light.black,
    lightRed = AppColor.Light.lightRed,
    grayDashed = AppColor.Light.grayDashed,
    tooltipBorder = AppColor.Light.tooltipBorder,
    gray = AppColor.Light.gray,
    lightGray = AppColor.Light.lightGray,
    deepGray = AppColor.Light.deepGray,
    ultraLightGray = AppColor.Light.ultraLightGray,
    paleLavender = AppColor.Light.paleLavender,
    brightGreen = AppColor.Light.brightGreen
)

@Stable
data class AppColors(
    override val primary: Color,
    override val secondary: Color,
    override val tertiary: Color,
    override val textPrimary: Color,
    override val green: Color,
    override val red: Color,
    override val grayText: Color,
    override val white: Color,
    override val black: Color,
    override val lightRed: Color,
    override val grayDashed: Color,
    override val tooltipBorder: Color,
    override val gray: Color,
    override val lightGray: Color,
    override val deepGray: Color,
    override val ultraLightGray: Color,
    override val paleLavender: Color,
    override val brightGreen: Color
) : AppColorsContract
