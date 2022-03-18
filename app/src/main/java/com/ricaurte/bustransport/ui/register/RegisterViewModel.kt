package com.ricaurte.bustransport.ui.register


import android.util.Log
import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.local.repository.UserRepository
import com.ricaurte.bustransport.server.UserServer
import com.ricaurte.bustransport.server.UserServerRepository.UserServerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random


class RegisterViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

    private val userRepository = UserRepository()
    private val userServerRepository=UserServerRepository()

    private val message: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = message

    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate

    private fun validarCorreo(email_: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email_).matches()
    }

    fun validatefiels(
        name: String,
        phone: String,
        email: String,
        password: String,
        repPassword: String,
        //agree: Boolean,

        ) {

        val valido = validarCorreo(email)
        if (name.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && repPassword.isNotEmpty()) {
            if (valido) {
                if (password.length > 5) {
                    if (password == repPassword) {
                        auth=Firebase.auth
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener() { task ->
                                if (task.isSuccessful) {
                                    Log.d("Register", "createUserWithEmail:success")
                                }
                            }
                        dataValidate.value = true
                    } else
                        message.value = "Las Contraseñas Deben Ser Iguales"
                } else {
                    message.value = "La Contraseña Debe Contener Mínimo 6 Dígitos"
                }
            } else {
                message.value = "Correo No Válido"
            }
        } else {
            message.value = "Por Favor Llene Todos Los Campos"
        }
    }

    fun saveUser(
        name: String,
        phone: String,
        email: String,
        password: String,


        ) {
        GlobalScope.launch(Dispatchers.IO) {
            userRepository.saveuser(name, phone, email, password)

        }
    }

    fun saveUserInServer(name: String, phone: String, email: String,urlAvatar:String ) {
        GlobalScope.launch(Dispatchers.IO){


            userServerRepository.saveUser(name, phone,email,urlAvatar)
        }

        }

}




