package com.hamza.bhatti.models


data class ResultResponse(
    val status: String,
    val num_results: Int,
    var results: ArrayList<News> = ArrayList()
)
