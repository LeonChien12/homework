package com.leon.homework.data.source

import com.leon.homework.data.api.AccountService
import com.leon.homework.data.model.LocalStorage
import com.leon.homework.data.model.LoginRequest
import com.leon.homework.data.model.LoginResponse
import com.leon.homework.data.model.TimeZoneRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response

class AccountRemoteDataSource(private val accountService: AccountService, private val localStorage: LocalStorage) {
    suspend fun login(username: String, password: String): Response<LoginResponse> {
        return withContext(Dispatchers.IO) {
            accountService.login(localStorage.APPLICATION_ID, LoginRequest(username, password))
        }
    }

    suspend fun updateTimezone(
        token: String,
        objectId: String,
        request: TimeZoneRequest
    ): Response<ResponseBody> {
        return withContext(Dispatchers.IO) {
            accountService.updateTimeZone(localStorage.APPLICATION_ID, token, objectId, request)
        }
    }

    suspend fun getTimeZoneIDs(): List<String> {
        return withContext(Dispatchers.IO) {
            localStorage.getIANATimeZoneIDs
        }
    }
}