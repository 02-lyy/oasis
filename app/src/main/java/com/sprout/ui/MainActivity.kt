package com.sprout.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import com.example.basemvvm.utils.SpUtils
import com.sprout.R
import com.sprout.ui.register.RegisterActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_guidance_pop.view.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private var popupWindow: PopupWindow? = null
    private var guidance:String? = null
    private var elselogin:String? = null
    private var thislogin:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        guidance = SpUtils.instance!!.getString("guidance")
        //其他登录
        elselogin = SpUtils.instance!!.getString("elselogin")
        //本地登录
        thislogin = SpUtils.instance!!.getString("thislogin")
        if(!TextUtils.isEmpty(elselogin) && !TextUtils.isEmpty(guidance)){
            initTimer()
        }else if(!TextUtils.isEmpty(thislogin) && !TextUtils.isEmpty(guidance)){
            initTimer()
        }

    }

    private fun initTimer() {
        val subscribe =
            Observable.intervalRange(0, 5, 0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { aLong ->
                    val l = 4 - aLong
                    if (l == 0L) {
                        startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                        finish()
                    }
                }
    }

    //自动弹出pw
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (!TextUtils.isEmpty(guidance)){
            //跳转到注册界面
            initTimerRe()
        }else{
            initPw()
        }
    }

    private fun initPw() {

        val popupView: View = LayoutInflater.from(this)
            .inflate(R.layout.layout_guidance_pop, null)
        //设置popu
        popupWindow = PopupWindow(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        //开启阴影
        val attributes = window.attributes
        attributes.alpha = 0.5f
        window.attributes = attributes
        //找到视图
        popupWindow!!.contentView = popupView
        popupWindow!!.isClippingEnabled = false

        initText(popupView)

        //返回上一页面
        popupView.btn_guidance_no.setOnClickListener {
            popupWindow!!.dismiss()//关闭弹窗
            initPwNo()
            finishAndRemoveTask()
        }

        //进入下一界面
        popupView.btn_guidance_ok.setOnClickListener {
            popupWindow!!.dismiss()//关闭弹窗
            initTimerRe()
            initPwNo()
            val ok = "已经进入过引导页"
            SpUtils.instance!!.setValue("guidance", ok)
        }

        //在按钮的下方弹出  无偏移 第一种方式
        popupWindow!!.showAtLocation(bk_guidance, Gravity.CENTER, 0, 0) //开启弹窗

    }

    fun initText(popupView: View) {
        //富文本
        val spannableString =
            SpannableString("3、你可阅读《用户协议》《隐私条款》了解详细信息，如你[同意]，可点击同意开始接受我们的服务。");
        //起始位置
        var startPos = spannableString.indexOf("《")
        //结束位置
        var endPos = spannableString.lastIndexOf("》") + 1
        spannableString.setSpan(
            ForegroundColorSpan(Color.parseColor("#80A55F")),
            startPos, endPos, Spanned.SPAN_EXCLUSIVE_INCLUSIVE
        )
        //下划线
        val underlineSpan = UnderlineSpan()
        spannableString.setSpan(underlineSpan, 6, 18, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
        //赋值
        popupView.tv_guidance_one.setText("1、为了你的使用体验,缓存图片和视频,降低流量消耗,我们会申请存储权限,同时,为了账号安全,防止被盗,我们会申请系统权限手机设备信息,其他敏感权限如摄像头、麦克风、位置，仅会在使用相关功能时经过明示授权才会开启。")
        popupView.tv_guidance_two.setText("2、绿洲采取严格的数据安全措施保护您的个人信息安全，未经您的同意，我们不会自第三方获取、共享或对外提供你的个人信息，您也可以随时更正或删除您的个人信息。")
        popupView.tv_guidance_three.setText(spannableString)
    }

    //关闭阴影
    fun initPwNo() {
        //关闭阴影
        val attributes = window.attributes
        attributes.alpha = 1f
        window.attributes = attributes
    }

    override fun onPause() {
        super.onPause()
        popupWindow!!.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(popupWindow != null && popupWindow!!.isShowing()){
            popupWindow!!.dismiss()
            popupWindow = null
        }
    }

    private fun initTimerRe() {

        val subscribe =
            Observable.intervalRange(0, 3, 0, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { aLong ->
                    val l = 2 - aLong
                    if (l == 0L) {
                        startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
                        finish()
                    }
                }
    }
}