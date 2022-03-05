package com.ricaurte.bustransport.ui.login

import android.content.Intent
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

class LoginViewModel : ViewModel() {
    val userRepository = UserRepository()
    private val findUser: MutableLiveData<User> = MutableLiveData()
    val findBookDone: LiveData<User> = findUser

    fun searchBook(email: String) {
        GlobalScope.launch(Dispatchers.IO) {
           // findUser.postValue(userRepository.searchUser(email:String))
        }
    }
}