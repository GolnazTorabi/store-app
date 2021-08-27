package com.golnaz.store_app.dashboard.domain.usecase

import com.golnaz.store_app.dashboard.data.response.ResponseApplications
import com.golnaz.store_app.dashboard.domain.repository.MainRepository
import com.golnaz.store_app.utils.rxExt.DisposableSingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetApplicationsListUseCase @Inject constructor(private val mainRepository: MainRepository) :
    DisposableSingleUseCase<ResponseApplications>() {
    override fun buildUseCaseSingle(): Single<ResponseApplications> {
        return mainRepository.getApplicationsList()
    }
}