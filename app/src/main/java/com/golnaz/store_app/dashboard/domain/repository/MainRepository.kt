package com.golnaz.store_app.dashboard.domain.repository

import com.golnaz.store_app.dashboard.data.response.ResponseApplications
import io.reactivex.Single

interface MainRepository {
    fun getApplicationsList(offset: String? = null): Single<ResponseApplications>
}