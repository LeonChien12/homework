package com.leon.homework.data.api

import com.leon.homework.data.model.LoginRequest
import com.leon.homework.data.model.LoginResponse
import com.leon.homework.data.model.TimeZoneRequest
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface AccountService {
    @Headers(
        "Content-Type: application/json",
    )
    @POST("login")
    suspend fun login(
        @Header("X-Parse-Application-Id") applicationId: String,
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @Headers(
        "Content-Type: application/json",
    )
    @PUT("users/{objectId}")
    suspend fun updateTimeZone(
        @Header("X-Parse-Application-Id") applicationId: String,
        @Header("X-Parse-Session-Token") token: String,
        @Path("objectId") objectId: String,
        @Body request: TimeZoneRequest
    ): Response<ResponseBody>

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