package io.wisentdev.lifelog.feature.moneylog.dashboard.model

import io.wisentdev.lifelog.R

val mockedExpenseCategories = listOf(
    MoneyLogCategoryDetails(
        name = "Food",
        value = 400f,
        valuePercentage = 0.40f,
        iconRes = R.drawable.ic_food,
        iconTint = 0xFFE6B800
    ),
    MoneyLogCategoryDetails(
        name = "Entertainment",
        value = 250f,
        valuePercentage = 0.25f,
        iconRes = R.drawable.ic_entertainment,
        iconTint = 0xFF4A148C
    ),
    MoneyLogCategoryDetails(
        name = "Transportation",
        value = 150f,
        valuePercentage = 0.15f,
        iconRes = R.drawable.ic_transportation,
        iconTint = 0xFF0288D1
    ),
    MoneyLogCategoryDetails(
        name = "Health",
        value = 100f,
        valuePercentage = 0.10f,
        iconRes = R.drawable.ic_health,
        iconTint = 0xFFD50000
    ),
    MoneyLogCategoryDetails(
        name = "Other",
        value = 70f,
        valuePercentage = 0.10f,
        iconRes = R.drawable.ic_euro,
        iconTint = 0xFF66BB6A
    ),
)

val mockedIncomeCategories = listOf(
    MoneyLogCategoryDetails(
        name = "Salary",
        value = 600f,
        valuePercentage = 0.60f,
        iconRes = R.drawable.ic_work,
        iconTint = 0xFF4CAF50
    ),
    MoneyLogCategoryDetails(
        name = "Freelance",
        value = 200f,
        valuePercentage = 0.20f,
        iconRes = R.drawable.ic_assignment,
        iconTint = 0xFF80DEEA
    ),
    MoneyLogCategoryDetails(
        name = "Investments",
        value = 100f,
        valuePercentage = 0.10f,
        iconRes = R.drawable.ic_investing,
        iconTint = 0xFFE6B800
    ),
    MoneyLogCategoryDetails(
        name = "Savings",
        value = 50f,
        valuePercentage = 0.05f,
        iconRes = R.drawable.ic_savings,
        iconTint = 0xFF1565C0
    ),
    MoneyLogCategoryDetails(
        name = "Other",
        value = 50f,
        valuePercentage = 0.05f,
        iconRes = R.drawable.ic_euro,
        iconTint = 0xFF03A9F4
    )
)