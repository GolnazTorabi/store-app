package com.golnaz.store_app.utils.bindingAdapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter(value = ["imageUrl", "placeHolder"], requireAll = false)
fun ImageView.LoadImageUrl(imageUrl: String?, placeholder: Drawable) {
    Picasso.get()
        .load(imageUrl)
        .placeholder(placeholder)
        .error(placeholder)
        .into(this)
}