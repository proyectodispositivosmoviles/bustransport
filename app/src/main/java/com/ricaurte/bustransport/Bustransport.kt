package com.ricaurte.bustransport

import android.app.Application
import androidx.room.Room
import com.ricaurte.bustransport.local.UserDatabase

class Bustransport: Application() {

    companion object {
        lateinit var database: UserDatabase
    }
    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            UserDatabase::class.java,
            "User_db"
        ).build()
    }
}