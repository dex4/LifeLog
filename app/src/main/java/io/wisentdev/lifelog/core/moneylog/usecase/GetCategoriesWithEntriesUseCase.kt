package io.wisentdev.lifelog.core.moneylog.usecase

import io.wisentdev.lifelog.R
import io.wisentdev.lifelog.data.db.moneylog.entities.CategoryWithEntries
import io.wisentdev.lifelog.data.repo.moneylog.MoneyLogRepository
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogCategoryDetails
import javax.inject.Inject

class GetMoneyLogOverviewDetailsUseCase @Inject constructor(
    private val moneyLogRepository: MoneyLogRepository
) {

    suspend operator fun invoke(): MoneyLogOverview {
        val categories = moneyLogRepository.getCategoriesWithEntries()
        val expenseCategoryEntities = categories.filter { it.category.isExpense && it.entries.isNotEmpty()}
        val incomeCategoryEntities = categories.filter { !it.category.isExpense && it.entries.isNotEmpty()}

        // TODO: Extract extension functions
        val totalIncome = incomeCategoryEntities.sumOf {
            it.entries.sumOf { entry -> entry.value.toDouble() }
        }.toFloat()
        val totalExpenses = expenseCategoryEntities.sumOf {
            it.entries.sumOf { entry -> entry.value.toDouble() }
        }.toFloat()
        val expenseCategories = expenseCategoryEntities.mapIndexed { index, categoryWithEntries: CategoryWithEntries ->
            val currentCategoryValue = expenseCategoryEntities[index].entries.sumOf { entry ->
                entry.value.toDouble()
            }.toFloat()
            MoneyLogCategoryDetails(
                id = categoryWithEntries.category.id,
                name = categoryWithEntries.category.name,
                value = currentCategoryValue,
                valuePercentage = currentCategoryValue / totalExpenses,
                // TODO: Implement logic to determine icon from id but in the ViewModel layer when mapping to UI
                iconRes = R.drawable.ic_euro,
                iconTint = categoryWithEntries.category.categoryColor,
            )
        }.sortedByDescending { it.value }

        val incomeCategories = incomeCategoryEntities.mapIndexed { index, categoryWithEntries: CategoryWithEntries ->
            val currentCategoryValue = incomeCategoryEntities[index].entries.sumOf { entry ->
                entry.value.toDouble()
            }.toFloat()
            MoneyLogCategoryDetails(
                id = categoryWithEntries.category.id,
                name = categoryWithEntries.category.name,
                value = currentCategoryValue,
                valuePercentage = currentCategoryValue / totalIncome,
                // TODO: Implement logic to determine icon from id but in the ViewModel layer when mapping to UI
                iconRes = R.drawable.ic_euro,
                iconTint = categoryWithEntries.category.categoryColor,
            )
        }.sortedByDescending { it.value }

        return MoneyLogOverview(
            balance = totalIncome - totalExpenses,
            spentPercentage = totalExpenses / (totalIncome + totalExpenses),
            totalIncome = totalIncome,
            totalExpenses = totalExpenses,
            expenseCategories = expenseCategories,
            incomeCategories = incomeCategories,
        )
    }
}

data class MoneyLogOverview(
    val balance: Float,
    val spentPercentage: Float,
    val totalIncome: Float,
    val totalExpenses: Float,
    val expenseCategories: List<MoneyLogCategoryDetails>,
    val incomeCategories: List<MoneyLogCategoryDetails>,
)