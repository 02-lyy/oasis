package com.sprout.ui.register

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText

/**
 * 验证码
 */
class MyEditText : AppCompatEditText {
    private var lastTime: Long = 0

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!, attrs, defStyleAttr
    ) {
    }

    override fun onSelectionChanged(selStart: Int, selEnd: Int) {
        super.onSelectionChanged(selStart, selEnd)
        this.setSelection(this.text!!.length)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                val currentTime = System.currentTimeMillis()
                if (currentTime - lastTime < 500) {
                    lastTime = currentTime
                    return true
                } else {
                    lastTime = currentTime
                }
            }
        }
        return super.onTouchEvent(event)
    }
}