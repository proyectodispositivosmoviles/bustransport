package com.ricaurte.bustransport.server

import java.io.Serializable

data class UserServer(
    var uid: String? = null,
    var name: String? = null,
    var phone: String? = null,
    var email: String? = null,
    var url_avatar:String?=null,
    ):Serializable
