package com.mubassyir.tokorotitetangga.database

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    private var INSTANCE: OrderedRoomDatabse? = null

    fun getInstance(context: Context): OrderedRoomDatabse {
        if (INSTANCE == null) {
            synchronized(OrderedRoomDatabse::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            OrderedRoomDatabse::class.java,
            "ordered"
        ).build()

}