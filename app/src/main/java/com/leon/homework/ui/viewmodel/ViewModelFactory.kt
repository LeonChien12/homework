package com.leon.homework.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leon.homework.data.api.AccountService
import com.leon.homework.data.repository.AccountRepository
import com.leon.homework.data.source.AccountRemoteDataSource

class ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(AccountViewModel::class.java) -> AccountViewModel(
                    accountRepository = AccountRepository(
                        accountRemoteDataSource = AccountRemoteDataSource(
                            accountService = AccountService.create()
                        )
                    )
                )
                else -> {
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        } as T
}