package com.mubassyir.tokorotitetangga.database

import com.mubassyir.tokorotitetangga.database.model.Ordered

interface DatabaseHelper {

    suspend fun getAllOrder(): List<Ordered>

    suspend fun insert(ordered: Ordered)
}
