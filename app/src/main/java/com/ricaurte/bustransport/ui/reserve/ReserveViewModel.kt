package com.ricaurte.bustransport.ui.reserve

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.toObject
import com.ricaurte.bustransport.server.ItineraryServer
import com.ricaurte.bustransport.server.RouteServer
import com.ricaurte.bustransport.server.UserServer
import com.ricaurte.bustransport.server.UserServerRepository.UserServerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ReserveViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth


    private val userServerRepository = UserServerRepository()
    private val message: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = message
    private val dataValidate: MutableLiveData<Int> = MutableLiveData()
    val dataValidated: LiveData<Int> = dataValidate
    private val findItineraryServer: MutableLiveData<ItineraryServer> = MutableLiveData()
    val findItineraryDone: LiveData<ItineraryServer> = findItineraryServer


    fun loadDates(
        oneRadioButtonState: Boolean,
        twoRadioButtonState: Boolean,
        hour: String,
        quantity: String
    ) {
        GlobalScope.launch(Dispatchers.IO) {

            var result = userServerRepository.loaditinerary()
            for (document in result) {
                val itineraryServer: ItineraryServer = document.toObject<ItineraryServer>()
                if (hour == itineraryServer.departureTime) {
                    //findItineraryServer.postValue(itineraryServer)
                    result = userServerRepository.loadRoute()
                    for (document in result) {
                        val routeServer: RouteServer = document.toObject<RouteServer>()
                        if (itineraryServer.idRoute == routeServer.rid) {
                            val idRoute = routeServer.rid
                            val rou = routeServer.rid
                           // Log.d("si", " $ya, route $ya")
                            val email = FirebaseAuth.getInstance().currentUser?.email.toString()
                            GlobalScope.launch(Dispatchers.IO) {
                                val result = userServerRepository.loadUsers()
                                for (document in result) {
                                    val userServer: UserServer = document.toObject<UserServer>()
                                    if (email == userServer.email) {
                                        val itiId=itineraryServer.id

                                        val fecha="03/03/22"
                                     saverReserve(email, fecha, itiId, quantity,idRoute)
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }
    private fun saverReserve(
        email: String,
        fecha: String,
        itiId: String?,
        quantity: String,
        idRoute: String?
    ) {

            if (itiId != null) {
                userServerRepository.saveReserve(email,fecha, itiId,quantity,idRoute)

        }

    }

    fun showSeatAvailable(hour: String) {
message.value="revise el horario,$hour"
    }
}
