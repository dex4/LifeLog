package io.wisentdev.lifelog.data.db.moneylog.entities

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryWithEntries(
    @Embedded val category: MoneyLogCategoryEntity,
    @Relation(
        parentColumn = MONEY_LOG_CATEGORY_ID,
        entityColumn = MONEY_LOG_CATEGORY_ID
    )
    val entries: List<MoneyEntryEntity>,
)

