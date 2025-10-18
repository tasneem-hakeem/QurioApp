package com.example.qurio.presenter.home

import com.example.qurio.view.base.Presenter
import com.example.qurio.view.home.HomeView

interface HomePresenter: Presenter<HomeView> {
    fun loadCategories()
}