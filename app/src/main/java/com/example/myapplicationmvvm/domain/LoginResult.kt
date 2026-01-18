package com.example.myapplicationmvvm.domain

import com.example.myapplicationmvvm.data.User

sealed class LoginResult {
    data class Success(val user: User) : LoginResult()
    data class Error(val message: String) : LoginResult()
}