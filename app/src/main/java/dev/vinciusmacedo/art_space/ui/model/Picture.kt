package dev.vinciusmacedo.art_space.ui.model

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Picture(
    val id: Int,
    val title: String,
    val artist: String,
    val year: Int,
   @DrawableRes val img: Int
) {

}