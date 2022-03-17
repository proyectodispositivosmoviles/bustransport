package com.ricaurte.bustransport.local.repository

import com.ricaurte.bustransport.Bustransport
import com.ricaurte.bustransport.local.User
import com.ricaurte.bustransport.local.UserDao
import java.sql.Types.NULL

class UserRepository {
    suspend fun saveuser(
        name: String,
        phone: String,
        email: String,
        password: String) {
        val user = User(
            id = NULL,
            name = name,
            phone = phone,
            email = email,
            password = password

        )
        val userdao: UserDao = Bustransport.database.UserDao()
        userdao.saveuser(user)
    }

    suspend fun searchUser(User: String): User {
        val userDao: UserDao = Bustransport.database.UserDao()
        val user = userDao.searchuser(User)
        return user


    }
}





