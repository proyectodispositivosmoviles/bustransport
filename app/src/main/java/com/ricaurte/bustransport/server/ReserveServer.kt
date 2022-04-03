package com.ricaurte.bustransport.server

import java.io.Serializable

data class ReserveServer(var idReserve: String? = null,
                         var rid: String? = null,
                         var user:String?=null,
                         var reserveDate:String?=null,
                         var idItinerary:String?=null,
                         var quantity:Int?=null,
                         var approchloation:String?=null,
                         ): Serializable
