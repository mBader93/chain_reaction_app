package com.example.chainreactionapp.helper

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImageUrl")
fun ImageView.loadImage(url:String?){
    url?.let {
        try {
            Glide.with(this).load(url).into(this)
        }catch (e:Exception){
            e.message
        }
    }
}