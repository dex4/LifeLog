package io.wisentdev.lifelog.data.datasource

import io.wisentdev.lifelog.data.db.moneylog.entities.CategoryWithEntries

interface MoneyLogLocalDataSource {

    suspend fun getCategoriesWithEntries(): List<CategoryWithEntries>
}