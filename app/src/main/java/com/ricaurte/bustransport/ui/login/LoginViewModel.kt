package com.ricaurte.bustransport.ui.login

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.test.core.app.ApplicationProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.local.User
import com.ricaurte.bustransport.local.repository.UserRepository
import com.ricaurte.bustransport.ui.bottom.BottomActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class LoginViewModel() : ViewModel() {
    private lateinit var auth: FirebaseAuth

    private val userRepository = UserRepository()
    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate
    private var campsValidate: Boolean = false

    private val findUser: MutableLiveData<User> = MutableLiveData()
    val findUserDone: LiveData<User> = findUser
    private val message: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = message
    private fun validarCorreo(email_: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email_).matches()
    }

    fun validateFields(email: String, password: String, ) {
        val valido = validarCorreo(email)
        if (email.isNotEmpty() && password.isNotEmpty()
        ) {
            if (valido) {
               campsValidate = true

            } else {
                message.value = "Usuario ó Contraseña Incorrectos"
            }
        } else {
            message.value = "Por Favor Llene Todos Los Campos"
        }

    }

        fun searhUser(email: String) {
            GlobalScope.launch(Dispatchers.IO) {
                findUser.postValue(userRepository.searchUser(email))
            }
        }
        fun searchUserInFirebase(email: String, password: String) {
            validateFields(email, password)

            if (campsValidate) {
                auth = Firebase.auth
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                           dataValidate.value = true

                        } else {
                            message.value = "Usuario ó Contraseña Incorrectos"
                        }
                    }
            }
        }
    }

