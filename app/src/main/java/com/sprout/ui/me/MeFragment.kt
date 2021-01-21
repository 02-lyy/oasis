package com.sprout.ui.me

import androidx.fragment.app.Fragment
import com.sprout.ui.issue.issueFragment

class MeFragment :Fragment(){
    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { MeFragment() }
    }
}