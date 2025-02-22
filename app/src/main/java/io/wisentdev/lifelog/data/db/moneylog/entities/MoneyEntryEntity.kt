package io.wisentdev.lifelog.data.db.moneylog.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = MONEY_ENTRY_TABLE_NAME)
data class MoneyEntryEntity(
    @PrimaryKey
    @ColumnInfo(name = KEY_MONEY_ENTRY_ENTITY_ID)
    val id: String,
    val value: Float,
    val note: String,
    val date: String,
    val categoryId: String
)

const val MONEY_ENTRY_TABLE_NAME = "MoneyEntry"
const val KEY_MONEY_ENTRY_ENTITY_ID = "entryId"
