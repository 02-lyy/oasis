package com.example.basemvvm.utils

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager : ViewPager {
    private var isCanScroll = true

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    fun setScanScroll(isCanScroll: Boolean) {
        this.isCanScroll = isCanScroll
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return if (isCanScroll) {
            false
        } else {
            super.onInterceptTouchEvent(ev)
        }
    }

    /**
     * 是否消费事件
     * 消费:事件就结束
     * 不消费:往父控件传
     */
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return if (isCanScroll) {
            false
        } else {
            super.onTouchEvent(ev)
        }
    }

    override fun setCurrentItem(item: Int) {
        super.setCurrentItem(item, false)
    }
}