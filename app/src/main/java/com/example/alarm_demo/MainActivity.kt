package com.example.alarm_demo

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn:Button=findViewById(R.id.button)
        var btn2:Button=findViewById(R.id.button2)
        var btn3:Button=findViewById(R.id.button3)
        var et:EditText=findViewById(R.id.editTextNumber)
        val flag=0

        val i=Intent(applicationContext,MyBroadcasteRecevier::class.java)
        //pedning intent
        val pi:PendingIntent=PendingIntent.getBroadcast(applicationContext,111,i,
            PendingIntent.FLAG_IMMUTABLE)

        var alarmManager:AlarmManager

        btn.setOnClickListener {
            var sec=et.text.toString().toInt()
            alarmManager=getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + (sec * 1000),pi)
            Toast.makeText(this,"alarm set after $sec seconds",Toast.LENGTH_LONG).show()
        }
        btn2.setOnClickListener {
            alarmManager=getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(pi)
            Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show()
        }


        btn3.setOnClickListener {
            alarmManager=getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),5000,pi)
        }
    }
}