package com.golnaz.store_app.dashboard.domain.model.converter

import com.golnaz.store_app.dashboard.data.response.ListItem
import com.golnaz.store_app.dashboard.domain.model.AppData
import com.golnaz.store_app.dashboard.domain.model.mapper.Mapper

class ConvertAppResponseToAppData : Mapper<AppData, ListItem>() {
    override fun map(value: AppData?): ListItem {
        throw UnsupportedOperationException()
    }

    override fun reverseMap(value: ListItem?): AppData? {
        return if (value == null) {
            null
        } else {
            AppData(
                appName = value.name.toString(),
                appRate = value.rating.toString(),
                appImage = value.icon.toString()
            )
        }
    }
}