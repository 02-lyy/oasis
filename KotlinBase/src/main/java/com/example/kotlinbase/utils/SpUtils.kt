package com.example.basemvvm.utils

import android.content.Context
import com.shop.app.MyApp

class SpUtils {

    private val sp = MyApp.instance!!.getSharedPreferences("chat", Context.MODE_PRIVATE)

    /**
     * 设置数据
     * @param key
     * @param value
     */
    fun setValue(key:String?,value:Any?){
        val editor = sp!!.edit()
        //is类似于Java中的 instanceof 关键字的用法
        //is 运算符可以检查对象是否与特定的类型兼容(兼容：此对象是该类型，或者派生类)
        //同时也用来检查对象（变量）是否属于某数据类型（如Int、String、Boolean等）
        if(value is String){
            //as运算符用于执行引用类型的显式类型转换。如果要转换的类型与指定的类型兼容，转换就会成功进行；
            //如果类型不兼容，使用as?运算符就会返回值null。在Kotlin中，父类是禁止转换为子类型的。
            editor.putString(key,value as String?)
        }else if(value is Int){
            editor.putInt(key,(value as Int?)!!)
        }else if(value is Boolean){
            editor.putBoolean(key,(value as Boolean?)!!)
        }else if(value is Float){
            editor.putFloat(key,(value as Float?)!!)
        }else if(value is Long){
            editor.putLong(key,(value as Long?)!!)
        }
        editor.commit()
    }

    fun getString(key: String?):String?{
        return sp!!.getString(key,"")
    }

    fun getInt(key: String?):Int{
        return sp!!.getInt(key,0)
    }

    fun getBoolean(key: String?):Boolean{
        return sp!!.getBoolean(key,false)
    }

    fun getFloat(key: String?):Float{
        return sp!!.getFloat(key,0f)
    }

    fun getLong(key: String?):Long{
        return sp!!.getLong(key,0)
    }

    /**
     * 删除对应的key
     * @param key
     */
    fun remove(key: String?){
        sp!!.edit().remove(key).commit()
    }

    companion object{
        var instance: SpUtils? = null
            get() {
                if(field == null){
                    synchronized(SpUtils::class.java){
                        if (field == null){
                            field = SpUtils()
                        }
                    }
                }
                return field
            }
        private set
    }

}