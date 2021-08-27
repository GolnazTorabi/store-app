package com.golnaz.store_app.utils.repositoryModue

import com.golnaz.store_app.dashboard.data.repository.MainRepositoryImpl
import com.golnaz.store_app.dashboard.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCountriesRepository(repo: MainRepositoryImpl): MainRepository = repo
}