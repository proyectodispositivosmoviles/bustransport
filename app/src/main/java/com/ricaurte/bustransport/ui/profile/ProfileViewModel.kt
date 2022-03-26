package com.ricaurte.bustransport.ui.profile

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.local.User
import com.ricaurte.bustransport.local.repository.UserRepository
import com.ricaurte.bustransport.server.UserServer
import com.ricaurte.bustransport.server.UserServerRepository.UserServerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.ktx.toObject


class ProfileViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth

    private val userRepository = UserRepository()
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

            //message.value="el usuario es: $email"
            val result = userServerRepository.loadUsers()
            Log.d("mejor", "usuario: $result")
            var isFoundUser = false
           /*for (document in result) {
                val userServer: UserServer = document.toObject<UserServer>()

                if (email == userServer.email) {
                    isFoundUser=true
                    message.value="si es igual el email"
                    findUserServer.postValue(userServer)
                   // message.value = "el valor es en profile"

                    // Log.d("si","$result")}


                    //Toast.makeText(requireContext(),"esto es mejor",Toast.LENGTH_SHORT).show()

                }

              // if (!isFoundUser)findUserServer.postValue(null)
               message.value="nada es igual"
            }*/
        }
    }
}
