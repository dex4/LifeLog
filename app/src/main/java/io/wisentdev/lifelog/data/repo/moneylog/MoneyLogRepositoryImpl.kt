package io.wisentdev.lifelog.data.repo.moneylog

import io.wisentdev.lifelog.data.db.moneylog.datasource.MoneyLogLocalDataSource
import io.wisentdev.lifelog.data.db.moneylog.entities.CategoryWithEntries

class MoneyLogRepositoryImpl(
    private val localDataSource: MoneyLogLocalDataSource
) : MoneyLogRepository {

    override suspend fun getCategoriesWithEntries(): List<CategoryWithEntries> = localDataSource.getCategoriesWithEntries()
}