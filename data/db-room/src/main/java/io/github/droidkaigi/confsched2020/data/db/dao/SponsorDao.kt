package io.github.droidkaigi.confsched2020.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.droidkaigi.confsched2020.data.db.entity.SponsorEntityImpl

@Dao
abstract class SponsorDao {
    @Query("SELECT * FROM sponsor ORDER BY categoryIndex, displayOrder ASC")
    abstract suspend fun allSponsors(): List<SponsorEntityImpl>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(sponsors: List<SponsorEntityImpl>)

    @Query("DELETE FROM sponsor")
    abstract fun deleteAll()
}
