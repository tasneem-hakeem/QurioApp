package com.example.qurio.view.base

abstract class BasePresenter<VIEW : BaseView>(protected var view: VIEW? = null) {

    fun clear() {

    }
}