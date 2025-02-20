package io.wisentdev.lifelog.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

data class LifeLogColorScheme(
    val primary: Color = primaryLight,
    val onPrimary: Color = onPrimaryLight,
    val secondary: Color = secondaryLight,
    val onSecondary: Color = onSecondaryLight,
    val tertiary: Color = tertiaryLight,
    val onTertiary: Color = onTertiaryLight,
    val error: Color = errorLight,
    val onError: Color = onErrorLight,
    val background: Color = backgroundLight,
    val onBackground: Color = onBackgroundLight,
    val surface: Color = surfaceLight,
    val onSurface: Color = onSurfaceLight,
    val outline: Color = outlineLight,
    val outlineVariant: Color = outlineVariantLight,
    val scrim: Color = scrimLight,
)

private val lightScheme = LifeLogColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    error = errorLight,
    onError = onErrorLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
)

private val darkScheme = LifeLogColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    error = errorDark,
    onError = onErrorDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
)

val extendedLight = ExtendedColorScheme(
    cyan = ColorFamily(
        color = cyanLight,
        onColor = onCyanLight,
    ),
    lightPurple = ColorFamily(
        color = purpleLight,
        onColor = onPurpleLight,
    ),
    pink = ColorFamily(
        color = pinkLight,
        onColor = onPinkLight,
    ),
    gold = ColorFamily(
        color = goldLight,
        onColor = onGoldLight,
    ),
    purple = ColorFamily(
        color = purpleLight,
        onColor = onPurpleLight,
    ),
    black = ColorFamily(
        color = blackLight,
        onColor = onBlackLight,
    ),
    orange = ColorFamily(
        color = orangeLight,
        onColor = onOrangeLight,
    ),
    red = ColorFamily(
        color = redLight,
        onColor = onRedLight,
    ),
    blue = ColorFamily(
        color = blueLight,
        onColor = onBlueLight,
    ),
    green = ColorFamily(
        color = greenLight,
        onColor = onGreenLight,
    ),
)

val extendedDark = ExtendedColorScheme(
    cyan = ColorFamily(
        color = cyanDark,
        onColor = onCyanDark,
    ),
    lightPurple = ColorFamily(
        color = purpleDark,
        onColor = onPurpleDark,
    ),
    pink = ColorFamily(
        color = pinkDark,
        onColor = onPinkDark,
    ),
    gold = ColorFamily(
        color = goldDark,
        onColor = onGoldDark,
    ),
    purple = ColorFamily(
        color = purpleDark,
        onColor = onPurpleDark,
    ),
    black = ColorFamily(
        color = blackDark,
        onColor = onBlackDark,
    ),
    orange = ColorFamily(
        color = orangeDark,
        onColor = onOrangeDark,
    ),
    red = ColorFamily(
        color = redDark,
        onColor = onRedDark,
    ),
    blue = ColorFamily(
        color = blueDark,
        onColor = onBlueDark,
    ),
    green = ColorFamily(
        color = greenDark,
        onColor = onGreenDark,
    ),
)

@Composable
fun LifeLogTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorScheme provides if (darkTheme) darkScheme else lightScheme,
        LocalExtendedColors provides if (darkTheme) extendedDark else extendedLight,
        LocalTypography provides AppTypography,
        LocalShapes provides AppShapes,
        LocalDimensions provides AppDimensions,
    ) {
        ProvideTextStyle(value = AppTypography.bodyLarge, content = content)
    }
}