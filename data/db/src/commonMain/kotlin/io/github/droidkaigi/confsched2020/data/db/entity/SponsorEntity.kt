package io.github.droidkaigi.confsched2020.data.db.entity

interface SponsorEntity {
    var id: Int
    var name: String
    var url: String
    var image: String
    var category: String
    var categoryIndex: Int
    var displayOrder: Int
}
