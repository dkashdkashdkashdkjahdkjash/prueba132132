package com.example.practicacreacindeunmonitordeconectividaddered

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
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
            val manager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = manager.activeNetwork
            textview = findViewById<TextView>(R.id.textView)
            if(networkInfo == null){
                textview.setTextColor(Color.RED)
                textview.text = "No hay conexion a internet"
            }else{
                manager.getNetworkCapabilities(networkInfo)?.run {
                    if(hasTransport(NetworkCapabilities.TRANSPORT_WIFI)){
                        textview.setTextColor(Color.GREEN)
                        textview.text = "Estas conectado a una wifi"
                    }else if(hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)){
                        textview.setTextColor(Color.BLUE)
                        textview.text = "Estas usando datos"
                    }else{
                        textview.setTextColor(Color.YELLOW)
                        textview.text = "Estas usando una conexion desconocida"
                    }
                }
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(wifiConnectionReceiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(wifiConnectionReceiver)
    }
}