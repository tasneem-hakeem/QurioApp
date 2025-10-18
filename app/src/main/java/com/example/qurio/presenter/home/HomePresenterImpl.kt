package com.example.qurio.presenter.home

import android.util.Log
import com.example.qurio.model.remote.QurioRepository
import com.example.qurio.view.base.BasePresenter
import com.example.qurio.view.home.HomeView
import javax.inject.Inject

class HomePresenterImpl @Inject constructor(
    private val model: QurioRepository
) : BasePresenter<HomeView>(), HomePresenter {

    override fun loadCategories() {
        Log.d("HomePresenterImpl", "loadCategories called")
        tryToExecute(
            function = {
                Log.d("HomePresenterImpl", "function called")
                model.getCategories()
            },
            onSuccess = { categories ->
                Log.d("HomePresenterImpl", "loadCategories: $categories")
                view?.showCategories(categories)
            },
            onError = {
                Log.d("HomePresenterImpl", "OnError: $it")
            }
        )
    }
}