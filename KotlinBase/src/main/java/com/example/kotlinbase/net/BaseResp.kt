package com.shop.net


//TODO 使用泛型接收不同的对应数据
data class BaseResp<T>
constructor(var errno:Int,var errmsg:String,var data:T)


