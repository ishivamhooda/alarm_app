package com.example.alarm_demo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer

class MyBroadcasteRecevier: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var mp:MediaPlayer =MediaPlayer.create(context,R.raw.alarm)
        mp.start()
    }
}