package com.example.tictaktoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.tictaktoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var isXTurn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.firsthBtn.setOnClickListener {
            btnClicked(it as Button)
        }
        binding.secondtBtn.setOnClickListener {
            btnClicked(it as Button)

        }
        binding.thirdBtn.setOnClickListener {
            btnClicked(it as Button)
        }
        binding.fourthBtn.setOnClickListener {
            btnClicked(it as Button)
        }
        binding.fivethBtn.setOnClickListener {
            btnClicked(it as Button)
        }
        binding.sixthBtn.setOnClickListener {
            btnClicked(it as Button)
        }
        binding.seventhBtn.setOnClickListener {
            btnClicked(it as Button)
        }
        binding.eightthBtn.setOnClickListener {
            btnClicked(it as Button)
        }
        binding.ninethBtn.setOnClickListener {
            btnClicked(it as Button)
        }
    }

    private fun btnClicked(button: Button) {

        if (button.text.isNotBlank()) return
        button.text = if (isXTurn) {
            button.setTextColor(Color.RED)
            "X"
        } else {
            button.setTextColor(Color.GREEN)
            "0"
        }
        isXTurn = !isXTurn

    }
}
