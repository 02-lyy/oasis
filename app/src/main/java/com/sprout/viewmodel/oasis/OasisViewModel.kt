package com.sprout.viewmodel.oasis

import androidx.fragment.app.Fragment
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.sprout.ui.home.HomeFragment
import com.sprout.ui.info.InfoFragment
import com.sprout.ui.me.MeFragment
import com.sprout.ui.search.SearchFragment

class OasisViewModel: BaseViewModel(Injection.repository) {
    var fragments:MutableList<Fragment> = mutableListOf()

    //添加进入集合
    init {
        fragments.add(HomeFragment.instance)
        fragments.add(SearchFragment.instance)
        fragments.add(InfoFragment.instance)
        fragments.add(MeFragment.instance)
    }

}