package com.leon.homework.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(AccountViewModel::class.java) -> AccountViewModel()
                else -> {
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        } as T
}