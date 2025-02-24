package io.wisentdev.lifelog.data.db.moneylog.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import io.wisentdev.lifelog.data.db.moneylog.entities.CategoryWithEntries
import io.wisentdev.lifelog.data.db.moneylog.entities.MONEY_LOG_CATEGORY_TABLE_NAME
import io.wisentdev.lifelog.data.db.moneylog.entities.MoneyLogCategoryEntity

@Dao
interface CategoryDao {

    @Query("SELECT *  FROM $MONEY_LOG_CATEGORY_TABLE_NAME")
    suspend fun getAll(): List<MoneyLogCategoryEntity>

    @Query("SELECT * FROM $MONEY_LOG_CATEGORY_TABLE_NAME WHERE isExpense = 1")
    suspend fun getExpenseCategories(): List<MoneyLogCategoryEntity>

    @Query("SELECT * FROM $MONEY_LOG_CATEGORY_TABLE_NAME WHERE isExpense = 0")
    suspend fun getIncomeCategories(): List<MoneyLogCategoryEntity>

    @Transaction
    @Query("SELECT * FROM $MONEY_LOG_CATEGORY_TABLE_NAME")
    suspend fun getCategoryWithEntries(): List<CategoryWithEntries>

    @Insert
    suspend fun insert(category: MoneyLogCategoryEntity)

    @Insert
    suspend fun insertAll(categories: List<MoneyLogCategoryEntity>)

    @Update
    suspend fun update(category: MoneyLogCategoryEntity)

    @Update
    suspend fun updateAll(categories: List<MoneyLogCategoryEntity>)

    @Delete
    suspend fun delete(category: MoneyLogCategoryEntity)

    @Delete
    suspend fun deleteAll(categories: List<MoneyLogCategoryEntity>)
}