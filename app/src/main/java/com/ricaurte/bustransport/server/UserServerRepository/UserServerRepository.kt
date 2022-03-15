package com.ricaurte.bustransport.server.UserServerRepository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.server.UserServer

class UserServerRepository {
    val db = Firebase.firestore
    fun saveUser(
        name: String,
        phone: String,
        email: String,
    ) {
        val documentUser = db.collection("users").document()

        val user = UserServer(
            uid = documentUser.id,
            name = name,
            phone = phone,
            email = email,
        )
        db.collection("users").document(email).set(user)

    }



    }


