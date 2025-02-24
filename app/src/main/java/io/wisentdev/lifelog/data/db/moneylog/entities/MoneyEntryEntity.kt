package io.wisentdev.lifelog.data.db.moneylog.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = MONEY_ENTRY_TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = MoneyLogCategoryEntity::class,
            parentColumns = [MONEY_LOG_CATEGORY_ID],
            childColumns = [MONEY_LOG_CATEGORY_ID],
            // TODO: Implement feature to allow the user to decide what happens to entries when a category is deleted
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = [MONEY_LOG_CATEGORY_ID])]
)
data class MoneyEntryEntity(
    @PrimaryKey
    val id: String,
    val value: Float,
    val note: String,
    val date: String,
    @ColumnInfo(name = MONEY_LOG_CATEGORY_ID)
    val categoryId: String
)

const val MONEY_ENTRY_TABLE_NAME = "MoneyEntry"