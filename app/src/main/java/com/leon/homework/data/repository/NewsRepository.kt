package com.leon.homework.data.repository

import com.leon.homework.data.HttpResult
import com.leon.homework.data.model.NewsResponse
import com.leon.homework.data.source.NewsRemoteDataSource
import retrofit2.Response

class NewsRepository(private val newsRemoteDataSource: NewsRemoteDataSource) {
    suspend fun fetchLatestNews(): HttpResult<Response<NewsResponse>> {
        return try {
            val response = newsRemoteDataSource.fetchLatestNews()
            HttpResult.Success(response)
        } catch (e: Exception) {
            HttpResult.Error(e)
        }
    }
}