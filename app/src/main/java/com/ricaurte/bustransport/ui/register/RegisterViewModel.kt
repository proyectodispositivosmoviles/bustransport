package com.ricaurte.bustransport.ui.register


import android.util.Log
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ricaurte.bustransport.repository.UserRepository
import com.ricaurte.bustransport.server.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class RegisterViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

    private val userRepository = UserRepository()

    private val message: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = message

    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate

    private fun validarCorreo(email_: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email_).matches()
    }

    fun validatefiels(
        name: String,
        phone: String,
        email: String,
        password: String,
        repPassword: String,
       // agree: Boolean,

        ) {

        val valido = validarCorreo(email)
        if (name.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && repPassword.isNotEmpty()) {
            if (valido) {
                if (password.length > 5) {
                    if (password == repPassword) {
                        auth=Firebase.auth
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener() { task ->
                                if (task.isSuccessful) {
                                    createUser(auth.currentUser?.uid, name,phone,email,)
                                    dataValidate.value = true

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("registro", "createUserWithEmail:failure", task.exception)
                                    /*Toast.makeText(
                                        applicationContext,
                                        "autenticacion fallida",
                                        Toast.LENGTH_SHORT
                                    ).show()*/

                                }
                            }
                        //dataValidate.value = true
                    } else
                        message.value = "Las contraseñas deben ser iguales"
                } else {
                    message.value = "La Contraseña Debe Contener Mínimo 6 Dígitos"
                }
            } else {
                message.value = "Correo No Válido"
            }
        } else {
            message.value = "Por Favor Llene Todos Los Campos"
        }
    }

    private fun createUser(
        uid: String?,
        name: String,
        phone: String,
        email: String,
       ) {
        val db = Firebase.firestore
        val user = User(uid = uid, name = name, phone = phone, email = email)
        email?.let { uid ->
            db.collection("users").document(email).set(user)
                .addOnSuccessListener {
                  message.value="usuario correctamente creado"
                }
        }
    }
    fun saveUser(
        name: String,
        phone: String,
        email: String,
        password: String,

        ) {
        GlobalScope.launch(Dispatchers.IO) {
            userRepository.saveuser(name, phone, email, password)

        }
    }

}




