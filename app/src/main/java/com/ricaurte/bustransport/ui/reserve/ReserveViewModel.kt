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
    private val idReserve: MutableLiveData<String> = MutableLiveData()
    val IdReserveCreated: LiveData<String> = idReserve


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
                                        if (itiId != null) {
                                            updateItinerary(itineraryServer,hour,quantity)
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    private fun updateItinerary(itiId: ItineraryServer, hour:String, quantity: String) {
        var quantityInt=Integer.parseInt(quantity)
        userServerRepository.updateItinerary(itiId,hour,quantityInt)



    }

    private fun saverReserve(
        email: String,
        fecha: String,
        itiId: String?,
        quantity: String,
        idRoute: String?
    ) {
        var quantityInt=Integer.parseInt(quantity)

            if (itiId != null) {
                userServerRepository.saveReserve(email,fecha, itiId,quantityInt,idRoute)

        }

    }

    fun showSeatAvailable(hour: String) {
message.value="revise el horario,$hour"
    }

    fun enviarMensaje() {
        message.value="Escoge una ruta por favor "
    }
}
