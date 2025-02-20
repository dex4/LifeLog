package io.wisentdev.lifelog.feature.moneylog.dashboard.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.mockedExpenses
import io.wisentdev.lifelog.ui.theme.LifeLogTheme

@Composable
fun TopCategoriesBreakdown(
    modifier: Modifier = Modifier,
    topCategoriesBreakdown: MoneyLogDashboardItem.TopCategoriesBreakdown
) {

}

@Preview
@Composable
private fun TopCategoriesBreakdown_Preview() {
    LifeLogTheme {
        TopCategoriesBreakdown(
            modifier = Modifier.fillMaxWidth(),
            topCategoriesBreakdown = MoneyLogDashboardItem.TopCategoriesBreakdown(
                id = KEY_TOP_EXPENSES_BREAKDOWN,
                categories = mockedExpenses.sortedByDescending { it.totalValue }.map { it.name },
                isExpensesBreakdown = true
            )
        )
    }
}