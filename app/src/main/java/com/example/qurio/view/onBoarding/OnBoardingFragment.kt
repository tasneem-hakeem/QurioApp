package com.example.qurio.view.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.qurio.databinding.FragmentOnboardingBinding
import com.example.qurio.presenter.onBoarding.OnBoardingPresenter
import com.example.qurio.view.base.BaseFragment

class OnBoardingFragment :
    BaseFragment<FragmentOnboardingBinding, OnBoardingView, OnBoardingPresenter>(),
    OnBoardingView {

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOnboardingBinding {
        return FragmentOnboardingBinding.inflate(inflater, container, false)
    }

    override fun initPresenter(): OnBoardingPresenter {
        return OnBoardingPresenter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onStart()
    }

    override fun onClickNext() {
        binding.button.setOnClickListener {
            findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToHomeFragment())
        }
    }
}