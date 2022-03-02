package com.ricaurte.bustransport.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ricaurte.bustransport.ui.main.MainActivity
import com.ricaurte.bustransport.ui.register.RegisterActivity
import com.ricaurte.bustransport.databinding.ActivityLoginBinding
import com.ricaurte.bustransport.ui.bottom.BottomActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        var emailReceived : String? = ""
        var passwordReceived : String? = ""

        val credentials = intent.extras
        if (credentials != null){
            emailReceived = credentials.getString("email")
            passwordReceived = credentials.getString("password")
        }

        loginBinding.registerTestView.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        with(loginBinding){
            signInButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordUpdateEditText.text.toString()

                if (email == emailReceived && password == passwordReceived && email.isNotEmpty() && password.isNotEmpty()){
                    val intent = Intent(this@LoginActivity, BottomActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK  or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    intent.putExtra("email",emailReceived)
                    intent.putExtra("password", passwordReceived)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity,"Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}