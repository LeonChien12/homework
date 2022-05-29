package com.leon.homework.data.repository

import com.leon.homework.data.HttpResult
import com.leon.homework.data.model.LoginResponse
import com.leon.homework.data.model.TimeZoneRequest
import com.leon.homework.data.source.AccountRemoteDataSource
import okhttp3.ResponseBody

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

    suspend fun updateTimeZone(timezone: String): HttpResult<ResponseBody> {
        return try {
            user?.let { loggedInResponse ->
                val response = accountRemoteDataSource.updateTimezone(
                    loggedInResponse.sessionToken,
                    loggedInResponse.objectId,
                    TimeZoneRequest(timezone)
                )

                if (response.isSuccessful) {
                    response.body()?.let { responseBody ->
                        HttpResult.Success(responseBody)
                    } ?: run {
                        HttpResult.Error(Exception("response.body() is null"))
                    }
                } else {
                    val errorString = response.errorBody()?.charStream()?.readText()
                    HttpResult.Error(Exception(errorString))
                }
            } ?: run {
                HttpResult.Error(Exception("user is null"))
            }
        } catch (e: Exception) {
            HttpResult.Error(e)
        }
    }

    suspend fun getTimeZoneIDs(): List<String> = accountRemoteDataSource.getTimeZoneIDs()
}