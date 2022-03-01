package com.ricaurte.bustransport.local

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    suspend fun saveuser(user: User)

    @Query("SELECT * FROM table_user WHERE email LIKE :email")
    suspend fun searchuser(email: String): User



}