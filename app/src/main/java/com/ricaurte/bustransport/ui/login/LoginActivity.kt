package com.ricaurte.bustransport.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.ricaurte.bustransport.ui.register.RegisterActivity
import com.ricaurte.bustransport.databinding.ActivityLoginBinding
import com.ricaurte.bustransport.ui.bottom.BottomActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        setContentView(loginBinding.root)


        /* override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginBinding = ActivityLoginBinding.inflate(inflater, container, false)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        return loginBinding.root
    }

        //var emailReceived : String? = ""
        //var passwordReceived : String? = ""

        //val credentials = intent.extras
        if (credentials != null){
            emailReceived = credentials.getString("email")
            passwordReceived = credentials.getString("password")
        }*/


        loginBinding.registerTestView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        with(loginBinding) {
            signInButton.setOnClickListener {
                loginViewModel.validateFields(
                    emailEditText.text.toString(),
                    passwordUpdateEditText.text.toString()
                )
            }
        }
    }

    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(
            applicationContext,
            "msg",
            Toast.LENGTH_SHORT
        ).show()
    }
}
