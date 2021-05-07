package com.mubassyir.tokorotitetangga.model

import android.os.Parcel
import android.os.Parcelable


data class BreadDataModel(
    var bakeName : String?=null,
    var image:String? =null,
    var price:String?=null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(bakeName)
        parcel.writeString(image)
        parcel.writeString(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BreadDataModel> {
        override fun createFromParcel(parcel: Parcel): BreadDataModel {
            return BreadDataModel(parcel)
        }

        override fun newArray(size: Int): Array<BreadDataModel?> {
            return arrayOfNulls(size)
        }
    }
}

