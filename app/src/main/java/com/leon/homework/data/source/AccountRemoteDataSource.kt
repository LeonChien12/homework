package com.leon.homework.data.source

import com.leon.homework.data.api.AccountService
import com.leon.homework.data.model.LoginRequest
import com.leon.homework.data.model.LoginResponse
import com.leon.homework.data.model.TimeZoneRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response

class AccountRemoteDataSource(private val accountService: AccountService) {
    suspend fun login(
        applicationId: String,
        username: String,
        password: String
    ): Response<LoginResponse> {
        return withContext(Dispatchers.IO) {
            accountService.login(applicationId, LoginRequest(username, password))
        }
    }

    suspend fun updateTimezone(
        applicationId: String,
        token: String,
        objectId: String,
        request: TimeZoneRequest
    ): Response<ResponseBody> {
        return withContext(Dispatchers.IO) {
            accountService.updateTimeZone(applicationId, token, objectId, request)
        }
    }
}