package com.leon.homework.data.repository

import com.leon.homework.data.HttpResult
import com.leon.homework.data.model.LoginResponse
import com.leon.homework.data.source.AccountRemoteDataSource
import retrofit2.Response

class AccountRepository(private val accountRemoteDataSource: AccountRemoteDataSource) {
    var user: LoginResponse? = null
        private set

    suspend fun login(username: String, password: String): HttpResult<Response<LoginResponse>> {
        return try {
            val response = accountRemoteDataSource.login(username, password)
            if (response.isSuccessful) {
                user = response.body()
            }
            HttpResult.Success(response)
        } catch (e: Exception) {
            HttpResult.Error(e)
        }
    }
}