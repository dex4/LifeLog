package io.wisentdev.lifelog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import io.wisentdev.lifelog.feature.moneylog.dashboard.MoneyLogDashboardViewModel
import io.wisentdev.lifelog.feature.moneylog.dashboard.ui.MoneyLogDashboard
import io.wisentdev.lifelog.ui.theme.LifeLogTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifeLogTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    val viewModel = viewModel<MoneyLogDashboardViewModel>()
                    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                    MoneyLogDashboard(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = LifeLogTheme.colorScheme.background)
                            .padding(bottom = 16.dp)
                            .padding(innerPadding),
                        uiState = uiState,
                        onViewCategoriesDetailsClicked = {},
                        onAddExpense = {},
                        onAddIncome = {}
                    )
                }
            }
        }
    }
}