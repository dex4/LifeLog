package io.wisentdev.lifelog.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
data class LifeLogShapes(
    val extraSmall: Shape = ShapeDefaults.ExtraSmall,
    val small: Shape = ShapeDefaults.Small,
    val medium: Shape = ShapeDefaults.Medium,
    val large: Shape = ShapeDefaults.Large,
    val extraLarge: Shape = ShapeDefaults.ExtraLarge,
    val circle: Shape = CircleShape,
    val pill: Shape = RoundedCornerShape(50),
    val bottomSheet: Shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
)