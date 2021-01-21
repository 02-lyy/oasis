package com.sprout.viewmodel.oasis.home.attention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shop.base.BaseFragment
import com.sprout.R
import com.sprout.databinding.FragmentAttentionBinding

class AttentionFragment : BaseFragment<AttentionViewModel, FragmentAttentionBinding>(R.layout.fragment_attention,AttentionViewModel::class.java) {
//FragmentAttentionBinding
    companion object {
        val instance by lazy { AttentionFragment() }
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