package com.example.datastoreprefkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.example.datastoreprefkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel:MainViewModel
    private lateinit var dataStoreManager: DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        dataStoreManager = DataStoreManager(this)

        checkThemeMode()

        binding.modeSwitch.setOnCheckedListener{_, isChecked ->

            when(isChecked){
                true->{
                    viewModel.setTheme(true)
                }

                false->{
                    viewModel.setTheme(false)
                }


            }            }

        }

        fun checkThemeMode() {

        binding.apply {
            viewModel.getTheme.observe(this@MainActivity){ isDarkMode->
                when(isDarkMode) {
                    true -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        modeSwitch.isChecked = true
                        modeSwitch.text="Dark Mode"
                        imgStatus.setAnimation(R.raw.night)
                    }

                    false->{
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        modeSwitch.isChecked = false
                        modeSwitch.text="Light Mode"
                        imgStatus.setAnimation(R.raw.day)
                    }

                }

            }

        }

    }
}