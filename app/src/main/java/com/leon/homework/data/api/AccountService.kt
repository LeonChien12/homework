package com.leon.homework.data.api

import com.leon.homework.data.model.LoginRequest
import com.leon.homework.data.model.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface AccountService {
    @Headers(
        "Content-Type: application/json",
    )
    @POST("login")
    suspend fun login(
        @Header("X-Parse-Application-Id") applicationId: String,
        @Body request: LoginRequest
    ): Response<LoginResponse>

    companion object {
        private const val LOGIN_URL = "https://watch-master-staging.herokuapp.com/api/"

        fun create(): AccountService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(LOGIN_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(AccountService::class.java)
        }
    }
}