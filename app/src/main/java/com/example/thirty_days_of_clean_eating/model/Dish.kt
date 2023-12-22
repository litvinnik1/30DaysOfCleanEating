package com.example.thirty_days_of_clean_eating.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Dish(
    @StringRes val dishNumber:Int,
    @StringRes val dishName:Int,
    @DrawableRes val dishImage:Int,
    @StringRes val dishDescription:Int
)
