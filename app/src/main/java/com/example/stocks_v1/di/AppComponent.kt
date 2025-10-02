package com.example.stocks_v1.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: com.example.stocks_v1.MainActivity)
    fun inject(factory: com.example.presentation.stocks.StocksViewModelFactory)

    companion object {
        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent =
            instance ?: synchronized(this) {
                instance ?: DaggerAppComponent.create().also { instance = it }
            }
    }
}
