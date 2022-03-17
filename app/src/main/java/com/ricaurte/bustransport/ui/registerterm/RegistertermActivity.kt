package com.ricaurte.bustransport.ui.registerterm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ricaurte.bustransport.databinding.ActivityRegistertermBinding
import com.ricaurte.bustransport.ui.register.RegisterActivity

class RegistertermActivity : AppCompatActivity() {

    private lateinit var registertermBinding: ActivityRegistertermBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registertermBinding = ActivityRegistertermBinding.inflate(layoutInflater)
        setContentView(registertermBinding.root)

       /* registertermBinding.returnConditionButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }*/
    }
}
