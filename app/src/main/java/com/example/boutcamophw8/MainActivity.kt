package com.example.boutcamophw8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.boutcamophw8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.button.setOnClickListener{
            codeTypeCheck()
            checkEmptyView()
        }
    }

    private fun codeTypeCheck(){
        if (binding.myEditTextCode.text?.length != 10){
            binding.myEditTextCode.error = "نامعتبر"
        }
    }

    private fun checkEmptyView(){
        if (binding.myEditTextCode.text?.isBlank() == true){
            binding.myEditTextCode.error = "اجباری"
        }
        if (binding.myEditTextName.text?.isBlank() == true){
            binding.myEditTextName.error = "اجباری"
        }
        if (binding.myEditText1.text?.isBlank() == true){
            binding.myEditText1.error = "اجباری"
        }
        if (binding.myEditTextBirth.text?.isBlank() == true){
            binding.myEditTextBirth.error = "اجباری"
        }
        if (binding.myEditTextPost.text?.isBlank() == true){
            binding.myEditTextPost.error = "اجباری"
        }
        if (binding.gender.checkedRadioButtonId == -1){
            binding.men.error = "اجباری"
        }

    }
}