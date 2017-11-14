package com.example.user.attendance_tension;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by acer on 8/16/2017.
 */

public class StartApp extends Activity
{
    Button setTT_butt,view_TT ;
    SQLiteDatabase mydatabase ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        mydatabase = openOrCreateDatabase("Attendance", MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS SUBJECTS(Subjects VARCHAR primary key,Present Integer);");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS monday(time time(0) primary key, subject VARCHAR,foreign key (subject) references SUBJECTS(Subjects));");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS tuesday(time time(0) primary key, subject VARCHAR,foreign key (subject) references SUBJECTS(Subjects));");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS wednesday(time time(0) primary key, subject VARCHAR,foreign key (subject) references SUBJECTS(Subjects));");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS thursday(time time(0) primary key, subject VARCHAR,foreign key (subject) references SUBJECTS(Subjects));");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS friday(time time(0) primary key, subject VARCHAR,foreign key (subject) references SUBJECTS(Subjects));");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS saturday(time time(0) primary key, subject VARCHAR,foreign key (subject) references SUBJECTS(Subjects));");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS sunday(time time(0) primary key, subject VARCHAR,foreign key (subject) references SUBJECTS(Subjects));");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS temp(time time(0) primary key,subject VARCHAR);");


        setTT_butt = (Button)findViewById(R.id.setTT_butt);
        view_TT = (Button)findViewById(R.id.viewTT_butt);

        setTT_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartApp.this,MainActivity.class));
            }
        });

        view_TT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartApp.this,ViewTimeTable.class));
            }
        });
    }
}
