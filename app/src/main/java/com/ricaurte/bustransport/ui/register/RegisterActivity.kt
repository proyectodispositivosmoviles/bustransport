package com.ricaurte.bustransport.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.ricaurte.bustransport.databinding.ActivityRegisterBinding
import com.ricaurte.bustransport.repository.UserRepository
import com.ricaurte.bustransport.ui.login.LoginActivity
import com.ricaurte.bustransport.ui.main.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class RegisterActivity : AppCompatActivity() {
    private lateinit var registerBinding: ActivityRegisterBinding

    private val userRepository = UserRepository()
     

    private fun validarCorreo(email_: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email_).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)


        with(registerBinding) {
            registerButton.setOnClickListener {
                val name=nameEditText.text.toString()
                val phone=phoneEditText.text.toString()
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val repPassword = repPasswordEditText.text.toString()
                val valido=validarCorreo(email)
                if (name.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() ){
                    if(valido ){
                        if (password.length>5){
                            if (password == repPassword){
                                //aqui va el codigo para guardar
                                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                                GlobalScope.launch(Dispatchers.IO) {
                                    userRepository.saveuser(name, phone, email, password)
                                    startActivity(intent)
                                }


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


                    } else{
                    Toast.makeText(applicationContext, "ingrese todos los datos por favor", Toast.LENGTH_SHORT)
                        .show()
                    }

            }
        }
    }
}









