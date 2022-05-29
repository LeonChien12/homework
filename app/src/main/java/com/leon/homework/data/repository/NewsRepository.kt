package com.leon.homework.data.repository

import com.leon.homework.data.HttpResult
import com.leon.homework.data.model.NewsResponse
import com.leon.homework.data.source.NewsRemoteDataSource
import retrofit2.Response

class NewsRepository(private val newsRemoteDataSource: NewsRemoteDataSource) {
    suspend fun fetchLatestNews(): HttpResult<NewsResponse> {
        return try {
            val response = newsRemoteDataSource.fetchLatestNews()
            if (response.isSuccessful) {
                response.body()?.let { newsResponse ->
                    HttpResult.Success(newsResponse)
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