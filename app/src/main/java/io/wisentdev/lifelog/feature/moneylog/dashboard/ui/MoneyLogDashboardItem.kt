package io.wisentdev.lifelog.feature.moneylog.dashboard.ui

import androidx.annotation.FloatRange

sealed class MoneyLogDashboardItem(open val id: String) {

    data class BalanceHeaderDetails(
        val balance: Float,
        @FloatRange(0.0, 1.0)
        val expensesPercentage: Float
    ) : MoneyLogDashboardItem(id = KEY_BALANCE_HEADER)

    data class OverallBreakdown(
        val expensesTotal: Float,
        val incomeTotal: Float
    ) : MoneyLogDashboardItem(id = KEY_OVERALL_BREAKDOWN)

    data class TopCategoriesBreakdown(
        override val id: String,
        val categories: List<String>,
        val isExpensesBreakdown: Boolean
    ) : MoneyLogDashboardItem(id = id)
}

private const val KEY_BALANCE_HEADER = "KEY_BALANCE_HEADER"
private const val KEY_OVERALL_BREAKDOWN = "KEY_OVERALL_BREAKDOWN"
const val KEY_TOP_EXPENSES_BREAKDOWN = "KEY_TOP_EXPENSES_BREAKDOWN"
const val KEY_TOP_INCOMES_BREAKDOWN = "KEY_TOP_INCOMES_BREAKDOWN"