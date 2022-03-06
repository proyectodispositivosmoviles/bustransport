package com.ricaurte.bustransport.ui.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ricaurte.bustransport.databinding.ActivityLoginBinding
import com.ricaurte.bustransport.databinding.ActivityRegisterBinding
import com.ricaurte.bustransport.repository.UserRepository
import com.ricaurte.bustransport.ui.login.LoginActivity
import com.ricaurte.bustransport.ui.login.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val userRepository = UserRepository()

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

    ) {
        val valido = validarCorreo(email)
        Log.d("validar","pase por el validar")
        if (name.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && repPassword.isNotEmpty()) {
            Log.d("validar","entre a comparar,$name")
            if (valido) {
                if (password.length > 5) {
                    if (password == repPassword) {
                         dataValidate.value = true
                    } else
                        message.value = "Las contraseñas deben iguales"
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
            Log.d( "nombre","$name")
            GlobalScope.launch(Dispatchers.IO) {
            userRepository.saveuser(name, phone, email, password)
                Log.d( "nombre","supuestamente guarde")


        }
    }

}




