package com.mubassyir.tokorotitetangga.database

import com.mubassyir.tokorotitetangga.database.model.Ordered

class DatabaseHelperImpl(private val appDatabase: OrderedRoomDatabse) : DatabaseHelper {

    override suspend fun getAllOrder(): List<Ordered> = appDatabase.userDao().getAllOrder()

    override suspend fun insert(order : Ordered) = appDatabase.userDao().insert(order)

}