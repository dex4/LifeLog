package io.wisentdev.lifelog.feature.moneylog.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.wisentdev.lifelog.core.moneylog.usecase.GetMoneyLogOverviewUseCase
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.KEY_TOP_EXPENSES_BREAKDOWN
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.KEY_TOP_INCOMES_BREAKDOWN
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogDashboardItem
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogDashboardUiState
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MoneyLogDashboardViewModel @Inject constructor(
    private val getMoneyLogOverviewUseCase: GetMoneyLogOverviewUseCase
) : ViewModel() {

    val uiState: MutableStateFlow<MoneyLogDashboardUiState> = MutableStateFlow(MoneyLogDashboardUiState.Success())

    init {
        viewModelScope.launch {
            val result = getMoneyLogOverviewUseCase()

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
                            categories = result.expenseCategories,
                            isExpensesBreakdown = true
                        ),
                        MoneyLogDashboardItem.TopCategoriesBreakdown(
                            id = KEY_TOP_INCOMES_BREAKDOWN,
                            categories = result.incomeCategories,
                            isExpensesBreakdown = false
                        ),
                    )
                )
            }
        }
    }
}