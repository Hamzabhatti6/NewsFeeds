package com.hamza.bhatti.wrappers

import android.content.Context
import androidx.annotation.StringRes
import com.hamza.bhatti.app.ApplicationClass

open class AppWrapper{
    fun getContext(): Context {
        return ApplicationClass.instance!!
    }
    fun getString(@StringRes stringRes: Int): String {
        return ApplicationClass.instance!!.getString(stringRes)
    }
}