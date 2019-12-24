package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button trueButton;
    private Button falseButton;
    private TextView questionText;
    private Button nextButton;
    private int currentIndex = 0;

    private Question[] questionBank = new Question[]{
            new Question(R.string.perpendicular_question, false),
            new Question(R.string.product_question, false),
            new Question(R.string.slope_question, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        questionText = findViewById(R.id.answer_text_view);
        nextButton = findViewById(R.id.next_button);


        falseButton.setOnClickListener(this); //using the interface View.onClickListener Ctrl+B
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.false_button:
                //context another way of setting context(Mainactivity.this, and getApplicationContext())
//                Toast.makeText(MainActivity.this, "False",
//                        Toast.LENGTH_SHORT).show();

                isAnswerCorrect(false);
                break;
            case R.id.true_button:
                
                isAnswerCorrect(true);
                break;

            case R.id.next_button:
                //on to the next question

                currentIndex = (currentIndex + 1) % questionBank.length;
                nextButtonUpdate();

        }

    }

    public void nextButtonUpdate() {
        Log.d("Current", "onClick: " + currentIndex);
        questionText.setText(questionBank[currentIndex].getAnswerResID());
    }

    public void isAnswerCorrect(boolean answer) {
        boolean temp = questionBank[currentIndex].isAnswerTrue();
        int toastID = 0;

        if (answer == temp) {
            toastID = R.string.correct_answer;
        } else {
            toastID = R.string.incorrect_answer;
        }
        Toast.makeText(MainActivity.this, toastID, Toast.LENGTH_SHORT).show();

    }
}
