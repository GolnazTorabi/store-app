package com.golnaz.store_app.dashboard.data.api

import com.golnaz.store_app.dashboard.data.response.ResponseApplications
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api_list/listApps")
    fun getApplicationsList(@Query("offset") offset: String? = null): Single<ResponseApplications>
}