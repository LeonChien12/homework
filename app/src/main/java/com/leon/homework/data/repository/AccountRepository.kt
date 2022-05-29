package com.leon.homework.data.repository

import com.leon.homework.data.HttpResult
import com.leon.homework.data.model.LoginResponse
import com.leon.homework.data.source.AccountRemoteDataSource

class AccountRepository(private val accountRemoteDataSource: AccountRemoteDataSource) {
    var user: LoginResponse? = null
        private set

    suspend fun login(username: String, password: String): HttpResult<LoginResponse> {
        return try {
            val response = accountRemoteDataSource.login(username, password)
            if (response.isSuccessful) {
                response.body()?.let { loginResponse ->
                    user = loginResponse
                    HttpResult.Success(loginResponse)
                } ?: run {
                    HttpResult.Error(Exception("response.body() is null"))
                }
            } else {
                val errorString = response.errorBody()?.charStream()?.readText()
                HttpResult.Error(Exception(errorString))
            }
        } catch (e: Exception) {
            HttpResult.Error(e)
        }
    }
}