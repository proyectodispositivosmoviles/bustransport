package com.ricaurte.bustransport.server.UserServerRepository

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.server.ItineraryServer
import com.ricaurte.bustransport.server.ReserveServer
import com.ricaurte.bustransport.server.RouteServer
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

    suspend fun loadUsers(): QuerySnapshot {
        return withContext(Dispatchers.IO) {
            db.collection("users").get().await()
        }
    }


    fun updateUser(name: String, phone: String, email: String, ) {
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

    suspend fun loaditinerary(): QuerySnapshot {
        return withContext(Dispatchers.IO) {
            db.collection("itinerary").get().await()
        }


    }

    suspend fun loadRoute(): QuerySnapshot {
        return withContext(Dispatchers.IO) {
            db.collection("routes").get().await()
        }


    }
    fun saveReserve(
        email: String,
        fecha: String,
        id: String,
        quantity: Int,
        idRoute: String?,

        ): String {
        val documentReserve = db.collection("reserves").document()
            val reserve = ReserveServer(
            rid =idRoute,
            idItinerary= id,
            idReserve = documentReserve.id,
            user = email,
            reserveDate = fecha,
           quantity = quantity,
            )
        db.collection("reserves").document(documentReserve.id).set(reserve)
        return  documentReserve.id

    }

    fun updateItinerary(itinerary: ItineraryServer, hour: String, quantityInt: Int) {
       var current=itinerary.availableSeat
        val documentItinerary = db.collection("itinerary").document()

         if (current != null) {
             current=current-quantityInt
            val itineraryUpdatede=ItineraryServer(
                availableSeat=10,
                carNumber=itinerary.carNumber,
                departureDate=itinerary.departureDate,
                departureTime=itinerary.departureTime,
                id=itinerary.id,
                idRoute=itinerary.idRoute
            )
             db.collection("itinerary").document().update("availableSeat",10) //update("$id/availableSeat",current)

        }



    }


}