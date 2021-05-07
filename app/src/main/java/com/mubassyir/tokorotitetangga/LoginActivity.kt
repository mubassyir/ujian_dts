package com.mubassyir.tokorotitetangga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mubassyir.tokorotitetangga.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    companion object{
        private const val admin = "admin"
    }
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnLogin.setOnClickListener {
            val user = binding.etUsername.text.toString()

            if (user=="user"){
                Intent(this,MainActivity::class.java).also {
                    startActivity(it)
                }
            } else{
                Intent(this,OrderedActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}