package com.shop.app

import android.app.Application
import android.content.Context
import com.example.basemvvm.utils.MyMmkv
import java.util.*

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        app = this
        map = HashMap()
        MyMmkv.initMMKV()
    }

    companion object{
        var instance: MyApp? = null
        @JvmField
        var app: MyApp? = null
        @JvmStatic
        var map: java.util.HashMap<String, Any>? = null
    }

}