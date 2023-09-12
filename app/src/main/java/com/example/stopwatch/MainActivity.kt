package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    lateinit var stopwatch: Chronometer
    lateinit var startStop: Button
    lateinit var reset: Button
    var pausedTime = 0
    var isRunning = false
    var displayTime = 0L

    companion object {
        val TAG = "MainActivity"

        //make constants for your key-value pairs
        val STATE_DISP_TIME = "The display time"
        val STATE_IS_RUNNING = "Whether the stopwatch is running or not"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: This is onCreate")

        wireWidgets()
        //Restore the savedInstanceState if it exists
        if (savedInstanceState != null) {
            displayTime = savedInstanceState.getLong(STATE_DISP_TIME)
            stopwatch.base = SystemClock.elapsedRealtime() - displayTime
            isRunning = savedInstanceState.getBoolean(STATE_IS_RUNNING)
        }


        startStop.setOnClickListener {
            if(!isRunning) {
                isRunning = true
                stopwatch.setBase(SystemClock.elapsedRealtime() + pausedTime)
                startStop.text="Stop"
                stopwatch.start()
            }
            else {
                isRunning = false
                pausedTime = (stopwatch.base - SystemClock.elapsedRealtime()).toInt()
                startStop.text = "Start"
                stopwatch.stop()
            }

        }

        reset.setOnClickListener {
            stopwatch.stop()
            stopwatch.setBase(SystemClock.elapsedRealtime())
            isRunning = false
            startStop.text = "Start"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        //Figure out the time that is currently displayed on the screen and save that in a key value pair in the bundle
        if(!isRunning) {
            displayTime = SystemClock.elapsedRealtime() - stopwatch.base
            //solve for base: base = elapsedTime - displayTime
        }
            //If it weren't running, you would have saved the displayTime in the start button's onClickListener

        //save key-value pairs to the bundle before the superclass call
        outState.putLong(STATE_DISP_TIME, displayTime)
        super.onSaveInstanceState(outState)

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