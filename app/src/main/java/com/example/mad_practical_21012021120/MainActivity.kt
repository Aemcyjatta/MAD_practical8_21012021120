package com.example.mad_practical_21012021120

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun setalarm(militime:Long,action:String){
        val intentalarm=Intent(applicationContext,AlarmBroadcastReceiver::class.java)
        intentalarm.putExtra(AlarmBroadcastReceiver.ALARMKEY,action)
        val pendingIntent=PendingIntent.getBroadcast(applicationContext,4345,intentalarm,PendingIntent.FLAG_UPDATE_CURRENT)
        val manager=getSystemService(ALARM_SERVICE) as AlarmManager
        if(action==AlarmBroadcastReceiver.ALARMSTART){
            manager.setExact(AlarmManager.RTC_WAKEUP,militime,pendingIntent)
        }
        else{
            manager.cancel(pendingIntent)
            sendBroadcast(intentalarm)
        }
    }
}