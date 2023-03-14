package com.samuvlad.tempo.common.extensions


import android.widget.ImageView
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*


fun Long.formatDate(): String{
    val date = Date(this * 1000L)
    val sfd = SimpleDateFormat("HH:mm")
    return sfd.format(date)
}

fun ImageView.load(url: String){
    Glide.with(context).load(url).into(this)
}

