package com.ricaurte.bustransport.ui.login

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ricaurte.bustransport.local.User
import com.ricaurte.bustransport.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel(){
    val userRepository = UserRepository()
    var campsValidate: MutableLiveData<Boolean> = MutableLiveData()
    private val findUser: MutableLiveData<User> = MutableLiveData()
    val findUserDone: LiveData<User> = findUser
    private val message: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = message

    /*fun searchBook(email: String) {
        GlobalScope.launch(Dispatchers.IO) {
           findUser.postValue(userRepository.searchUser(email:String))
        }
    }*/

    fun validateFields(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            campsValidate.value= true
        }
        else{
            message.value = "usuario o contraseña incorrecto"
            }
        }


    }


