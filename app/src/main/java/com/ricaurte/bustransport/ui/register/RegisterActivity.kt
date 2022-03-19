package com.ricaurte.bustransport.ui.register
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ricaurte.bustransport.databinding.ActivityRegisterBinding
import com.ricaurte.bustransport.ui.login.LoginActivity
import com.ricaurte.bustransport.ui.registerterm.RegistertermActivity2


class  RegisterActivity : AppCompatActivity() {
    private lateinit var registerBinding: ActivityRegisterBinding
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        setContentView(registerBinding.root)
        registerBinding.returnRegisterButton.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        registerBinding.termsConditions2TextView.setOnClickListener{
            val intent = Intent(this, RegistertermActivity2::class.java)
            startActivity(intent)
        }
        registerViewModel.dataValidated.observe(this) { result ->
            onDataValidatedSubscribe(result)

        }
        registerViewModel.msgDone.observe(this) { result ->
            onMsgDoneSubscribe(result)
        }
        with(registerBinding) {
            // val agree=termsConditionsRadioButton.isChecked
            registerButton.setOnClickListener {
                registerViewModel.validatefiels(
                    nameUpdateEditText.text.toString(),
                    phoneUpdateEditText.text.toString(),
                    emailEditText.text.toString(),
                    passwordUpdateEditText.text.toString(),
                    repPasswordUpdateEditText.text.toString(),
                    //agree,
                )

            }


        }


    }

    private fun onDataValidatedSubscribe(result: Boolean) {

        with(registerBinding) {
            /* registerViewModel.saveUser(
                 nameUpdateEditText.text.toString(),
                 phoneUpdateEditText.text.toString(),
                 emailEditText.text.toString(),
                 passwordUpdateEditText.text.toString(),
             )
           var myRandom= Random.nextInt(until = 5)
           var myUrl= listOf({
               "https://firebasestorage.googleapis.com/v0/b/bustransport-d73af.appspot.com/o/useravatars%2Favatar1.webp?alt=media&token=495ac296-40ea-4349-9b64-0f45dc679a49";
               "https://firebasestorage.googleapis.com/v0/b/bustransport-d73af.appspot.com/o/useravatars%2Favatar2.webp?alt=media&token=63fbe63b-5ca1-4186-87ed-36d003604b85";
               "https://firebasestorage.googleapis.com/v0/b/bustransport-d73af.appspot.com/o/useravatars%2Favatar3.webp?alt=media&token=2d0225a0-84e6-494f-8c80-d1667650164a";
               "https://firebasestorage.googleapis.com/v0/b/bustransport-d73af.appspot.com/o/useravatars%2Favatar4.webp?alt=media&token=ccc14165-9b05-46f2-8c6d-fa9d99565df9"})
           val urlAvatar=myUrl[myRandom]*/
            registerViewModel.saveUserInServer(
                nameUpdateEditText.text.toString(),
                phoneUpdateEditText.text.toString(),
                emailEditText.text.toString(),
                //urlAvatar.toString(),
            )
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
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
}