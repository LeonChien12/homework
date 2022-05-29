package com.leon.homework.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leon.homework.data.HttpResult
import com.leon.homework.data.model.News
import com.leon.homework.data.repository.NewsRepository
import kotlinx.coroutines.launch

class ListInfoViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    val news: MutableLiveData<List<News>> = MutableLiveData()

    fun fetchLatestNews() {
        viewModelScope.launch {
            val result = newsRepository.fetchLatestNews()

            if (result is HttpResult.Success) {
                news.value = result.data.body()?.news
            }
        }
    }
}