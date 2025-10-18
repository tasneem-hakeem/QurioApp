package com.example.qurio.di

import android.app.Application
import com.example.qurio.QurioApp
import com.example.qurio.view.home.HomeFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, PresenterModule::class, RepositoryModule::class])
interface AppComponent {
    fun inject(app: QurioApp)
    fun inject(homeFragment: HomeFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}