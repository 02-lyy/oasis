package com.sprout.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.shop.base.BaseActivity
import com.sprout.R
import com.sprout.databinding.ActivityHomeBinding
import com.sprout.viewmodel.oasis.OasisViewModel

//TODO 绿洲搭建页面
//class OasisActivity : BaseActivity<OasisViewModel, ActivityOasisBinding>
//    (R.layout.activity_oasis, OasisViewModel::class.java), View.OnClickListener {

class HomeActivity : BaseActivity<OasisViewModel, ActivityHomeBinding>
    (R.layout.activity_home, OasisViewModel::class.java), View.OnClickListener {

    private lateinit var mFm: FragmentManager

    override fun initView() {
        initListener()
        initFragment()
    }

    private fun initFragment() {

        mFm = supportFragmentManager
        //放入布局管理器
        mFm.beginTransaction()
            .add(R.id.mRl_oasis, mViewModel.fragments.get(0))
            .add(R.id.mRl_oasis, mViewModel.fragments.get(1))
            .add(R.id.mRl_oasis, mViewModel.fragments.get(2))
            .add(R.id.mRl_oasis, mViewModel.fragments.get(3))
            .hide(mViewModel.fragments.get(1))
            .hide(mViewModel.fragments.get(2))
            .hide(mViewModel.fragments.get(3))
            .commit();//提交事物
    }

    private fun initListener() {
        mDataBinding.layoutHome.setOnClickListener(this)
        mDataBinding.layoutSearch.setOnClickListener(this)
        mDataBinding.layoutIssue.setOnClickListener(this)
        mDataBinding.layoutInfo.setOnClickListener(this)
        mDataBinding.layoutMe.setOnClickListener(this)

    }

    override fun initVM() {

    }

    override fun initData() {

    }

    override fun initVariable() {

    }

    override fun onClick(view: View?) {
       //开启事物
        val t1 = mFm.beginTransaction()
        resetImg()//重置所有属性
        when (view!!.id) {
            R.id.layout_home -> {
                mDataBinding.ivOasisHomeImg.setImageResource(R.mipmap.main_nav_home_hl)
                t1.show(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(3))
            }
            R.id.layout_search -> {
                mDataBinding.ivOasisSearchImg.setImageResource(R.mipmap.main_nav_discover_hl)
                t1.show(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(3))
            }
            R.id.layout_issue -> {//点击加号跳转
                var intent = Intent(this, IssueActivity::class.java)
                startActivity(intent)
            }
            R.id.layout_info -> {
                mDataBinding.ivOasisInfoImg.setImageResource(R.mipmap.main_nav_message_hl)
                t1.show(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(3))

            }
            R.id.layout_me -> {
                mDataBinding.ivOasisMeImg.setImageResource(R.mipmap.main_nav_mine_hl)
                t1.show(mViewModel.fragments.get(3))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(0))
            }
        }
        t1.commit()
    }
    //TODO 重置所有属性
    private fun resetImg() {
        mDataBinding.ivOasisHomeImg.setImageResource(R.mipmap.main_nav_home_normal)
        mDataBinding.ivOasisSearchImg.setImageResource(R.mipmap.main_nav_discover_normal)
        mDataBinding.ivOasisInfoImg.setImageResource(R.mipmap.main_nav_message_normal)
        mDataBinding.ivOasisMeImg.setImageResource(R.mipmap.main_nav_mine_normal)
    }
}