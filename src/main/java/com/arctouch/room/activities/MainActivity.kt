package com.arctouch.room.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arctouch.room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        binding.btQuotes.setOnClickListener {
            startActivity(QuotesActivity::class.java)
        }
        binding.btAuthors.setOnClickListener {
            startActivity(AuthorsActivity::class.java)
        }
        binding.btQuotesWithAuthors.setOnClickListener {
            startActivity(QuotesWithAuthorsActivity::class.java)
        }
    }

    private fun startActivity(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }
}