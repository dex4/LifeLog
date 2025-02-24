package io.wisentdev.lifelog.data.db.moneylog.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = MONEY_LOG_CATEGORY_TABLE_NAME)
data class MoneyLogCategoryEntity(
    @PrimaryKey
    @ColumnInfo(name = MONEY_LOG_CATEGORY_ID)
    val id: String,
    val name: String,
    val isExpense: Boolean,
    val iconId: String,
    val categoryColor: Long
)

const val MONEY_LOG_CATEGORY_TABLE_NAME = "MoneyLogCategories"
const val MONEY_LOG_CATEGORY_ID = "categoryId"