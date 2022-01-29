package com.hamza.bhatti.utilities

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.hamza.bhatti.R
import com.hamza.bhatti.adapters.GenericRecyclerViewAdapter
import com.hamza.bhatti.ui.activities.MainActivity
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject
import java.util.ArrayList

class UtilityFunctions {
    fun <T> genericAdapter(
        recyclerView: RecyclerView,
        items: ArrayList<T>,
        layoutId: Int,
        type: String
    ) {
        val adapter = GenericRecyclerViewAdapter(recyclerView.context, items, layoutId, type)
        recyclerView.adapter = adapter
    }

     fun createJsonRequestBody(vararg params: Pair<String, String>) =
        RequestBody.create(
            "application/json; charset=utf-8".toMediaTypeOrNull(),
            JSONObject(mapOf(*params)).toString()
        )

}