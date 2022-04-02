package com.ricaurte.bustransport.server.UserServerRepository

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.server.UserServer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class UserServerRepository {
    val db = Firebase.firestore
    fun saveUser(
        name: String,
        phone: String,
        email: String,
        urlAvatar: String,
    ) {
        val documentUser = db.collection("users").document()

        val user = UserServer(
            uid = documentUser.id,
            name = name,
            phone = phone,
            email = email,
            urlAvatar = urlAvatar,
        )
        db.collection("users").document(email).set(user)

    }



    /*fun updateUser(name: String, phone: String, email: String, ) {
        val documentUser = db.collection("users").document()

        val user = UserServer(
            //uid = documentUser.id,
            name = name,
            phone = phone,
            email = email,
            //urlAvatar=urlAvatar,

        )
        db.collection("users").document(email).set(user, SetOptions.merge())
    }
    suspend fun loadReserve(): QuerySnapshot {
        return withContext(Dispatchers.IO) {
            db.collection("reserves").get().await()
        }
    }*/





    suspend fun loadUsers(): QuerySnapshot {
        return withContext(Dispatchers.IO) {
            db.collection("users").get().await()
        }
    }


    fun updateUser(name: String, phone: String, email: String,  ) {
        val documentUser = db.collection("users").document()

        val user = UserServer(
            //uid = documentUser.id,
            name = name,
            phone = phone,
            email = email,
            //urlAvatar=urlAvatar,

        )
        db.collection("users").document(email).set(user, SetOptions.merge())



    }
    /* val users = db.collection("users")

     // return withContext(Dispatchers.IO){db.collection("users").get()}
   // return db.collection("users").whereEqualTo("email",email).await()
     //return users.whereEqualTo("email",email_)
    return db.collection("users")
         .whereEqualTo("email", email_)
         .get()
         .addOnSuccessListener { documents ->
             for (document in documents) {
                 Log.d("mejor", "${document.id} => ${document.data}")
             }
         }*/
    }

           /*return withContext(Dispatchers.IO) {
               db.collection("users")
                   .document(email).get()
           }
        }*/








