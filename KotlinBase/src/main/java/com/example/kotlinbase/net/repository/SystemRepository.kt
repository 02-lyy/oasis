package com.shop.net.repository

import com.shop.api.ServiceApi
import com.shop.net.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 数据仓库
 * 用来连接ViewModel和Model
 * 定义业务相关的网络请求接口的api
 */
class SystemRepository {

    private lateinit var serviceApi: ServiceApi

    //TODO 初始化的方法
    init {
        //在这里调用create 创建ServiceApi进行实例化
        serviceApi = RetrofitFactory.instance.create(ServiceApi::class.java)

    }
}