package com.leon.homework.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leon.homework.data.api.AccountService
import com.leon.homework.data.api.NewsService
import com.leon.homework.data.model.LocalDataSource
import com.leon.homework.data.repository.AccountRepository
import com.leon.homework.data.repository.NewsRepository
import com.leon.homework.data.source.AccountRemoteDataSource
import com.leon.homework.data.source.NewsRemoteDataSource

class ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(AccountViewModel::class.java) -> AccountViewModel(
                    accountRepository = AccountRepository(
                        accountRemoteDataSource = AccountRemoteDataSource(
                            accountService = AccountService.create()
                        ),
                        localDataSource = LocalDataSource()
                    )
                )
                isAssignableFrom(ListInfoViewModel::class.java) -> ListInfoViewModel(
                    newsRepository = NewsRepository(
                        newsRemoteDataSource = NewsRemoteDataSource(
                            newsService = NewsService.create()
                        )
                    )
                )
                else -> {
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        } as T
}