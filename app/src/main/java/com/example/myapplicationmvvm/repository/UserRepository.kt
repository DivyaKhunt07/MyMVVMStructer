package com.example.myapplicationmvvm.repository

import com.example.myapplicationmvvm.data.User
import com.example.myapplicationmvvm.data.UserDao

class UserRepository(private val userDao: UserDao) {
    
    suspend fun login(username: String, password: String): User? {
        return userDao.login(username, password)
    }
    
    suspend fun register(user: User) {
        userDao.insertUser(user)
    }
    
    suspend fun checkUserExists(username: String): Boolean {
        return userDao.getUserByUsername(username) != null
    }
}