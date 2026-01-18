package com.example.myapplicationmvvm.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationmvvm.data.User
import com.example.myapplicationmvvm.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    
    private val _loginResult = MutableLiveData<LoginResult>()

    val loginResult: LiveData<LoginResult> = _loginResult
    
    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                if (username.isBlank() || password.isBlank()) {
                    _loginResult.value = LoginResult.Error("Please fill all fields")
                    return@launch
                }
                
                val user = repository.login(username, password)
                if (user != null) {
                    _loginResult.value = LoginResult.Success(user)
                } else {
                    _loginResult.value = LoginResult.Error("Invalid credentials")
                }
            } catch (e: Exception) {
                _loginResult.value = LoginResult.Error(e.message ?: "Login failed")
            }
        }
    }
    
    fun register(username: String, password: String) {
        viewModelScope.launch {
            try {
                if (username.isBlank() || password.isBlank()) {
                    _loginResult.value = LoginResult.Error("Please fill all fields")
                    return@launch
                }
                
                if (repository.checkUserExists(username)) {
                    _loginResult.value = LoginResult.Error("Username already exists")
                    return@launch
                }
                
                val user = User(username = username, password = password)
                repository.register(user)
                _loginResult.value = LoginResult.Success(user)
            } catch (e: Exception) {
                _loginResult.value = LoginResult.Error(e.message ?: "Registration failed")
            }
        }
    }
}
