package io.wisentdev.lifelog.data.db.moneylog

import androidx.room.Database
import androidx.room.RoomDatabase
import io.wisentdev.lifelog.data.db.moneylog.dao.CategoryDao
import io.wisentdev.lifelog.data.db.moneylog.dao.MoneyEntryDao
import io.wisentdev.lifelog.data.db.moneylog.entities.MoneyEntryEntity
import io.wisentdev.lifelog.data.db.moneylog.entities.MoneyLogCategoryEntity

@Database(
    entities = [MoneyEntryEntity::class, MoneyLogCategoryEntity::class],
    version = 1,
    //TODO: Enable exportSchema
    exportSchema = false
)
abstract class MoneyLogDatabase : RoomDatabase() {

    abstract fun moneyEntryDao(): MoneyEntryDao

    abstract fun categoryDao(): CategoryDao
}