package io.wisentdev.lifelog.data.db.moneylog.datasource

import io.wisentdev.lifelog.data.db.moneylog.dao.CategoryDao
import io.wisentdev.lifelog.data.db.moneylog.entities.CategoryWithEntries

class MoneyLogLocalDataSourceImpl(
    private val categoryDao: CategoryDao
) : MoneyLogLocalDataSource {

    override suspend fun getCategoriesWithEntries(): List<CategoryWithEntries> = categoryDao.getCategoryWithEntries()
}