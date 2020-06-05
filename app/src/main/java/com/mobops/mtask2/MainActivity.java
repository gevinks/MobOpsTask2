package com.mobops.mtask2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view){
        Intent myIntent = new Intent(getBaseContext(),Add.class);
        startActivity(myIntent);
    }

    public void clickHandler(View view){
        DB= openOrCreateDatabase("DetailsDb",MODE_PRIVATE,null);
        Cursor result=null;
        try {
            result = DB.rawQuery("SELECT * FROM DetailsTable;", null);
        }
        catch (Exception e){
            Toast toast = Toast.makeText(this,"Empty List", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        if(result==null){
            Toast toast = Toast.makeText(this,"Empty List", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }else{
            Intent myIntent = new Intent(getBaseContext(), Display.class);
            startActivity(myIntent);
        }
    }
}
