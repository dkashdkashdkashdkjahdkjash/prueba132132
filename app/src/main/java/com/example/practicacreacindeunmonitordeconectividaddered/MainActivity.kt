package com.example.practicacreacindeunmonitordeconectividaddered

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var textview : TextView



    private val wifiConnectionReceiver = object : BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            val manager = Context.CONNECTIVITY_SERVICE

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview = findViewById(R.id.textView)

        //registerReceiver(wifiConnectionReceiver, IntentFilter(Intent.))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(wifiConnectionReceiver)
    }
}