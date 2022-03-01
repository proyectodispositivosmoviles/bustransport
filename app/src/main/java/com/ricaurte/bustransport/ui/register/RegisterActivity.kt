package com.ricaurte.bustransport.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.ricaurte.bustransport.databinding.ActivityRegisterBinding
import com.ricaurte.bustransport.ui.login.LoginActivity


class RegisterActivity : AppCompatActivity() {
    private lateinit var registerBinding: ActivityRegisterBinding

    private fun validarCorreo(email_: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email_).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        with(registerBinding) {
            registerButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordUpdateEditText.text.toString()
                val repPassword = repPasswordUpdateEditText.text.toString()
                val valido=validarCorreo(email)
                if(valido){
                    if (password.length>5){
                        if (password == repPassword){
                            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                            intent.putExtra("email",email)
                            intent.putExtra("password", password)
                            startActivity(intent)
                        } else
                            Toast.makeText(applicationContext,"Las contraseñas deben iguales", Toast.LENGTH_SHORT).show()

                    }
                    else{
                        Toast.makeText(applicationContext,"La Contraseña Debe Contener Mínimo 6 Dígitos", Toast.LENGTH_SHORT).show()

                    }

                }
                else{
                    Toast.makeText(applicationContext,"Correo No Válido", Toast.LENGTH_SHORT).show()
                }


            }
        }
    }
}







