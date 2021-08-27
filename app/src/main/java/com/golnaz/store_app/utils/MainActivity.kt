package com.golnaz.store_app.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.golnaz.store_app.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}