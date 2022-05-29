package com.leon.homework.ui.viewmodel

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leon.homework.R
import com.leon.homework.data.HttpResult
import com.leon.homework.data.repository.AccountRepository
import com.leon.homework.ui.LoginResult
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import java.io.IOException

class AccountViewModel(private val accountRepository: AccountRepository) : ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _loginResult = MutableSharedFlow<LoginResult>()
    val loginResult: SharedFlow<LoginResult> = _loginResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            if (!isEmailValid(email)) {
                _loginResult.emit(LoginResult(emailErrorId = R.string.invalid_email))
                return@launch
            } else if (!isPasswordValid(password)) {
                _loginResult.emit(LoginResult(passwordErrorId = R.string.invalid_password))
                return@launch
            }

            _isLoading.value = true
            val result = accountRepository.login(email, password)
            _isLoading.value = false
            when (result) {
                is HttpResult.Success -> {
                    _loginResult.emit(LoginResult(isLoginSuccess = true))
                }
                is HttpResult.Error -> {
                    when (result.throwable) {
                        is IOException -> {
                            _loginResult.emit(LoginResult(errorId = R.string.network_error))
                        }
                        else -> {
                            _loginResult.emit(LoginResult(errorId = R.string.login_failed))
                        }
                    }
                }
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}