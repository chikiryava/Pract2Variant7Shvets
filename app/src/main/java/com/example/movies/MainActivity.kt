package com.example.movies

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.movies.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var shar: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        shar = getSharedPreferences("data", MODE_PRIVATE)
        var correctlogin = shar.getString("login", null)
        var correctpassword = shar.getString("password", null)
        if (correctlogin != null && correctpassword != null)
        {
            binding.login.setText(correctlogin)
            binding.password.setText(correctpassword)
        }

    }

    fun toScreen(view: View) {
        var log = binding.login.text.toString()
        var pass = binding.password.text.toString()
        shar = getSharedPreferences("data", MODE_PRIVATE)
        if (log.isEmpty() || pass.isEmpty())
        {
            Toast.makeText(this, "Введите логин и пароль", Toast.LENGTH_SHORT).show()
        }
        else if (pass.length < 6)
        {
            Toast.makeText(this, "Пароль должен состоять минимум из 6 символов", Toast.LENGTH_SHORT).show()
        }
        else {
            shar = getSharedPreferences("data", MODE_PRIVATE)
            var correctlogin = shar.getString("login", null)
            var correctpassword = shar.getString("password", null)
            if (correctlogin != null && correctpassword != null) {
                if (correctlogin == log && correctpassword == pass) {
                    val intent = Intent(this, MainScreenActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
                }
            } else {
                var edit = shar.edit()
                edit.putString("login", log)
                edit.putString("password", pass)
                edit.apply()
            }
        }

    }
}