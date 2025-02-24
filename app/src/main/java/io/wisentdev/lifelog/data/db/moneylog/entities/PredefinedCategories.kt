package io.wisentdev.lifelog.data.db.moneylog.entities

import java.util.UUID

val predefinedTemporaryExpenses = listOf(
    MoneyEntryEntity(
        id = UUID.randomUUID().toString(),
        value = 163f,
        note = "",
        date = "",
        categoryId = "Food_categoryId",
    ),
    MoneyEntryEntity(
        id = UUID.randomUUID().toString(),
        value = 75f,
        note = "",
        date = "",
        categoryId = "Eating_out_categoryId",
    ),
    MoneyEntryEntity(
        id = UUID.randomUUID().toString(),
        value = 42f,
        note = "",
        date = "",
        categoryId = "Vacation_categoryId",
    ),
    MoneyEntryEntity(
        id = UUID.randomUUID().toString(),
        value = 102f,
        note = "",
        date = "",
        categoryId = "Transportation_categoryId",
    ),
    MoneyEntryEntity(
        id = UUID.randomUUID().toString(),
        value = 28f,
        note = "",
        date = "",
        categoryId = "Fuel_categoryId",
    ),
    MoneyEntryEntity(
        id = UUID.randomUUID().toString(),
        value = 45f,
        note = "",
        date = "",
        categoryId = "House_categoryId",
    ),
    MoneyEntryEntity(
        id = UUID.randomUUID().toString(),
        value = 87f,
        note = "",
        date = "",
        categoryId = "General_expenses_categoryId",
    )
)

val predefinedTemporaryIncome = listOf(
    MoneyEntryEntity(
        id = UUID.randomUUID().toString(),
        value = 1500f,
        note = "",
        date = "",
        categoryId = "Salary_categoryId",
    )
)

val predefinedExpenseCategories = listOf(
    MoneyLogCategoryEntity(
        id = "Food_categoryId",
        name = "Food",
        isExpense = true,
        iconId = "N/A",
        categoryColor = 0xFFE6B800,
    ),
    MoneyLogCategoryEntity(
        id = "Eating_out_categoryId",
        name = "Eating out",
        isExpense = true,
        iconId = "N/A",
        categoryColor = 0xFF4A148C,
    ),
    MoneyLogCategoryEntity(
        id = "Vacation_categoryId",
        name = "Vacation",
        isExpense = true,
        iconId = "N/A",
        categoryColor = 0xFF0288D1,
    ),
    MoneyLogCategoryEntity(
        id = "Transportation_categoryId",
        name = "Transportation",
        isExpense = true,
        iconId = "N/A",
        categoryColor = 0xFFD50000,
    ),
    MoneyLogCategoryEntity(
        id = "Car_categoryId",
        name = "Car",
        isExpense = true,
        iconId = "N/A",
        categoryColor = 0xFFE6B800,
    ),
    MoneyLogCategoryEntity(
        id = "Fuel_categoryId",
        name = "Fuel",
        isExpense = true,
        iconId = "N/A",
        categoryColor = 0xFFE6B800,
    ),
    MoneyLogCategoryEntity(
        id = "House_categoryId",
        name = "House",
        isExpense = true,
        iconId = "N/A",
        categoryColor = 0xFFE6B800,
    ),
    MoneyLogCategoryEntity(
        id = "General_expenses_categoryId",
        name = "General expenses",
        isExpense = true,
        iconId = "N/A",
        categoryColor = 0xFFE6B800,
    ),
    MoneyLogCategoryEntity(
        id = "Hobbies_categoryId",
        name = "Hobbies",
        isExpense = true,
        iconId = "N/A",
        categoryColor = 0xFFE6B800,
    ),
    MoneyLogCategoryEntity(
        id = "Games_categoryId",
        name = "Games",
        isExpense = true,
        iconId = "N/A",
        categoryColor = 0xFFE6B800,
    ),
    MoneyLogCategoryEntity(
        id = "Health_categoryId",
        name = "Health",
        isExpense = true,
        iconId = "N/A",
        categoryColor = 0xFFE6B800,
    ),
    MoneyLogCategoryEntity(
        id = "Subscriptions_categoryId",
        name = "Subscriptions",
        isExpense = true,
        iconId = "N/A",
        categoryColor = 0xFFE6B800,
    )
)

val predefinedIncomeCategories = listOf(
    MoneyLogCategoryEntity(
        id = "Salary_categoryId",
        name = "Salary",
        isExpense = false,
        iconId = "N/A",
        categoryColor = 0xFF4CAF50,
    ),
    MoneyLogCategoryEntity(
        id = "Freelance_categoryId",
        name = "Freelance",
        isExpense = false,
        iconId = "N/A",
        categoryColor = 0xFF80DEEA,
    ),
    MoneyLogCategoryEntity(
        id = "Meal tickets_categoryId",
        name = "Meal tickets",
        isExpense = false,
        iconId = "N/A",
        categoryColor = 0xFFE6B800,
    ),
    MoneyLogCategoryEntity(
        id = "Savings_categoryId",
        name = "Savings",
        isExpense = false,
        iconId = "N/A",
        categoryColor = 0xFF1565C0,
    ),
)