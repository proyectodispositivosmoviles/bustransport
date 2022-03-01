package com.ricaurte.bustransport.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.ricaurte.bustransport.R
import com.ricaurte.bustransport.ui.main.MainActivity
import com.ricaurte.bustransport.ui.register.RegisterActivity
import com.ricaurte.bustransport.databinding.ActivityLoginBinding
import com.ricaurte.bustransport.local.User
import com.ricaurte.bustransport.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private val findUser: MutableLiveData<User> = MutableLiveData()
    private lateinit var loginBinding: ActivityLoginBinding

    val findUserDone: LiveData<User> = findUser

    //var emailsaved="non0"
    //private
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)


        loginBinding.registerTestView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        with(loginBinding) {
            signInButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val userRepository = UserRepository()
                var user = User()


                GlobalScope.launch(Dispatchers.IO) {
                    findUser.postValue(userRepository.searchUser(email))
                    Log.d("el email es=", user.email)
                }
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)

                    startActivity(intent)
                    } else {
                    Toast.makeText(
                    this@LoginActivity,
                    "Usuario o contraseña incorrectos",
                    Toast.LENGTH_SHORT
                    ).show()
                    }
            }
        }
    }
}
