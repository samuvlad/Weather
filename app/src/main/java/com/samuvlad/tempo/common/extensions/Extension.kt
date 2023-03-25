package com.samuvlad.tempo.common.extensions


import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
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

inline fun <T> Flow<T>.observe(owner: LifecycleOwner, crossinline collect: (T) -> Unit){
    owner.lifecycleScope.launch {
        owner.repeatOnLifecycle(Lifecycle.State.STARTED){
            this@observe.collect{
                collect(it)
            }
        }
    }
}

