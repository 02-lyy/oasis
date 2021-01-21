package com.sprout.ui.register

import android.graphics.Color
import android.os.CountDownTimer
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import com.sprout.R

/**
 * @data on 2020/10/16 6:26 PM
 * @auther armstrong
 * @describe 倒计时工具类
 */
class CountDownTimerUtils(
    private val mTextView: TextView,
    millisInFuture: Long,
    countDownInterval: Long
) : CountDownTimer(millisInFuture, countDownInterval) {
    override fun onTick(millisUntilFinished: Long) {
        mTextView.isClickable = false //设置不可点击
        mTextView.text = "重新发送(" + millisUntilFinished / 1000 + ")" //设置倒计时时间
        mTextView.setBackgroundResource(R.drawable.shape_green_lucency_bk_10) //设置按钮为灰色，这时是不能点击的
        val spannableString = SpannableString(mTextView.text.toString()) //获取按钮上的文字
        val span = ForegroundColorSpan(Color.GRAY)
        spannableString.setSpan(
            span,
            0,
            spannableString.length,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        ) //将倒计时的时间设置为红色
        mTextView.text = spannableString
    }

    override fun onFinish() {
        mTextView.text = "获取短信验证码"
        mTextView.isClickable = true //重新获得点击
        mTextView.setBackgroundResource(R.drawable.icon_wow_pay_send_button_normal) //还原背景色
    }
}