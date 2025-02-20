package io.wisentdev.lifelog.feature.moneylog.dashboard.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.wisentdev.lifelog.R
import io.wisentdev.lifelog.ui.theme.LifeLogTheme

@Composable
fun LogEntryActionButtons(
    modifier: Modifier = Modifier,
    onAddIncome: () -> Unit,
    onAddExpense: () -> Unit,
) {
    Row(modifier = modifier) {
        FloatingActionButton(
            modifier = Modifier
                .padding(end = 16.dp)
                .border(
                    width = 4.dp,
                    color = LifeLogTheme.extendedColors.green.color,
                    shape = LifeLogTheme.shapes.medium
                ),
            containerColor = LifeLogTheme.colorScheme.surface,
            shape = LifeLogTheme.shapes.medium,
            onClick = onAddIncome
        ) {
            Icon(
                tint = LifeLogTheme.extendedColors.green.color,
                painter = painterResource(R.drawable.ic_plus),
                contentDescription = null
            )
        }

        FloatingActionButton(
            modifier = Modifier.border(
                width = 4.dp,
                color = LifeLogTheme.extendedColors.red.color,
                shape = LifeLogTheme.shapes.medium
            ),
            containerColor = LifeLogTheme.colorScheme.surface,
            shape = LifeLogTheme.shapes.medium,
            onClick = onAddExpense
        ) {
            Icon(
                tint = LifeLogTheme.extendedColors.red.color,
                painter = painterResource(R.drawable.ic_minus),
                contentDescription = null
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LogEntryActionButtons_Preview() {
    LifeLogTheme {
        LogEntryActionButtons(
            modifier = Modifier
                .background(LifeLogTheme.colorScheme.background)
                .padding(LifeLogTheme.dimensions.medium),
            onAddIncome = {},
            onAddExpense = {}
        )
    }
}