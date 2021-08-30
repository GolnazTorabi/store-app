package com.golnaz.store_app.dashboard.view


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.golnaz.store_app.dashboard.data.response.ListItem
import com.golnaz.store_app.dashboard.domain.model.AppData
import com.golnaz.store_app.dashboard.domain.model.converter.ConvertAppResponseToAppData
import com.golnaz.store_app.dashboard.domain.usecase.GetApplicationsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
@HiltViewModel
class MainViewModel @Inject constructor(private val getApplicationsListUseCase: GetApplicationsListUseCase) :
    ViewModel() {

    private var _allAppList = MutableLiveData<List<AppData>>()
    val allAppList: LiveData<List<AppData>> get() = _allAppList

    private var _mostPopularList = MutableLiveData<List<AppData>>()
    val mostPopularList: LiveData<List<AppData>> get() = _mostPopularList

    private var _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> get() = _progress

    val error = MutableLiveData<String?>()

    fun getData() {
        _progress.value = true
        getApplicationsListUseCase.execute(
            onSuccess = { data ->
                _progress.value = false
                mapData(data.responses?.listApps?.datasets?.all?.data?.list)
            },
            onError = {
                Log.d("TAG", "getData: ${it.statusCode}")
                _progress.value = false
                error.value = it.message
            },
            onFinish = {}
        )
    }

    private fun mapData(data: List<ListItem?>?) {
        val allData: MutableList<AppData> = if (data?.size ?: 0 > 10) {
            ConvertAppResponseToAppData().reverseMap(data?.subList(0, 10))
        } else {
            ConvertAppResponseToAppData().reverseMap(data)
        }
        if (allData != _allAppList) {
            _allAppList.value = allData
            val mostAppList = handleMostPopular(data)
            _mostPopularList.value = if (mostAppList.size > 10) {
                mostAppList.subList(0, 10)
            } else {
                mostAppList
            }
        }
    }

    private fun handleMostPopular(data: List<ListItem?>?): MutableList<AppData> {
        val mostAppList: MutableList<AppData> = mutableListOf()
        for (i in 0 until data?.size!!) {
            Log.d("TAG", "mapData: " + data[i]?.rating?.compareTo(4.5))
            if (data[i]?.downloads ?: 0 > 100 && data[i]?.rating?.compareTo(4.5) ?: 0 > 0) {
                mostAppList.add(
                    AppData(
                        data[i]?.name.toString(),
                        data[i]?.rating.toString(), data[i]?.icon.toString()
                    )
                )
            }
        }
        return mostAppList
    }


}

