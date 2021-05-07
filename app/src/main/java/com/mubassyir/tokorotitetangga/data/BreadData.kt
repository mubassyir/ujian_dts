package com.mubassyir.tokorotitetangga.data

import com.mubassyir.tokorotitetangga.R
import com.mubassyir.tokorotitetangga.model.BreadDataModel

object BreadData {
    fun breadData():List<BreadDataModel>{
        val bakeData = ArrayList<BreadDataModel>()

        bakeData.add(BreadDataModel("Roti Tawar", "https://res.cloudinary.com/ds32s8wd4/image/upload/v1620314945/bread1_oxr6nh.jpg","20000"))
        bakeData.add(BreadDataModel("Roti isi daging","https://res.cloudinary.com/ds32s8wd4/image/upload/v1620314943/bread3_ifdju3.jpg","20000"))
        bakeData.add(BreadDataModel("Roti pistacos","https://res.cloudinary.com/ds32s8wd4/image/upload/v1620314943/bread4_tsngxo.jpg","20000"))
        bakeData.add(BreadDataModel("Roti","https://res.cloudinary.com/ds32s8wd4/image/upload/v1620314943/bread5_at3jeq.jpg","20000"))
        bakeData.add(BreadDataModel("Roti kita besama","https://res.cloudinary.com/ds32s8wd4/image/upload/v1620314943/bread2_ewqgiq.jpg","20000"))
        return  bakeData
    }
}