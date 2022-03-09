package com.ricaurte.bustransport.ui.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.test.core.app.ApplicationProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.local.User
import com.ricaurte.bustransport.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class LoginViewModel() : ViewModel() {
    private lateinit var auth: FirebaseAuth

    private val userRepository = UserRepository()
    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate

    private val findUser: MutableLiveData<User> = MutableLiveData()
    val findUserDone: LiveData<User> = findUser
    private val message: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = message



    fun validateFields(email: String, password: String, user: User) {
        if (email.isNotEmpty()&& password.isNotEmpty()&&password==user.password&&email.equals(user.email,true)) {
            auth= Firebase.auth
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        dataValidate.value = true
                    } else {
                    Log.w("registro", "signInWithEmail:failure", task.exception)
                    }
                }


        } else {
            message.value = "usuario o contraseña incorrecto"
        }
    }
    fun searhUser(email: String) {
        try {
            GlobalScope.launch(Dispatchers.IO) {
                findUser.postValue(userRepository.searchUser(email))}
        } catch (e: Exception) {
            Toast.makeText(
                ApplicationProvider.getApplicationContext<Context>(),
                "error",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}


