package com.example.boutcamophw8

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.boutcamophw8.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var ppreferences: SharedPreferences
    lateinit var binding: ActivityMain2Binding
    var isRemember = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ppreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        binding.textView2.text = ppreferences.getString("NAME", "")
        binding.textView3.text = ppreferences.getString("CODE", "")
        binding.textView4.text = ppreferences.getString("BIRTHPLACE", "")
        binding.textView5.text = ppreferences.getString("ADDRESS", "")
        binding.textView6.text = ppreferences.getString("POSTCODE", "")
        binding.textView7.text = ppreferences.getString("GENDER", "")

        binding.button3.setOnClickListener {
            val editor: SharedPreferences.Editor = ppreferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.button2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Remember.isRemember = false
            finish()
        }
    }
}