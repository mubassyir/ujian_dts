package com.mubassyir.tokorotitetangga.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mubassyir.tokorotitetangga.database.model.Ordered

@Database(entities = [Ordered::class], version = 1)
abstract class OrderedRoomDatabse : RoomDatabase() {

    abstract fun userDao(): OrderedDao

}