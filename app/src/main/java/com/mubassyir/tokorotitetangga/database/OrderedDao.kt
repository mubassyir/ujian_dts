package com.mubassyir.tokorotitetangga.database

import androidx.room.*
import com.mubassyir.tokorotitetangga.database.model.Ordered

@Dao
interface OrderedDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(orderedBread: Ordered)

    @Update
    suspend fun update(orderedBread: Ordered)

    @Delete
    suspend fun delete(orderedBread: Ordered)

    @Query("SELECT * from ordered ORDER BY id ASC")
    suspend fun getAllOrder(): List<Ordered>
}