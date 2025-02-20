package io.wisentdev.lifelog.feature.moneylog.dashboard.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import java.util.*

data class MoneyLogCategory(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    @DrawableRes val iconRes: Int,
    val tint: Color = Color(0xFFE57373),
    val totalValue: Float,
    val isExpense: Boolean
)