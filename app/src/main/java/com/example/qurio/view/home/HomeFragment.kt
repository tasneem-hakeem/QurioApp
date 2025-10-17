package com.example.qurio.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.qurio.databinding.FragmentHomeBinding
import com.example.qurio.presenter.home.HomePresenter
import com.example.qurio.view.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeView, HomePresenter>(), HomeView {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun initPresenter(): HomePresenter {
        return HomePresenter(this)
    }
}
