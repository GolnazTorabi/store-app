package com.golnaz.store_app.dashboard.data.repository

import com.golnaz.store_app.dashboard.data.api.ApiInterface
import com.golnaz.store_app.dashboard.data.response.ResponseApplications
import com.golnaz.store_app.dashboard.domain.repository.MainRepository
import io.reactivex.Single
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface) :
    MainRepository {
    override fun getApplicationsList(offset: String?): Single<ResponseApplications> {
        return apiInterface.getApplicationsList(offset)
    }
}