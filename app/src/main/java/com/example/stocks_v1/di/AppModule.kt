package com.example.stocks_v1.di

import com.example.data.repository.StockRepositoryImpl
import com.example.domain.repository.IStockRepository
import com.example.domain.usecase.GetEnginesUseCase
import com.example.domain.usecase.GetMarketsUseCase
import com.example.domain.usecase.GetStocksUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideStockRepository(): IStockRepository = StockRepositoryImpl()

    @Provides
    @Singleton
    fun provideGetEnginesUseCase(repository: IStockRepository): GetEnginesUseCase = GetEnginesUseCase(repository)

    @Provides
    @Singleton
    fun provideGetMarketsUseCase(repository: IStockRepository): GetMarketsUseCase = GetMarketsUseCase(repository)

    @Provides
    @Singleton
    fun provideGetStocksUseCase(repository: IStockRepository): GetStocksUseCase = GetStocksUseCase(repository)
}

