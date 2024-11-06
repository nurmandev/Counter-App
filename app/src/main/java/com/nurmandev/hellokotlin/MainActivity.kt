package com.nurmandev.hellokotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declare and initialize the views
        val welcomeText: TextView = findViewById(R.id.welcome_text)
        val counterText: TextView = findViewById(R.id.counter_text)
        val incrementButton: Button = findViewById(R.id.btn)
        val restartButton: Button = findViewById(R.id.btn_restart)
        val clearButton: Button = findViewById(R.id.btn_clear)

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Increment button functionality
        incrementButton.setOnClickListener {
            counterText.text = increaseCounter().toString()
        }

        // Restart button functionality
        restartButton.setOnClickListener {
            counter = 0
            counterText.text = counter.toString()
        }

        // Clear button functionality
        clearButton.setOnClickListener {
            counter = 0
            counterText.text = ""
        }
    }

    private fun increaseCounter(): Int {
        return ++counter
    }
}
