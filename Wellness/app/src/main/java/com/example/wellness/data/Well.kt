package com.example.wellness.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.wellness.R

data class Well(

    @StringRes val nameRes: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val descriptionRes: Int
)

val wellness = listOf(
        Well(
            nameRes = R.string.name1,
            imageRes = R.drawable.outdoor,
            descriptionRes = R.string.description1
        ),

        Well(
        nameRes = R.string.name2,
        imageRes = R.drawable.podcast,
        descriptionRes = R.string.description2
    ),

        Well(
        nameRes = R.string.name3,
        imageRes = R.drawable.gym,
        descriptionRes = R.string.description3
    )
)