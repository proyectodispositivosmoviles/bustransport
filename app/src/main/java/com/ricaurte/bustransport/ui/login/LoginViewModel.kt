package com.ricaurte.bustransport.ui.login

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.ricaurte.bustransport.local.User
import com.ricaurte.bustransport.repository.UserRepository
import com.ricaurte.bustransport.ui.register.RegisterActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class LoginViewModel() : ViewModel() {

    val userRepository = UserRepository()
    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate

    private val findUser: MutableLiveData<User> = MutableLiveData()
    val findUserDone: LiveData<User> = findUser
    private val message: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = message

    fun validateFields(email: String, password: String, user: User) {
        if (email.isNotEmpty()&& password.isNotEmpty()&&password==user.password&&email.equals(user.email,true)) {
            dataValidate.value = true
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
                "pone un número!!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}


