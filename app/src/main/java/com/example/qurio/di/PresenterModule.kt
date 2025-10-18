package com.example.qurio.di

import com.example.qurio.presenter.home.HomePresenter
import com.example.qurio.presenter.home.HomePresenterImpl
import dagger.Binds
import dagger.Module

@Module
abstract class PresenterModule {
    @Binds
    abstract fun bindHomePresenter(presenter: HomePresenterImpl): HomePresenter
}