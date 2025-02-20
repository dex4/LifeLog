package io.wisentdev.lifelog.feature.moneylog.dashboard.model

import androidx.compose.ui.graphics.Color
import io.wisentdev.lifelog.R
import io.wisentdev.lifelog.feature.data.UiMessage
import io.wisentdev.lifelog.feature.moneylog.dashboard.ui.KEY_TOP_EXPENSES_BREAKDOWN
import io.wisentdev.lifelog.feature.moneylog.dashboard.ui.KEY_TOP_INCOMES_BREAKDOWN
import io.wisentdev.lifelog.feature.moneylog.dashboard.ui.MoneyLogDashboardItem

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
                categories = mockedExpenses.sortedByDescending { it.totalValue }.map { it.name },
                isExpensesBreakdown = true
            ),
            MoneyLogDashboardItem.TopCategoriesBreakdown(
                id = KEY_TOP_INCOMES_BREAKDOWN,
                categories = mockedIncomes.sortedByDescending { it.totalValue }.map { it.name },
                isExpensesBreakdown = false
            )
        )
    ) : MoneyLogDashboardUiState

    data class Error(
        val message: UiMessage
    ) : MoneyLogDashboardUiState

    data object Loading : MoneyLogDashboardUiState
}

val mockedExpenses = listOf(
    MoneyLogCategory(
        name = "Food",
        iconRes = R.drawable.ic_food,
        tint = Color(0xFFE57373),
        totalValue = 250.0f,
        isExpense = true
    ),
    MoneyLogCategory(
        name = "Rent",
        iconRes = R.drawable.ic_house,
        tint = Color(0xFF81C784),
        totalValue = 1200.0f,
        isExpense = true
    ),
    MoneyLogCategory(
        name = "Transport",
        iconRes = R.drawable.ic_transportation,
        tint = Color(0xFF64B5F6),
        totalValue = 150.0f,
        isExpense = true
    ),
    MoneyLogCategory(
        name = "Entertainment",
        iconRes = R.drawable.ic_entertainment,
        tint = Color(0xFFFFD54F),
        totalValue = 100.0f,
        isExpense = true
    )
)

private val mockedIncomes = listOf(
    MoneyLogCategory(
        name = "Salary",
        iconRes = R.drawable.ic_euro,
        tint = Color(0xFF4DB6AC),
        totalValue = 3000.0f,
        isExpense = false
    ),
    MoneyLogCategory(
        name = "Freelance",
        iconRes = R.drawable.ic_work,
        tint = Color(0xFFBA68C8),
        totalValue = 800.0f,
        isExpense = false
    ),
    MoneyLogCategory(
        name = "Investments",
        iconRes = R.drawable.ic_investing,
        tint = Color(0xFFA1887F),
        totalValue = 500.0f,
        isExpense = false
    )
)