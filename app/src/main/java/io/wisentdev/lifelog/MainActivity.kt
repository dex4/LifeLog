package io.wisentdev.lifelog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.wisentdev.lifelog.feature.moneylog.dashboard.ui.MoneyLogDashboard
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogDashboardUiState
import io.wisentdev.lifelog.ui.theme.LifeLogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LifeLogTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MoneyLogDashboard(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = LifeLogTheme.colorScheme.background)
                            .padding(bottom = 16.dp)
                            .padding(innerPadding),
                        uiState = MoneyLogDashboardUiState.Success(),
                        onViewCategoriesDetailsClicked = {},
                        onAddExpense = {},
                        onAddIncome = {}
                    )
                }
            }
        }
    }
}