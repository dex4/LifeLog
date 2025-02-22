package io.wisentdev.lifelog.feature.moneylog.dashboard.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogDashboardItem
import io.wisentdev.lifelog.ui.theme.LifeLogTheme

@Composable
fun OverallBreakdown(
    modifier: Modifier = Modifier,
    overallBreakdown: MoneyLogDashboardItem.OverallBreakdown
) {
    Row(
        modifier = modifier
            .height(intrinsicSize = IntrinsicSize.Min)
            .background(
                color = LifeLogTheme.colorScheme.surface,
                shape = LifeLogTheme.shapes.medium
            )
            .padding(horizontal = LifeLogTheme.dimensions.medium)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = LifeLogTheme.dimensions.xSmall)
                .padding(end = LifeLogTheme.dimensions.small)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Expenses:",
                textAlign = TextAlign.Start,
                color = LifeLogTheme.colorScheme.onSurface,
                style = LifeLogTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "€${overallBreakdown.expensesTotal}",
                textAlign = TextAlign.End,
                color = LifeLogTheme.extendedColors.red.color,
                style = LifeLogTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }
        VerticalDivider(
            modifier = Modifier.fillMaxHeight(),
            thickness = 1.dp,
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = LifeLogTheme.dimensions.xSmall)
                .padding(start = LifeLogTheme.dimensions.small)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Income:",
                textAlign = TextAlign.Start,
                color = LifeLogTheme.colorScheme.onSurface,
                style = LifeLogTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "€${overallBreakdown.incomeTotal}",
                textAlign = TextAlign.End,
                color = LifeLogTheme.extendedColors.green.color,
                style = LifeLogTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun OverallBreakdown_Preview() {
    LifeLogTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LifeLogTheme.colorScheme.background)
                .padding(LifeLogTheme.dimensions.medium)
        ) {
            OverallBreakdown(
                modifier = Modifier.fillMaxWidth(),
                overallBreakdown = MoneyLogDashboardItem.OverallBreakdown(
                    expensesTotal = 163f,
                    incomeTotal = 1500f
                )
            )
        }
    }
}