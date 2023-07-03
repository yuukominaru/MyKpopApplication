package com.dicoding.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kpop(
    val name: String,
    val description: String,
    val extraDesc: String,
    val photo: Int
) : Parcelable
