package io.github.droidkaigi.confsched2020.data.api.response

import kotlinx.serialization.Serializable

@Serializable
data class TranslatedNameImpl(
    override val ja: String,
    override val en: String
) : TranslatedName
