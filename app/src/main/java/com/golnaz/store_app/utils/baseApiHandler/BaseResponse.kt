package com.golnaz.store_app.utils.baseApiHandler

open class BaseResponse (

    var statusCode: Int? = null,
    var success: Boolean = false,
    var message: String? = null
)