package com.mubassyir.tokorotitetangga.database.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Ordered(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "customer") val customer: String?,
    @ColumnInfo(name = "bread_name") val breadName: String?,
    @ColumnInfo(name = "latitude") val latitude: String?,
    @ColumnInfo(name = "longtitude") val longtitude: String?,
    @ColumnInfo(name = "price") val price: String?,
    @ColumnInfo(name = "image") val image: String?
):Parcelable