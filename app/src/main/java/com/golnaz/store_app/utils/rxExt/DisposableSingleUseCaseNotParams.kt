package com.golnaz.store_app.utils.rxExt

import com.golnaz.store_app.utils.baseApiHandler.BaseResponse
import com.golnaz.store_app.utils.baseApiHandler.RetrofitException
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class DisposableSingleUseCase<T> {
    internal abstract fun buildUseCaseSingle(): Single<T>

    fun execute(
        onSuccess: ((t: T) -> Unit),
        onError: ((t: BaseResponse) -> Unit),
        onFinish: () -> Unit = {}
    ) {
        buildUseCaseSingle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate(onFinish)
            .subscribe(object : DisposableSingleObserver<T>() {
                override fun onSuccess(t: T) {
                    onSuccess(t)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    if (e is RetrofitException) {
                        val error: RetrofitException = e
                        val baseResponse = error.getErrorBodyAs(BaseResponse::class.java)
                        onError(baseResponse)
                    } else {
                        onError(BaseResponse(500, false, "try again."))
                    }
                }
            })


    }
}