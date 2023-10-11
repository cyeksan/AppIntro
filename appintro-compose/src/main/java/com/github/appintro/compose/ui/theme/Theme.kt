package com.github.appintro.compose.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

val AppIntroDefaultText = TextStyle(
    color = AppIntroDescColor,
    fontSize = 16.sp,
    letterSpacing = 0.sp,
    lineHeight = 1.em,
    textAlign = TextAlign.Center,
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Normal,
)

val AppIntroDefaultHeading = TextStyle(
    color = AppIntroTitleColor,
    fontSize = 28.sp,
    letterSpacing = 0.sp,
    lineHeight = 0.5.em,
    textAlign = TextAlign.Center,
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Bold,
)
