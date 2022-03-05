package com.ricaurte.bustransport.ui.login

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ricaurte.bustransport.repository.UserRepository

class LoginViewModel : ViewModel() {
    private var campsValidate: MutableLiveData<Boolean> = MutableLiveData()
    private val message: MutableLiveData<String> = MutableLiveData()
    private val userRepository = UserRepository()
    val messageDone: LiveData<String> = message

    fun validateFields(email: String?,password:String) {

            if (email != null && email.isNotEmpty() && password.isNotEmpty()) {

                campsValidate.value=  true
            }
            else{
                message.value="usuario ó contraseña incorrecta"
            }
    }


}