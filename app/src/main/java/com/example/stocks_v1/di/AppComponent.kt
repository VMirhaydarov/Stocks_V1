package com.example.stocks_v1.di

import com.example.domain.usecase.GetEnginesUseCase
import com.example.domain.usecase.GetMarketsUseCase
import com.example.domain.usecase.GetStocksUseCase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getEnginesUseCase(): GetEnginesUseCase
    fun getMarketsUseCase(): GetMarketsUseCase
    fun getStocksUseCase(): GetStocksUseCase

    companion object {
        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent =
            instance ?: synchronized(this) {
                instance ?: DaggerAppComponent.create().also { instance = it }
            }
    }
}

