package com.ricaurte.bustransport.ui.updatecount

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.server.UserServerRepository.UserServerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdatecountViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

    private val userServerRepository= UserServerRepository()

    private val message: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = message

    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate

    fun validatefiels(
        email:String,
        name: String,
        phone: String,
        password: String,
        repPassword: String,

        //agree: Boolean,

    ) {
       if (name.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty() && repPassword.isNotEmpty()) {
               if (password.length > 5) {
                   dataValidate.value = true
                   if (password == repPassword) {
                        auth= Firebase.auth
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    message.value="si la creó"
                                }
                                else{
                                    message.value="${task.exception}"
                                }
                            }
                        dataValidate.value = true
                    } else
                        message.value = "Las Contraseñas Deben Ser Iguales"
                } else {
                    message.value = "La Contraseña Debe Contener Mínimo 6 Dígitos"
                }

        } else {
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