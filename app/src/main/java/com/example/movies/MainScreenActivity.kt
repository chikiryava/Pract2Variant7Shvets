package com.example.movies

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.movies.databinding.ActivityMainScreenBinding

class MainScreenActivity : Activity() {

    private lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun toChat(view: View) {
        val intent = Intent(this, ChatListActivity::class.java)
        startActivity(intent)
    }

    fun toMovies(view: View) {
        val intent = Intent(this, MoviesScreenActivity::class.java)
        startActivity(intent)
    }
}