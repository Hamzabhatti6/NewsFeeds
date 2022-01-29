package com.hamza.bhatti.ui.activities

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hamza.bhatti.R

abstract class BaseActivity: AppCompatActivity() {
    private lateinit var dialogs: Dialog

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

    }

    fun showLoaderDialog()
    {
        dialogs = Dialog(this)
        dialogs.setContentView(R.layout.wheel)
        dialogs.setCancelable(false)
        dialogs.show()

    }

    fun hideLoaderDialog()
    {
        if (::dialogs.isInitialized && dialogs.isShowing)
        {
            dialogs.dismiss()
        }
    }

}