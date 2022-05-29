package com.leon.homework.data.source

import com.leon.homework.data.api.AccountService
import com.leon.homework.data.model.LocalStorage
import com.leon.homework.data.model.LoginRequest
import com.leon.homework.data.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class AccountRemoteDataSource(private val accountService: AccountService, private val localStorage: LocalStorage) {
    suspend fun login(username: String, password: String): Response<LoginResponse> {
        return withContext(Dispatchers.IO) {
            accountService.login(localStorage.APPLICATION_ID, LoginRequest(username, password))
        }
    }
}