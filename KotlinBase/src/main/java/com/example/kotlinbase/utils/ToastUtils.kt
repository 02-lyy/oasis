package com.example.basemvvm.utils

import android.content.Context
import android.widget.Toast

object ToastUtils {
    @JvmStatic
    fun s(context: Context, s: String?) {
        if (!isShowToast) {
            Toast.makeText(context.applicationContext, s, Toast.LENGTH_SHORT)
                    .show()
        }
    }

    /**
     * Prevent continuous click, jump two pages
     */
    private var lastToastTime: Long = 0
    private const val TIME: Long = 1500
    val isShowToast: Boolean
        get() {
            val time = System.currentTimeMillis()
            if (time - lastToastTime < TIME) {
                return true
            }
            lastToastTime = time
            return false
        }
}