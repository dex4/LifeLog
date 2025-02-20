package io.wisentdev.lifelog.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

val LocalColorScheme = staticCompositionLocalOf { LifeLogColorScheme() }

val LocalTypography = staticCompositionLocalOf { Typography() }

val LocalShapes = staticCompositionLocalOf { LifeLogShapes() }

val LocalDimensions = staticCompositionLocalOf { LifeLogDimensions() }

val LocalExtendedColors: ProvidableCompositionLocal<ExtendedColorScheme> = staticCompositionLocalOf { extendedLight }

val AppShapes = LifeLogShapes()

val AppDimensions = LifeLogDimensions()

object LifeLogTheme {
    /**
     * Retrieves the current [ColorScheme] at the call site's position in the hierarchy.
     */
    val colorScheme: LifeLogColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current

    /**
     * Retrieves the current [ColorScheme] at the call site's position in the hierarchy.
     */
    val extendedColors: ExtendedColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalExtendedColors.current

    /**
     * Retrieves the current [Typography] at the call site's position in the hierarchy.
     */
    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    /**
     * Retrieves the current [LifeLogShapes] at the call site's position in the hierarchy.
     */
    val shapes: LifeLogShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

    /**
     * Retrieves the current [LifeLogShapes] at the call site's position in the hierarchy.
     */
    val dimensions: LifeLogDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current
}