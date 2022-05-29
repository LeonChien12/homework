package com.leon.homework.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leon.homework.data.HttpResult
import com.leon.homework.data.model.News
import com.leon.homework.data.repository.NewsRepository
import kotlinx.coroutines.launch

class ListInfoViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _news = MutableLiveData<List<News>>()
    val news: LiveData<List<News>> = _news

    init {
        viewModelScope.launch {
            when (val result = newsRepository.fetchLatestNews()) {
                is HttpResult.Success -> {
                    _news.value = result.data.news
                }
                is HttpResult.Error -> {
                    // TODO:
                }
            }
        }
    }
}