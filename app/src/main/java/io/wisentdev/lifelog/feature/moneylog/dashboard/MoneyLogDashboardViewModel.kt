package io.wisentdev.lifelog.feature.moneylog.dashboard

import androidx.lifecycle.ViewModel
import io.wisentdev.lifelog.feature.moneylog.dashboard.model.MoneyLogDashboardUiState
import kotlinx.coroutines.flow.MutableStateFlow

class MoneyLogDashboardViewModel : ViewModel() {

    val uiState: MutableStateFlow<MoneyLogDashboardUiState> = MutableStateFlow(MoneyLogDashboardUiState.Success())
}