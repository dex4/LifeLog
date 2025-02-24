package io.wisentdev.lifelog.feature.moneylog.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.wisentdev.lifelog.R
import io.wisentdev.lifelog.core.moneylog.usecase.GetMoneyLogOverviewDetailsUseCase
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.KEY_TOP_EXPENSES_BREAKDOWN
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.KEY_TOP_INCOMES_BREAKDOWN
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogCategoryDetails
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogDashboardItem
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogDashboardUiState
import java.util.UUID
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MoneyLogDashboardViewModel @Inject constructor(
    private val getMoneyLogOverviewDetailsUseCase: GetMoneyLogOverviewDetailsUseCase
) : ViewModel() {

    val uiState: MutableStateFlow<MoneyLogDashboardUiState> = MutableStateFlow(MoneyLogDashboardUiState.Success())

    init {
        viewModelScope.launch {
            val result = getMoneyLogOverviewDetailsUseCase()

            uiState.update {
                MoneyLogDashboardUiState.Success(
                    listOf(
                        MoneyLogDashboardItem.BalanceHeaderDetails(
                            balance = result.balance,
                            expensesPercentage = result.spentPercentage
                        ),
                        MoneyLogDashboardItem.OverallBreakdown(
                            expensesTotal = result.totalExpenses,
                            incomeTotal = result.totalIncome
                        ),
                        MoneyLogDashboardItem.TopCategoriesBreakdown(
                            id = KEY_TOP_EXPENSES_BREAKDOWN,
                            categories = result.expenseCategories.reduceToTopCategories(),
                            isExpensesBreakdown = true
                        ),
                        MoneyLogDashboardItem.TopCategoriesBreakdown(
                            id = KEY_TOP_INCOMES_BREAKDOWN,
                            categories = result.incomeCategories.reduceToTopCategories(),
                            isExpensesBreakdown = false
                        ),
                    )
                )
            }
        }
    }

    companion object {
        private fun List<MoneyLogCategoryDetails>.reduceToTopCategories(): List<MoneyLogCategoryDetails> {
            if (size <= 5) return this

            val topFourCategories = take(4)
            val totalValue = this.sumOf { it.value.toDouble() }
            val topFourCategoriesValue = topFourCategories.sumOf { it.value.toDouble() }
            val otherCategoriesValue = totalValue - topFourCategoriesValue
            val otherCategory = MoneyLogCategoryDetails(
                id = UUID.randomUUID().toString(),
                // TODO: Extract to string res, maybe use UiMessage for these names
                name = "Other ..",
                value = otherCategoriesValue.toFloat(),
                valuePercentage = (otherCategoriesValue / totalValue).toFloat(),
                iconRes = R.drawable.ic_euro,
                iconTint = 0xFF03A9F4,
            )

            return topFourCategories + otherCategory
        }
    }
}