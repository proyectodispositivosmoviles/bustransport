package com.ricaurte.bustransport.server

import java.io.Serializable

data class ItineraryServer(var availableSeat: Int? = null,
                           var carNumber: String? = null,
                           var departureDate: String? = null,
                           var departureTime: String? = null,
                           var id:String?=null,
                           var idRoute:String?=null,
): Serializable
