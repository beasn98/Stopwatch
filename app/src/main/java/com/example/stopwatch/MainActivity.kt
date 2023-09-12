package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    lateinit var stopwatch: Chronometer
    lateinit var startStop: Button
    lateinit var reset: Button

    companion object {
        val TAG = "MainActivity"

        val ASTROPHYSICISTS_PI = 3
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: This is onCreate")
        wireWidgets()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: This is onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: This is onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: This is onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: This is onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: This is onDestroy")
    }


    private fun wireWidgets() {
        stopwatch = findViewById(R.id.chronometer_main_stopwatch)
        startStop = findViewById(R.id.button_main_startStop)
        reset = findViewById(R.id.button_main_reset)
    }
}