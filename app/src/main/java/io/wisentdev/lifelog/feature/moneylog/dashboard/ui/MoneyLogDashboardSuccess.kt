package io.wisentdev.lifelog.feature.moneylog.dashboard.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogDashboardItem
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogDashboardUiState
import io.wisentdev.lifelog.ui.theme.LifeLogTheme

@Composable
fun MoneyLogDashboardSuccess(
    modifier: Modifier = Modifier,
    uiState: MoneyLogDashboardUiState.Success,
    onViewCategoriesDetailsClicked: (isExpenseCategories: Boolean) -> Unit,
    onAddIncome: () -> Unit,
    onAddExpense: () -> Unit,
) {
    Box(modifier = modifier) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = LifeLogTheme.dimensions.xLarge,
                end = LifeLogTheme.dimensions.xLarge,
                bottom = 96.dp
            ),
            verticalArrangement = Arrangement.spacedBy(LifeLogTheme.dimensions.xLarge)
        ) {
            items(uiState.items) { item: MoneyLogDashboardItem ->
                when (item) {
                    is MoneyLogDashboardItem.BalanceHeaderDetails ->
                        BalanceHeader(
                            modifier = Modifier.fillMaxWidth(),
                            balanceHeaderDetails = item
                        )

                    is MoneyLogDashboardItem.OverallBreakdown -> OverallBreakdown(
                        modifier = Modifier.fillMaxWidth(),
                        overallBreakdown = item
                    )

                    is MoneyLogDashboardItem.TopCategoriesBreakdown -> TopCategoriesBreakdown(
                        modifier = Modifier.fillMaxWidth(),
                        topCategoriesBreakdown = item,
                        onViewCategoriesDetailsClicked = {
                            onViewCategoriesDetailsClicked(item.isExpensesBreakdown)
                        }
                    )
                }
            }
        }

        LogEntryActionButtons(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            onAddIncome = onAddIncome,
            onAddExpense = onAddExpense
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun MoneyLogDashboardSuccess_Preview() {
    LifeLogTheme {
        MoneyLogDashboardSuccess(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LifeLogTheme.colorScheme.background)
                .padding(vertical = LifeLogTheme.dimensions.medium),
            uiState = MoneyLogDashboardUiState.Success(),
            onAddExpense = {},
            onAddIncome = {},
            onViewCategoriesDetailsClicked = {},
        )
    }
}