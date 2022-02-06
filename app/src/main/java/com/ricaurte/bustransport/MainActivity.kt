package com.ricaurte.bustransport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.ricaurte.bustransport.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainbinding : ActivityMainBinding


    var passwordReceived : String? = ""
    var emailReceived : String? = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainbinding.root)
            val credentials = intent.extras
            if (credentials != null) {
                credentials.getString("email").also { emailReceived = it }
                credentials.getString("password").also { passwordReceived = it }
            }
        var userLogged : TextView = findViewById(R.id.log_text_view)
        userLogged.text="autenticado: $emailReceived"
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_sign_out -> goToLoginActivity()
        }
        return  super.onOptionsItemSelected(item)
    }

    private fun goToLoginActivity() {
        val intent = Intent(this,LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK  or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra("password", passwordReceived)
        intent.putExtra("email",emailReceived)


        startActivity(intent)
    }
}