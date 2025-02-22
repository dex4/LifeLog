package io.wisentdev.lifelog.feature.moneylog.dashboard.model

import androidx.annotation.ColorLong
import androidx.annotation.DrawableRes
import androidx.annotation.FloatRange
import io.wisentdev.lifelog.R
import java.util.*

data class MoneyLogCategoryDetails(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val value: Float,
    @FloatRange(0.0, 1.0)
    val valuePercentage: Float,
    @DrawableRes
    val iconRes: Int = R.drawable.ic_euro,
    @ColorLong
    val iconTint: Long = 0xFF03A9F4,
)