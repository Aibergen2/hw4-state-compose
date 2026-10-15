package com.example.artspace
import androidx.annotation.DrawableRes

data class Artwork(
    @DrawableRes val imageRes: Int,
    val title: String,
    val artist: String
)