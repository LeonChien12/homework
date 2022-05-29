package com.leon.homework.data.source

import com.leon.homework.data.api.NewsService
import com.leon.homework.data.model.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class NewsRemoteDataSource(private val newsService: NewsService) {
    suspend fun fetchLatestNews(): Response<NewsResponse> {
        return withContext(Dispatchers.IO) {
            newsService.fetchLatestNews()
        }
    }
}