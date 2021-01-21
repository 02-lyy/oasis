package com.sprout.ui.issue

import androidx.fragment.app.Fragment
import com.sprout.ui.info.InfoFragment

class issueFragment:Fragment() {

    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { issueFragment() }
    }

}

