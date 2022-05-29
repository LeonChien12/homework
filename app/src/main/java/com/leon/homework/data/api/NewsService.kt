package com.leon.homework.data.api

import com.leon.homework.data.model.NewsResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface NewsService {

    @GET("news.json")
    suspend fun fetchLatestNews(): Response<NewsResponse>

    companion object {
        private const val NEWS_URL = "https://tcgbusfs.blob.core.windows.net/dotapp/"

        fun create(): NewsService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(NEWS_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(NewsService::class.java)
        }
    }
}