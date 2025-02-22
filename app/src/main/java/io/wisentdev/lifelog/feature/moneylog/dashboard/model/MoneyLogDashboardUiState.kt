package io.wisentdev.lifelog.feature.moneylog.dashboard.model

import io.wisentdev.lifelog.feature.data.UiMessage

sealed interface MoneyLogDashboardUiState {

    data class Success(
        val items: List<MoneyLogDashboardItem> = listOf(
            MoneyLogDashboardItem.BalanceHeaderDetails(
                balance = 1337f,
                expensesPercentage = 0.3f
            ),
            MoneyLogDashboardItem.OverallBreakdown(
                expensesTotal = 163f,
                incomeTotal = 1500f
            ),
            MoneyLogDashboardItem.TopCategoriesBreakdown(
                id = KEY_TOP_EXPENSES_BREAKDOWN,
                categories = mockedExpenseCategories,
                isExpensesBreakdown = true
            ),
            MoneyLogDashboardItem.TopCategoriesBreakdown(
                id = KEY_TOP_INCOMES_BREAKDOWN,
                categories = mockedIncomeCategories,
                isExpensesBreakdown = false
            )
        )
    ) : MoneyLogDashboardUiState

    data class Error(
        val message: UiMessage
    ) : MoneyLogDashboardUiState

    data object Loading : MoneyLogDashboardUiState
}