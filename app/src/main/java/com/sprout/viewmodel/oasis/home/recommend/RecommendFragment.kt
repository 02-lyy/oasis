package com.sprout.viewmodel.oasis.home.recommend

import com.shop.base.BaseFragment
import com.sprout.R
import com.sprout.databinding.FragmentRecommendBinding

class RecommendFragment : BaseFragment<RecommendViewModel, FragmentRecommendBinding>(R.layout.fragment_recommend,RecommendViewModel::class.java) {

    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { RecommendFragment() }
    }

    override fun initView() {
    }

    override fun initVM() {
    }

    override fun initData() {
    }

    override fun initVariable() {
    }


}