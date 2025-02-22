package io.wisentdev.lifelog.data.db.moneylog.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.wisentdev.lifelog.data.db.moneylog.entities.MONEY_ENTRY_TABLE_NAME
import io.wisentdev.lifelog.data.db.moneylog.entities.MoneyEntryEntity

@Dao
interface MoneyEntryDao {

    @Query("SELECT * FROM $MONEY_ENTRY_TABLE_NAME")
    suspend fun getAll(): List<MoneyEntryEntity>

    @Query("SELECT * FROM $MONEY_ENTRY_TABLE_NAME WHERE entryId = :entryId")
    suspend fun getById(entryId: String): MoneyEntryEntity

    @Insert
    suspend fun insert(vararg moneyEntryEntity: MoneyEntryEntity)

    @Update
    suspend fun update(vararg moneyEntryEntity: MoneyEntryEntity)

    @Delete
    suspend fun delete(vararg moneyEntryEntity: MoneyEntryEntity)
}