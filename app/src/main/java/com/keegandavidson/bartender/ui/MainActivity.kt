package com.keegandavidson.bartender.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.keegandavidson.bartender.R
import com.keegandavidson.bartender.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}