package com.example.rehans.braingame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main_start extends AppCompatActivity {

    Button bAbout;
    Button bExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);
        bExit = (Button) findViewById(R.id.bExit);
        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });
    }
    public void sendMessage(View view)
    {
        Intent intent = new Intent(Main_start.this, Main3Activity.class);
        startActivity(intent);
    }
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(Html.fromHtml("<b>"+"How to Play!"+"</b>"+"</b>"+"<br>"+"1.You have 4 options to choose."
                +"<br>"+"2.Each game option has 10 rounds to play."+"<br>"+"3.Soon after game starts countdown will start."));

        alertDialogBuilder.setPositiveButton("Got it",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(Main_start.this,"You have read the Rules!", Toast.LENGTH_LONG).show();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}



