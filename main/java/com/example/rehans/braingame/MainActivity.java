package com.example.rehans.braingame;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private int level = 0, answer = 0, operator = 0, num1 = 0, num2 = 0;
    private final int add = 0, sub = 1, mul = 2, div = 3;
    private String[] operators = {"+", "-", "x", "/"};
    private int[][] levelMin = {
            {1, 11, 21},
            {1, 5, 10},
            {2, 5, 10},
            {2, 3, 5}};
    private int[][] levelMax = {
            {10, 25, 50},
            {10, 20, 30},
            {5, 10, 15},
            {10, 50, 100}};
    private Random random;

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bDel, bHash, bMinus;
    TextView textView4, textView, textView3,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        random = new Random();

        setContentView(R.layout.activity_main);


        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        b0 = (Button) findViewById(R.id.b0);
        bDel = (Button) findViewById(R.id.bDel);
        bHash = (Button) findViewById(R.id.bHash);
        bMinus = (Button) findViewById(R.id.bMinus);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView = (TextView) findViewById(R.id.textView);
        textView3 = (TextView) findViewById(R.id.textView3);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "0");
            }
        });

        bDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView myTextView = (TextView) findViewById(R.id.textView4);
                textView.setText("");
            }
        });

        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.setText(textView4.getText() + "-");
            }
        });




        chooseQuestion();

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                textView4.setText("Time Remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textView4.setText("Time Up!");
            }
        }.start();
    }


    private void chooseQuestion() {

        operator = random.nextInt(operators.length);
        num1 = getOperator();
        num2 = getOperator();
        if (operator == sub) {
            while (num2 > num1) {
                num1 = getOperator();
                num2 = getOperator();
            }
        } else if (operator == div) {
            while ((((double) num1 / (double) num2) % 1 > 0) || (num1 == num2)) {
                num1 = getOperator();
                num2 = getOperator();
            }
        }
        switch (operator) {
            case add:
                answer = num1 + num2;
                break;
            case sub:
                answer = num1 - num2;
                break;
            case mul:
                answer = num1 * num2;
                break;
            case div:
                answer = num1 / num2;
                break;
            default:
                break;
        }

            textView3.setText(num1 + " " + operators[operator] + " " + num2);


            bHash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (v.getId() == R.id.bHash) {

                        String answerCo = textView.getText().toString();
                        int Ans = Integer.parseInt(answerCo);

                        if (Ans == answer) {

                            TextView textView2 = (TextView) findViewById(R.id.textView2);
                            textView2.setText("Correct!");

                        } else {
                            TextView textView2 = (TextView) findViewById(R.id.textView2);
                            textView2.setText("Incorrect!");
                        }

                        chooseQuestion();
                        textView.setText
                                ("");

                    }


                }


            });

        Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {

            finish();
            }
        }, 30000);

    }



    public int getOperator() {
        return random.nextInt(levelMax[operator][level] - levelMin[operator][level] + 1)
                + levelMin[operator][level];    }

    public int getScore() {
        String scoreStr = textView4.getText().toString();
        return Integer.parseInt(scoreStr.substring(scoreStr.lastIndexOf(" ")+1));
    }


}

