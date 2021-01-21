package com.shop.api

import com.shop.net.BaseResp
import retrofit2.http.POST

interface ServiceApi {
    //刷新token
    @POST("auth/refreshToken")
    suspend fun refreshToken(): BaseResp<String>
}