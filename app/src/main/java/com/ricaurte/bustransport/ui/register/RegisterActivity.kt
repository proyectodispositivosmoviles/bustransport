package com.ricaurte.bustransport.ui.register
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.ricaurte.bustransport.databinding.ActivityRegisterBinding
import com.ricaurte.bustransport.repository.UserRepository
import com.ricaurte.bustransport.ui.login.LoginActivity


class RegisterActivity : AppCompatActivity() {
    private lateinit var registerBinding: ActivityRegisterBinding
    private lateinit var registerViewModel: RegisterViewModel
    private var message = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        setContentView(registerBinding.root)

        //aca es donde tengo el problema las dos
        /*registerViewModel.dataValidated.observe(this) { result ->
            onDataValidatedSubscribe(result)}

            registerViewModel.msgDone.observe(this, { result ->
                onMsgDoneSubscribe(result)
        }*/



        with(registerBinding) {

            registerButton.setOnClickListener {
                registerViewModel.validatefiels(

                    nameUpdateEditText.text.toString(),
                    phoneUpdateEditText.text.toString(),
                    emailEditText.text.toString(),
                    passwordUpdateEditText.text.toString(),
                    repPasswordUpdateEditText.text.toString(),
                )
                Log.d("boton registrar","pase por el registrar")
            }
            

    }

    }

    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(
            applicationContext,
            msg,
            Toast.LENGTH_SHORT
        ).show()

    }

    private fun onDataValidatedSubscribe(result: Boolean?) {
        with(registerBinding) {
            registerViewModel.saveUser(
                nameUpdateEditText.text.toString(),
                phoneUpdateEditText.text.toString(),
                emailEditText.text.toString(),
                passwordUpdateEditText.text.toString(),
            )



    }


}
}


