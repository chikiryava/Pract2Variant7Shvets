package com.example.movies

import android.app.Activity
import android.os.Bundle
import com.example.movies.databinding.ActivityChatListBinding

class ChatListActivity : Activity() {

    private lateinit var binding: ActivityChatListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChatListBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}