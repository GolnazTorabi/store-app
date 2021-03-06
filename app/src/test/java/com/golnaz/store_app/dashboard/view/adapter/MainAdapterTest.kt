package com.golnaz.store_app.dashboard.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.golnaz.store_app.dashboard.domain.model.AppData
import com.nhaarman.mockito_kotlin.spy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule


class MainAdapterTest {
    private lateinit var items: MutableList<AppData>
    lateinit var recyclerView : RecyclerView

    @InjectMocks
    lateinit var mainAdapter: MainAdapter

    @get:Rule
    var mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        recyclerView = Mockito.mock(RecyclerView::class.java)
        items = mutableListOf()
        items.add(0, AppData(appImage = "AIcon", appName = "A", appRate = "1"))
        items.add(1, AppData(appImage = "BIcon", appName = "B", appRate = "2"))
        items.add(2, AppData(appImage = "CIcon", appName = "C", appRate = "3"))
        items.add(3, AppData(appImage = "DIcon", appName = "D", appRate = "4.4"))
        items.add(4, AppData(appImage = "EIcon", appName = "E", appRate = "1.5"))
        mainAdapter = spy(MainAdapter())

    }

    @Test
    fun `Should adapter list size equal to items list`() {
        mainAdapter.fillData(items)
        Assertions.assertEquals(mainAdapter.items.size, items.size)
    }
}