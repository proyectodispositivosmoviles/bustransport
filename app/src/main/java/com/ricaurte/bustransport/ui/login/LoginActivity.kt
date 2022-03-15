package com.ricaurte.bustransport.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.ui.register.RegisterActivity
import com.ricaurte.bustransport.databinding.ActivityLoginBinding
import com.ricaurte.bustransport.local.User
import com.ricaurte.bustransport.ui.bottom.BottomActivity
import com.ricaurte.bustransport.ui.main.MainActivity
import com.ricaurte.bustransport.ui.payconfirmation.PayconfirmationFragment
import com.ricaurte.bustransport.ui.registerterm.RegistertermActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        setContentView(loginBinding.root)
        loginViewModel.findUserDone.observe(this) { result ->
        onFindUserDoneSubscribe(result)
        }
        loginViewModel.msgDone.observe(this) { result ->
            onMsgDoneSubscribe(result)
        }
        loginViewModel.dataValidated.observe(this) { result ->
            onDataValidatedSubscribe(result)
        }
        with(loginBinding) {
            signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password=passwordUpdateEditText.text.toString()
               loginViewModel.searchUserInFirebase(email,password)
            //loginViewModel.searhUser(email)
            }
        }
        loginBinding.registerTextButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
         }
    }

    private fun onDataValidatedSubscribe(result: Boolean?) {
        val intent = Intent(this@LoginActivity,BottomActivity::class.java)
        startActivity(intent)


    }

    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(
            applicationContext,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }
    private fun onFindUserDoneSubscribe(user: User?) {
        val email=loginBinding.emailEditText.text.toString()
        val password=loginBinding.passwordUpdateEditText.text.toString()
        if (user != null) {
            //loginViewModel.validateFields(email,password,user)
        }
        else{
           // Toast.makeText( applicationContext,"Usuario No Existe", Toast.LENGTH_SHORT).show()
            loginViewModel.searchUserInFirebase(email,password)
        }
        }

        }
