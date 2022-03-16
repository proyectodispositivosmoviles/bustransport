package com.ricaurte.bustransport.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Types
import java.io.Serializable

@Entity(tableName= "table_user")
data class User(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int = Types.NULL,
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "phone") var phone: String = "",
    @ColumnInfo(name = "email") var email: String = "",
    @ColumnInfo(name = "password") var password: String = "",
   ) : Serializable
