package com.example.basemvvm.mvvm

interface IBaseView {

    fun showLoading()
    /**
     * 显示提示信息
     */
    fun showTips(tips:String)

}