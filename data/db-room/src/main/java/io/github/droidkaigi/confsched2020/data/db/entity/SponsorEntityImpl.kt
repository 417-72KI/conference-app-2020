package io.github.droidkaigi.confsched2020.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sponsor")
data class SponsorEntityImpl(
    @PrimaryKey
    override var id: Int,
    override var name: String,
    override var url: String,
    override var image: String,
    override var category: String,
    override var categoryIndex: Int,
    override var displayOrder: Int
) : SponsorEntity
