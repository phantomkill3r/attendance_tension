package com.example.user.attendance_tension;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private Cursor resultSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("Attendance",MODE_PRIVATE,null);

        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS subjects(Subjects VARCHAR);");

        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);

        final EditText editText1= (EditText) findViewById(R.id.editText);

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String subject= editText1.getText().toString();
                mydatabase.execSQL("INSERT INTO subjects VALUES('"+subject+ "');");
                editText1.setText("");

                resultSet = mydatabase.rawQuery("Select * from Subjects",null);
                resultSet.moveToLast();
                String a = resultSet.getString(0);

                System.out.println(a);
                resultSet.moveToNext();


            }

        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                resultSet = mydatabase.rawQuery("Select * from Subjects",null);
                resultSet.moveToFirst();
                String a;

                for(int i=0;i<resultSet.getCount();i++) {
                    a = resultSet.getString(0);
                    System.out.println(a);
                    resultSet.moveToNext();
                }
            }

        });

        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


             mydatabase.execSQL("Delete from Subjects");

            }

        });

        button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                sendMessage();

            }

        });







    }

    public void sendMessage() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }




}
