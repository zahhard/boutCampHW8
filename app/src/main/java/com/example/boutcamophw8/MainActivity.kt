package com.example.boutcamophw8

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.boutcamophw8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.button.setOnClickListener {
            codeTypeCheck()
            checkEmptyView()
            var intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun codeTypeCheck() {
        if (binding.myEditTextCode.text?.length != 10) {
            binding.myEditTextCode.error = "10 رقمی"
        }
    }

    private fun checkEmptyView() {
        if (binding.myEditTextCode.text?.isBlank() == true) {
            binding.myEditTextCode.error = "اجباری"
        }
        if (binding.myEditTextName.text?.isBlank() == true) {
            binding.myEditTextName.error = "اجباری"
        }
        if (binding.myEditText1.text?.isBlank() == true) {
            binding.myEditText1.error = "اجباری"
        }
        if (binding.myEditTextBirth.text?.isBlank() == true) {
            binding.myEditTextBirth.error = "اجباری"
        }
        if (binding.myEditTextPost.text?.isBlank() == true) {
            binding.myEditTextPost.error = "اجباری"
        }
        if (binding.gender.checkedRadioButtonId == -1) {
            binding.men.error = "اجباری"
        }
    }

    fun saveInShared(name: String,
                     code: Int,
                     birthPlace: String,
                     address: String,
                     postCode: Int)
    {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putInt("code", code)
        editor.putString("birthPlace", birthPlace)
        editor.putString("address", address)
        editor.putInt("postCode", postCode)
        editor.apply()
    }
}