package io.wisentdev.lifelog.feature.moneylog.dashboard.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogDashboardUiState
import io.wisentdev.lifelog.ui.theme.LifeLogTheme

@Composable
fun MoneyLogDashboard(
    modifier: Modifier = Modifier,
    uiState: MoneyLogDashboardUiState,
    onAddIncome: () -> Unit,
    onAddExpense: () -> Unit,
) {
    when (uiState) {
        is MoneyLogDashboardUiState.Success -> MoneyLogDashboardSuccess(
            modifier = modifier,
            uiState = uiState,
            onAddIncome = onAddIncome,
            onAddExpense = onAddExpense
        )


        is MoneyLogDashboardUiState.Error -> TODO()
        MoneyLogDashboardUiState.Loading -> TODO()
    }

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun MoneyLogDashboard_Preview() {
    LifeLogTheme {
        MoneyLogDashboard(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LifeLogTheme.colorScheme.background)
                .padding(bottom = 16.dp),
            uiState = MoneyLogDashboardUiState.Success(),
            onAddExpense = {},
            onAddIncome = {}
        )
    }
}