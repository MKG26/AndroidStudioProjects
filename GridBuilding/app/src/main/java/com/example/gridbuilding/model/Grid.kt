package com.example.gridbuilding.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Grid(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val numberResourceId: Int,

)
