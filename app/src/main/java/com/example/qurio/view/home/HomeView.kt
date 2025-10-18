package com.example.qurio.view.home

import com.example.qurio.model.entity.Category
import com.example.qurio.view.base.BaseView

interface HomeView: BaseView{
    fun showCategories(categories: List<Category>)
}