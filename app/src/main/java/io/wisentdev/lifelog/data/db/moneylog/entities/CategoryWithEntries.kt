package io.wisentdev.lifelog.data.db.moneylog.entities

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryWithEntries(
    @Embedded val category: MoneyLogCategoryEntity,
    @Relation(
        parentColumn = KEY_CATEGORY_ID,
        entityColumn = KEY_MONEY_ENTRY_ENTITY_ID
    )
    val entries: List<MoneyEntryEntity>,
)

