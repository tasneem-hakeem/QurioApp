package com.example.qurio.di

import com.example.qurio.model.QurioRepositoryImpl
import com.example.qurio.model.remote.QurioRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindQurioRepository(
        qurioRepositoryImpl: QurioRepositoryImpl
    ): QurioRepository

}