package com.sprout.viewmodel.oasis.home

import androidx.fragment.app.Fragment
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.sprout.viewmodel.oasis.home.attention.AttentionFragment
import com.sprout.viewmodel.oasis.home.local.LocalFragment
import com.sprout.viewmodel.oasis.home.recommend.RecommendFragment

class HomeViewModel: BaseViewModel(Injection.repository) {

    var fragments:MutableList<Fragment> = mutableListOf()

    //添加进入集合
    init {
        fragments.add(AttentionFragment.instance)
        fragments.add(RecommendFragment.instance)
        fragments.add(LocalFragment.instance)
    }

}