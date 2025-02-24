package io.wisentdev.lifelog.data.repo.moneylog

import io.wisentdev.lifelog.data.db.moneylog.entities.CategoryWithEntries

interface MoneyLogRepository {

    suspend fun getCategoriesWithEntries(): List<CategoryWithEntries>
}