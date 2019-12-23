package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button trueButton;
    private  Button falseButton;
    private TextView questionText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        falseButton=findViewById(R.id.false_button);
        trueButton= findViewById(R.id.true_button);
        questionText=findViewById(R.id.answer_text_view);

        falseButton.setOnClickListener(this); //using the interface View.onClickListener Ctrl+B
        trueButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.false_button:
                //context another way of setting context(Mainactivity.this, and getApplicationContext())
                Toast.makeText(MainActivity.this, "False",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.true_button:
                Toast.makeText(MainActivity.this,
                        "True", Toast.LENGTH_SHORT).show();
                break;




        }

    }
}
