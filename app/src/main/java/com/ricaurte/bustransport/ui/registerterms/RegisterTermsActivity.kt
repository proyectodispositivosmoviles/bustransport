package com.ricaurte.bustransport.ui.registerterms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ricaurte.bustransport.R
import com.ricaurte.bustransport.databinding.ActivityLoginBinding
import com.ricaurte.bustransport.databinding.ActivityRegisterTermsBinding
import com.ricaurte.bustransport.ui.login.LoginViewModel
import com.ricaurte.bustransport.ui.register.RegisterActivity

class RegisterTermsActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityRegisterTermsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityRegisterTermsBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginBinding.returnConditionButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}