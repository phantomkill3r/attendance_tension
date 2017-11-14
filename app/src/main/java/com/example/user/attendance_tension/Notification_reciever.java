package com.example.user.attendance_tension;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by acer on 8/7/2017.
 */
public  class Notification_reciever extends WakefulBroadcastReceiver{
    Random rand = new Random();
    int unique = rand.nextInt();
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Notification building",Toast.LENGTH_SHORT).show();
        Bundle extras = intent.getExtras();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String subject = extras.getString("subject");
        Intent repeat_intent = new Intent(context,Counter.class);
        //repeat_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Toast.makeText(context,"holllll::::"+extras.getString("subject"),Toast.LENGTH_LONG).show();
        System.out.println("NR: "+subject);
        repeat_intent.putExtra("subject", subject);
        //PendingIntent rependingIntent = PendingIntent.getBroadcast(context,Integer.parseInt(extras.getString("time")),repeat_intent,PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent rependingIntent = PendingIntent.getBroadcast(context,unique,repeat_intent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(rependingIntent)
                .setSmallIcon(android.R.drawable.dark_header)
                .setContentTitle(extras.getString("subject")+" at "+ extras.getString("time"))
                .setContentText("Click if Present.")
                .setAutoCancel(true);

        Notification noti = builder.build();
        noti.flags = Notification.FLAG_AUTO_CANCEL;

        //notificationManager.notify(Integer.parseInt(extras.getString("time")),noti);
        notificationManager.notify(unique++, noti);
        Toast.makeText(context,"Notification fired",Toast.LENGTH_SHORT).show();


    }
}
