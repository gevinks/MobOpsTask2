package com.mobops.mtask2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Display extends AppCompatActivity {

    SQLiteDatabase DB;
    TextView textview1,textview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        DB= openOrCreateDatabase("DetailsDb",MODE_PRIVATE,null);
        Cursor result;
        String dis_name;
        String dis_age;
        result = DB.rawQuery("SELECT * FROM DetailsTable;",null);
        result.moveToFirst();
        textview1 = findViewById(R.id.textView2);
        textview2 = findViewById(R.id.textView4);
        String name3 = result.getString(0);
        String age3 = result.getString(1);
        dis_name=name3 +"\n";
        dis_age=age3 +"\n";
        while (result.moveToNext()) {
            name3 = result.getString(0);
            age3 = result.getString(1);
            dis_age=dis_age+ age3 +"\n";
            dis_name =dis_name+ name3 +"\n";

        }
        textview1.setText(dis_name);
        textview2.setText(dis_age);

    }
}