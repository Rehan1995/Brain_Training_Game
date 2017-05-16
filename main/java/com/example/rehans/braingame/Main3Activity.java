package com.example.rehans.braingame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void sendMode(View view)
    {
        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(intent);
    }
    public void sendeasy(View view)
    {
        Intent intent = new Intent(Main3Activity.this, MainActivityeasy.class);
        startActivity(intent);
    }
    public void sendmedium(View view)
    {
        Intent intent = new Intent(Main3Activity.this, MainActivitymedium.class);
        startActivity(intent);
    }
    public void sendhard(View view)
    {
        Intent intent = new Intent(Main3Activity.this, MainActivitymedium.class);
        startActivity(intent);
    }
}
