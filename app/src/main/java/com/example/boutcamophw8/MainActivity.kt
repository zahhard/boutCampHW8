package com.example.boutcamophw8

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.boutcamophw8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    var isRemember = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        isRemember = sharedPreferences.getBoolean("CHECKED", false)

        if (isRemember) {

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        else{


        }


            binding.button.setOnClickListener {
                codeTypeCheck()
                checkEmptyView()

                if (!codeTypeCheck() || !checkEmptyView()) {

                    isRemember = true

                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("NAME", binding.myEditTextName.text.toString())
                    editor.putString("CODE", binding.myEditTextCode.text.toString())
                    editor.putString("POSTCODE", binding.myEditTextPost.text.toString())
                    editor.putString("BIRTHPLACE", binding.myEditTextBirth.text.toString())
                    editor.putString("ADDRESS", binding.myEditText1.text.toString())
                    editor.putBoolean("CHECKED", true)
                    editor.apply()

                    Toast.makeText(this, "shared successfully", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                    finish()
                }
            }

        }


    private fun codeTypeCheck(): Boolean {
        var isEmpty = false
        if (binding.myEditTextCode.text?.length != 10) {
            binding.myEditTextCode.error = "10 رقمی"
            isEmpty = true
        }
        return isEmpty
    }

    private fun checkEmptyView(): Boolean {
        var ischecked = false
        if (binding.myEditTextCode.text?.isBlank() == true) {
            binding.myEditTextCode.error = "اجباری"
            ischecked = true
        }
        if (binding.myEditTextName.text?.isBlank() == true) {
            binding.myEditTextName.error = "اجباری"
            ischecked = true
        }
        if (binding.myEditText1.text?.isBlank() == true) {
            binding.myEditText1.error = "اجباری"
            ischecked = true
        }
        if (binding.myEditTextBirth.text?.isBlank() == true) {
            binding.myEditTextBirth.error = "اجباری"
            ischecked = true
        }
        if (binding.myEditTextPost.text?.isBlank() == true) {
            binding.myEditTextPost.error = "اجباری"
            ischecked = true
        }
        if (binding.gender.checkedRadioButtonId == -1) {
            binding.men.error = "اجباری"
            ischecked = true
        }

        return ischecked
    }
}