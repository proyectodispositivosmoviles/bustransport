package com.ricaurte.bustransport.ui.updatecount

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.server.UserServer
import com.ricaurte.bustransport.server.UserServerRepository.UserServerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdatecountViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

    private val userServerRepository = UserServerRepository()
    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate
    private var campsValidate: Boolean = false

    private val findUserServer: MutableLiveData<UserServer> = MutableLiveData()
    val findUserDone: LiveData<UserServer> = findUserServer
    private val message: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = message

    fun searchUserInServer() {
        val email = FirebaseAuth.getInstance().currentUser?.email.toString()
        GlobalScope.launch(Dispatchers.IO) {
            val result = userServerRepository.loadUsers()

            for (document in result) {
                val userServer: UserServer = document.toObject<UserServer>()

                if (email == userServer.email) {

                    findUserServer.postValue(userServer)

                }

            }
        }
    }


    fun validatefiels(
        email:String,
        name: String,
        phone: String,
        //agree: Boolean,

    ) {
        if (name.isNotEmpty() && phone.isNotEmpty()){
            dataValidate.value = true
        }
        else {
            message.value = "Por Favor Llene Todos Los Campos"
        }
    }

    fun updateUserInServer(
        name: String,
        phone: String,
        email: String,
        password: String,
        repPassword: String,
        //urlAvatar: String
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            userServerRepository.updateUser(name, phone, email)
        }

    }

}
