package com.hamza.bhatti.repo

import android.content.Context
import com.google.gson.GsonBuilder
import com.hamza.bhatti.interfaces.RetrofitService
import com.hamza.bhatti.networks.NetworkConnectionInterceptor
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import java.util.concurrent.TimeUnit

class Repository(var context: Context) {

    private val BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/"
    private var retrofitService: RetrofitService

    init {

        retrofitService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient(provideLoggingInterceptor()))
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RetrofitService::class.java)



    }

    private fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(NetworkConnectionInterceptor(context))
            .retryOnConnectionFailure(true)
            .build()
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }

    suspend fun callGetNews(section: String, period: String, apiKey: String) = retrofitService.getNews(section,period,apiKey)

}