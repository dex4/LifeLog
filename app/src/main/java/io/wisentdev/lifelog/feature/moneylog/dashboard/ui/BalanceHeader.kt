package io.wisentdev.lifelog.feature.moneylog.dashboard.ui

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.wisentdev.lifelog.ui.theme.LifeLogTheme

@Composable
fun BalanceHeader(
    modifier: Modifier = Modifier,
    balanceHeaderDetails: MoneyLogDashboardItem.BalanceHeaderDetails
) {
    val fillColor = LifeLogTheme.colorScheme.tertiary
    val color = LifeLogTheme.colorScheme.onTertiary

    Box(modifier = modifier) {
        Canvas(
            modifier = Modifier
                .size(200.dp)
                .padding(top = 32.dp)
                .align(Alignment.TopCenter)
        ) {
            drawArc(
                color = color,
                startAngle = BALANCE_HEADER_START_ANGLE,
                sweepAngle = BALANCE_HEADER_SWEEP_ANGLE,
                useCenter = false,
                size = Size(size.width, size.width),
                style = Stroke(
                    width = 16.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )

            drawArc(
                color = fillColor,
                startAngle = -BALANCE_HEADER_SWEEP_ANGLE,
                sweepAngle = balanceHeaderDetails.expensesPercentage * BALANCE_HEADER_SWEEP_ANGLE,
                useCenter = false,
                size = Size(size.width, size.width),
                style = Stroke(
                    width = 16.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )
        }
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 96.dp),
            text = "Balance\n${balanceHeaderDetails.balance}",
            style = LifeLogTheme.typography.headlineSmall,
            color = LifeLogTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}
private const val BALANCE_HEADER_START_ANGLE = -180f
private const val BALANCE_HEADER_SWEEP_ANGLE = 190f

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BalanceHeader_Preview() {
    LifeLogTheme {
        BalanceHeader(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LifeLogTheme.colorScheme.background),
            balanceHeaderDetails = MoneyLogDashboardItem.BalanceHeaderDetails(
                balance = 1337f,
                expensesPercentage = 0.4f
            )
        )
    }
}