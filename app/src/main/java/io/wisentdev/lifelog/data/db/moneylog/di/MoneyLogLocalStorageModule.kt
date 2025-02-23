package io.wisentdev.lifelog.data.db.moneylog.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.wisentdev.lifelog.data.db.moneylog.MoneyLogDatabase
import io.wisentdev.lifelog.data.db.moneylog.dao.CategoryDao
import io.wisentdev.lifelog.data.db.moneylog.datasource.MoneyLogLocalDataSource
import io.wisentdev.lifelog.data.db.moneylog.datasource.MoneyLogLocalDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoneyLogLocalStorageModule {

    @Provides
    @Singleton
    fun provideMoneyLogDatabase(@ApplicationContext context: Context): MoneyLogDatabase =
        Room.databaseBuilder(
            context = context,
            klass = MoneyLogDatabase::class.java,
            name = MONEY_LOG_DATABASE_NAME
        ).build()

    @Provides
    fun provideCategoryDao(database: MoneyLogDatabase): CategoryDao = database.categoryDao()

    @Provides
    @Singleton
    fun provideLocalDataSource(
        categoryDao: CategoryDao
    ): MoneyLogLocalDataSource = MoneyLogLocalDataSourceImpl(
        categoryDao = categoryDao
    )
}

private const val MONEY_LOG_DATABASE_NAME = "money_log_db"

