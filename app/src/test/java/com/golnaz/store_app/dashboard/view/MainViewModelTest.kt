package com.golnaz.store_app.dashboard.view

import com.golnaz.store_app.dashboard.data.response.*
import com.golnaz.store_app.dashboard.domain.model.AppData
import com.golnaz.store_app.dashboard.domain.repository.MainRepository
import com.golnaz.store_app.dashboard.domain.usecase.GetApplicationsListUseCase
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule


class MainViewModelTest {
    private lateinit var getApplicationsListUseCase: GetApplicationsListUseCase
    private lateinit var mainViewModel: MainViewModel
    private lateinit var appData: MutableList<AppData>
    private lateinit var responseApplications: MutableList<ListItem>
    private lateinit var response: ResponseApplications

    @Mock
    lateinit var repository: MainRepository

    @get:Rule
    var mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setUpScheduler() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Before
    fun setData() {
        appData = mutableListOf()
        appData.add(0, AppData("FaceBook", "4.4", "facebookImage"))
        appData.add(1, AppData("Telegram", "4.6", "telegramImage"))
        appData.add(2, AppData("Twitter", "4.5", "twitterImage"))

        responseApplications = mutableListOf()
        responseApplications.add(
            0,
            ListItem(name = "FaceBook", rating = 4.4F, icon = "facebookImage")
        )
        responseApplications.add(
            1,
            ListItem(name = "Telegram", rating = 4.4F, icon = "telegramImage")
        )
        responseApplications.add(
            2,
            ListItem(name = "Twitter", rating = 4.4F, icon = "twitterImage")
        )
        responseApplications.add(
            3,
            ListItem(name = "FaceBook", rating = 4.4F, icon = "facebookImage")
        )
        response = ResponseApplications(
            Responses(
                ListApps(
                    Datasets(
                        All(Data(list = responseApplications))
                    )
                )
            )
        )
        whenever(repository.getApplicationsList()).thenReturn(Single.just(response))

        getApplicationsListUseCase = GetApplicationsListUseCase(repository)
        mainViewModel = MainViewModel(getApplicationsListUseCase)
    }

    @Test
    fun `Should return false when the size of responseList in not equal to Converter list`() {
        mainViewModel.getData()
        Assertions.assertEquals(appData.size, responseApplications.size)
    }

    @Test
    fun `Should return true when the first items name is equal`() {
        mainViewModel.getData()
        Assertions.assertEquals(appData[0].appName, responseApplications[0].name)
    }

    @Test
    fun `Should return error when all apps list  size is bigger than 10`() {
        mainViewModel.getData()
        Assertions.assertTrue(mainViewModel.allAppList.value?.size ?: 0 <= 10)
    }


}