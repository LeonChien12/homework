package com.leon.homework.ui.viewmodel

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

class AccountViewModel(private val accountRepository: AccountRepository) : ViewModel() {
    private val _emailError = MutableLiveData("")
    val emailError: LiveData<String> = _emailError

    private val _passwordError = MutableLiveData("")
    val passwordError: LiveData<String> = _passwordError

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _loginResult = MutableSharedFlow<LoginResult>()
    val loginResult: SharedFlow<LoginResult> = _loginResult

    fun login(email: String, password: String) {
        if (!isEmailValid(email)) {
            _emailError.value = "Not a valid email"
            return
        } else if (!isPasswordValid(password)) {
            _passwordError.value = "Password must be > 5 characters"
            return
        }

        viewModelScope.launch {
            _isLoading.value = true
            val result = accountRepository.login(email, password)
            _isLoading.value = false
            if (result is HttpResult.Success) {
                _loginResult.emit(LoginResult(isLoginSuccess = result.data.isSuccessful))
            } else {
                _loginResult.emit(LoginResult(errorId = R.string.network_error))
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