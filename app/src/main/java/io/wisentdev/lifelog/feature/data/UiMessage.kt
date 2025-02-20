package io.wisentdev.lifelog.feature.data

import androidx.annotation.StringRes

sealed interface UiMessage {

    @JvmInline
    value class RawString(val value: String)

    @JvmInline
    value class ResString(@StringRes val value: Int)
}