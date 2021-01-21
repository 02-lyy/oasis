package com.shop.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basemvvm.utils.MyMmkv
import com.shop.app.Constants
import com.shop.net.repository.SystemRepository
import kotlinx.coroutines.launch

open class BaseViewModel(val repository: SystemRepository):ViewModel() {

    /**
     * 定义一个网络请求状态的处理
     */
    protected var status:MutableLiveData<String> = MutableLiveData()

    /**
     * token刷新通知界面的数据状态
     */
    var refreshToken:MutableLiveData<Int> = MutableLiveData()


}