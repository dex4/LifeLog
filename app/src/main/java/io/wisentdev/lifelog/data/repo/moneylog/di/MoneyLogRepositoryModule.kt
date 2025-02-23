package io.wisentdev.lifelog.data.repo.moneylog.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.wisentdev.lifelog.data.db.moneylog.datasource.MoneyLogLocalDataSource
import io.wisentdev.lifelog.data.repo.moneylog.MoneyLogRepository
import io.wisentdev.lifelog.data.repo.moneylog.MoneyLogRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoneyLogRepositoryModule {

    @Provides
    @Singleton
    fun provideMoneyLogRepository(localDataSource: MoneyLogLocalDataSource): MoneyLogRepository =
        MoneyLogRepositoryImpl(
            localDataSource = localDataSource
        )
}