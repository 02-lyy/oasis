package com.example.basemvvm.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.AdaptiveIconDrawable
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.shop.app.Constants
import com.shop.app.MyApp

object ImageLoader {
    //url 图片地址
    fun loadImage(url: String?, img: ImageView?) {
        //用key为image的值的时候来判断当前时无图还有有图模式
        if (SpUtils.instance!!.getBoolean("image") && img != null) {
            Glide.with(MyApp.app!!).load(url).into(img)
        }
    }
}