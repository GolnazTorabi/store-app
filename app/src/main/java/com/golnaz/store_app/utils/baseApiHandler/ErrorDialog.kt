package com.golnaz.store_app.utils.baseApiHandler

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDialog
import androidx.databinding.DataBindingUtil
import com.golnaz.store_app.R
import com.golnaz.store_app.databinding.DialogApiErrorBinding
import dagger.hilt.android.qualifiers.ApplicationContext

class ErrorDialog constructor(
    context: Context,
    private val alertDialog: AlertDialog,
) : AppCompatDialog(context) {
    private var _binding: DialogApiErrorBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        _binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_api_error,
            null,
            false
        )
        setContentView(binding.root)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        binding.dialogPositive.setOnClickListener {
            alertDialog.positive()
            dismiss()
        }
        binding.dialogNegative.setOnClickListener {
            dismiss()
        }
    }

    interface AlertDialog {
        fun positive()
    }
}