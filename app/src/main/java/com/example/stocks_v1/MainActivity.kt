package com.example.stocks_v1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.stocks_v1.ui.navigation.AppNavHost
import com.example.stocks_v1.ui.theme.Stocks_V1Theme
import javax.inject.Inject
import com.example.presentation.stocks.StocksViewModelFactory
import com.example.presentation.engines.EnginesViewModelFactory
import com.example.presentation.markets.MarketsViewModelFactory

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var stocksViewModelFactory: StocksViewModelFactory
    @Inject
    lateinit var enginesViewModelFactory: EnginesViewModelFactory
    @Inject
    lateinit var marketsViewModelFactory: MarketsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApp).appComponent.inject(this)
        enableEdgeToEdge()
        setContent {
            Stocks_V1Theme {
                AppNavHost(
                    stocksViewModelFactory = stocksViewModelFactory,
                    enginesViewModelFactory = enginesViewModelFactory,
                    marketsViewModelFactory = marketsViewModelFactory
                )
            }
        }
    }
}