package com.samuvlad.tempo.ui.home

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.samuvlad.tempo.common.extensions.formatDate


@SuppressLint("SetTextI18n")
@BindingAdapter("formatwindSpeed")
fun TextView.formatwindSpeed(speed: Float){
    this.text = "$speed km/h"
}

@BindingAdapter("formatLongDate")
fun TextView.formatLongDate(date: Long){
    this.text = date.formatDate()
}


@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, url: String?){
    url.let { Glide.with(imageView.context).load(url).into(imageView) }
}