package com.sprout.ui.info

import androidx.fragment.app.Fragment


class InfoFragment :Fragment() {
    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { InfoFragment() }
    }
}