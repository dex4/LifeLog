package io.wisentdev.lifelog.feature.moneylog.dashboard.ui

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import io.wisentdev.lifelog.R
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.KEY_TOP_EXPENSES_BREAKDOWN
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogDashboardItem
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.mockedExpenseCategories
import io.wisentdev.lifelog.ui.theme.LifeLogTheme
import kotlin.math.min

@Composable
fun TopCategoriesBreakdown(
    modifier: Modifier = Modifier,
    topCategoriesBreakdown: MoneyLogDashboardItem.TopCategoriesBreakdown,
    onViewCategoriesDetailsClicked: () -> Unit
) {
    val count = remember(topCategoriesBreakdown) { min(topCategoriesBreakdown.categories.size, MAX_DISPLAYED_TOP_CATEGORIES) }
    val stringRes = remember(topCategoriesBreakdown) {
        //TODO: Use string res instead of raw string
        if (topCategoriesBreakdown.isExpensesBreakdown) "Top %s Expenses" else "Top %s Income Sources"
    }
    Column(
        modifier = modifier
            .shadow(
                elevation = 4.dp,
                shape = LifeLogTheme.shapes.medium,
                spotColor = LifeLogTheme.colorScheme.onBackground,
            )
            .background(
                color = LifeLogTheme.colorScheme.surface,
                shape = LifeLogTheme.shapes.medium,
            )
            .padding(horizontal = LifeLogTheme.dimensions.medium)
            .padding(
                top = LifeLogTheme.dimensions.small,
                bottom = LifeLogTheme.dimensions.xxSmall,
            ),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = String.format(stringRes, count),
            color = LifeLogTheme.colorScheme.onBackground,
            style = LifeLogTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = LifeLogTheme.dimensions.small),
            verticalAlignment = Alignment.Top
        ) {
            Canvas(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
            ) {
                var anglesSum = 0f
                topCategoriesBreakdown.categories.fastForEach {
                    val sweepAngle = anglesSum + 360 * it.valuePercentage
                    drawArc(
                        color = Color(it.iconTint),
                        startAngle = -180f + anglesSum,
                        sweepAngle = 360 * it.valuePercentage,
                        size = Size(size.width, size.width),
                        useCenter = true,
                    )
                    anglesSum += sweepAngle - anglesSum
                }
            }
            Column(modifier = Modifier.weight(2f)) {
                repeat(topCategoriesBreakdown.categories.size) {
                    val item = topCategoriesBreakdown.categories[it]
                    val itemColor = remember(item) { Color(item.iconTint) }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = LifeLogTheme.dimensions.small)
                            .padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .background(color = itemColor)
                        )
                        Text(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = LifeLogTheme.dimensions.xSmall),
                            text = item.name,
                            color = LifeLogTheme.colorScheme.onBackground,
                            style = LifeLogTheme.typography.bodyMedium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier.padding(start = LifeLogTheme.dimensions.xSmall),
                            text = "€${item.value}",
                            color = LifeLogTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
        TextButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = LifeLogTheme.dimensions.xxSmall),
            colors = ButtonDefaults.textButtonColors(
                contentColor = LifeLogTheme.colorScheme.onSurface
            ),
            onClick = onViewCategoriesDetailsClicked,
        ) {
            val iconRes = remember(topCategoriesBreakdown.isExpensesBreakdown) {
                if (topCategoriesBreakdown.isExpensesBreakdown) {
                    R.drawable.ic_shopping_cart_outline
                } else {
                    R.drawable.ic_wallet_outline
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(size = 20.dp),
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier.padding(start = LifeLogTheme.dimensions.xxSmall),
                    text = "View details",
                    style = LifeLogTheme.typography.bodyLarge,
                )
            }
        }
    }
}

private const val MAX_DISPLAYED_TOP_CATEGORIES = 5

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TopCategoriesBreakdown_Preview() {
    LifeLogTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(LifeLogTheme.colorScheme.background)
        ) {
            TopCategoriesBreakdown(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = LifeLogTheme.dimensions.xxLarge),
                topCategoriesBreakdown = MoneyLogDashboardItem.TopCategoriesBreakdown(
                    id = KEY_TOP_EXPENSES_BREAKDOWN,
                    categories = mockedExpenseCategories,
                    isExpensesBreakdown = true
                ),
                onViewCategoriesDetailsClicked = {}
            )
        }
    }
}