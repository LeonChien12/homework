package com.leon.homework.ui.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leon.homework.data.repository.AccountRepository

class AccountViewModel(private val accountRepository: AccountRepository) : ViewModel() {
    private val _emailError = MutableLiveData("")
    val emailError: LiveData<String> = _emailError

    private val _passwordError = MutableLiveData("")
    val passwordError: LiveData<String> = _passwordError

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun login(email: String, password: String) {
        if (!isEmailValid(email)) {
            _emailError.value = "Not a valid email"
            return
        } else if (!isPasswordValid(password)) {
            _passwordError.value = "Password must be > 5 characters"
            return
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}