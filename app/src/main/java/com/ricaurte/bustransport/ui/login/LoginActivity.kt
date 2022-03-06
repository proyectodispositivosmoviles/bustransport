package com.ricaurte.bustransport.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ricaurte.bustransport.ui.register.RegisterActivity
import com.ricaurte.bustransport.databinding.ActivityLoginBinding
import com.ricaurte.bustransport.local.User

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        setContentView(loginBinding.root)

        loginViewModel.findUserDone.observe(this, { result ->
            onFindUserDoneSubscribe(result)
        })
        loginViewModel.msgDone.observe(this, { result ->
            onMsgDoneSubscribe(result)
        })
        with(loginBinding) {
            signInButton.setOnClickListener {
            var email = emailEditText.text.toString()
            loginViewModel.searhUser(email,)
            }
        }
        loginBinding.registerTextButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
         }
    }
    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(
            applicationContext,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }
    private fun onFindUserDoneSubscribe(user: User) {
        var email=loginBinding.emailEditText.text.toString()
        var password=loginBinding.passwordUpdateEditText.text.toString()
        loginViewModel.validateFields(email,password,user)
        val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
        startActivity(intent)
        }

        }









