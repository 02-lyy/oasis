package com.sprout.ui.search

import androidx.fragment.app.Fragment
import com.sprout.ui.me.MeFragment

class SearchFragment:Fragment() {
    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { SearchFragment() }
    }
}