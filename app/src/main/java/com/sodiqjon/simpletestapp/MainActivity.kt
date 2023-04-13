package com.sodiqjon.simpletestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sodiqjon.simpletestapp.databinding.ActivityMainBinding
import com.sodiqjon.simpletestapp.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}