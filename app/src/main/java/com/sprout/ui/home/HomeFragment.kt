package com.sprout.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.shop.base.BaseFragment
import com.sprout.R
import com.sprout.databinding.FragmentHomeBinding
import com.sprout.viewmodel.oasis.home.HomeViewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    R.layout.fragment_home,
    HomeViewModel::class.java
) {

    private val mNames = arrayOf("同城", "关注", "推荐") //tab的导航名字

    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { HomeFragment() }
    }

    override fun initView() {
//        //设置适配器
//        mDataBinding.mVpHome!!.adapter = object : FragmentStatePagerAdapter(childFragmentManager){
//            override fun getCount(): Int {
//                return mViewModel.fragments.size
//            }
//
//            override fun getItem(position: Int): Fragment {
//                return mViewModel.fragments.get(position)
//            }
//
//            override fun getPageTitle(position: Int): CharSequence? {
//                return mNames[position]
//            }
//        }
//        //设置ViewPager和Tab联动
//        mDataBinding!!.mTabHome.setupWithViewPager(mDataBinding!!.mVpHome)

        mDataBinding.homeVp!!.adapter = object : FragmentStatePagerAdapter(childFragmentManager) {
            override fun getCount(): Int {
                return mViewModel.fragments.size
            }

            override fun getItem(position: Int): Fragment {
                return mViewModel.fragments.get(position)
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return mNames[position]
            }
        }
        mDataBinding!!.homeTab.setupWithViewPager(mDataBinding!!.homeVp)
    }

    override fun initVM() {

    }

    override fun initData() {

    }

    override fun initVariable() {

    }
}