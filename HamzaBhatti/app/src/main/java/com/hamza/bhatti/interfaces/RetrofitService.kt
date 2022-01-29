package com.hamza.bhatti.interfaces

import com.hamza.bhatti.models.ResultResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface RetrofitService {

    @GET("mostviewed/{section}/{period}.json")
    suspend fun getNews(@Path("section") section: String, @Path("period") period: String,@Query("api-key")  api_key: String): Response<ResultResponse>
}