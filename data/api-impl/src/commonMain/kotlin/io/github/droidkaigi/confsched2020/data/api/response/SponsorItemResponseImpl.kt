package io.github.droidkaigi.confsched2020.data.api.response

import kotlinx.serialization.Serializable

@Serializable
data class SponsorItemResponseImpl(
    override val id: Int,
    override val name: String,
    override val url: String,
    override val image: String
) : SponsorItemResponse
