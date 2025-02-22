package io.wisentdev.lifelog.data.db.moneylog.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = MONEY_LOG_CATEGORY_TABLE_NAME)
data class MoneyLogCategoryEntity(
    @PrimaryKey
    @ColumnInfo(name = KEY_CATEGORY_ID)
    val id: String,
    val name: String,
    val isExpense: Boolean,
    val iconId: String,
    val iconTint: Long
)

const val MONEY_LOG_CATEGORY_TABLE_NAME = "MoneyLogCategories"
const val KEY_CATEGORY_ID = "categoryId"