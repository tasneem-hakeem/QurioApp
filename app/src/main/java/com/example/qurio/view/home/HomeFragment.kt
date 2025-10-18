package com.example.qurio.view.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qurio.QurioApp
import com.example.qurio.databinding.FragmentHomeBinding
import com.example.qurio.model.entity.Category
import com.example.qurio.presenter.home.HomePresenter
import com.example.qurio.presenter.home.HomePresenterImpl
import com.example.qurio.view.base.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeView, HomePresenterImpl>(),
    HomeView {
    @Inject
    lateinit var presenter: HomePresenter

    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as QurioApp).appComponent.inject(this)
        presenter.attachView(this)
    }

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        categoryAdapter = CategoryAdapter(emptyList()) {

        }

        binding.categoriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }
        presenter.loadCategories()
    }

    override fun showCategories(categories: List<Category>) {
        categoryAdapter.categories = categories
        Log.d("TAG", "showCategories: $categories")
        categoryAdapter.notifyDataSetChanged()
    }
}