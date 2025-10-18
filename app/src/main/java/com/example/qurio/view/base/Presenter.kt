package com.example.qurio.view.base

interface Presenter<V : BaseView> {
    fun attachView(view: V)
    fun detachView()
    fun onDestroy()
}