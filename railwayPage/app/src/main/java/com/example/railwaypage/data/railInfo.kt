package com.example.railwaypage.data

import androidx.annotation.StringRes
import com.example.railwaypage.R

data class Rail(
    @StringRes val nameRes: Int,
    @StringRes val avCoal: Int,
    @StringRes val neLo: Int
)

val request = listOf(

    Rail(
        nameRes = R.string.name1,
        avCoal = R.string.coal1,
        neLo = R.string.siding1
    ),

    Rail(
        nameRes = R.string.name2,
        avCoal = R.string.coal2,
        neLo = R.string.siding2
    ),

    Rail(
        nameRes = R.string.name3,
        avCoal = R.string.coal3,
        neLo = R.string.siding3
    ),
)