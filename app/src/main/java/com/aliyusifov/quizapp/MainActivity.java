package com.aliyusifov.quizapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_1,true),
            new TrueFalse(R.string.question_2,true),
            new TrueFalse(R.string.question_3,true),
            new TrueFalse(R.string.question_4,true),
            new TrueFalse(R.string.question_5,true),
            new TrueFalse(R.string.question_6,false),
            new TrueFalse(R.string.question_7,true),
            new TrueFalse(R.string.question_8,false),
            new TrueFalse(R.string.question_9,true),
            new TrueFalse(R.string.question_10,true),
            new TrueFalse(R.string.question_11,false),
            new TrueFalse(R.string.question_12,false),
            new TrueFalse(R.string.question_13,true),


    };
    final  int PROGRESS_BAR_INCREMENT=8;
    Button mTrueButton;
    Button mFalseButton;
    TextView mQuestionTextView;
    int mIndex;
    int mQuestion;
    TextView scoreTextView;
    ProgressBar progressBar;
    int score;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mQuestionTextView = findViewById(R.id.question_text_view);
        scoreTextView = findViewById(R.id.score);
        progressBar = findViewById(R.id.progress_bar);

        mQuestion = mQuestionBank[mIndex].getQuestionID();
        mQuestionTextView.setText(mQuestion);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateQuestion();
            }
        });

        
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateQuestion();
            }
        });

    }

    private  void updateQuestion(){
        mIndex = (mIndex+1) % mQuestionBank.length;
        if (mIndex == 0){
            AlertDialog.Builder alert= new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("You scored "+score+" points!");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
        }
        mQuestion = mQuestionBank[mIndex].getQuestionID();
        mQuestionTextView.setText(mQuestion);
        progressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        scoreTextView.setText("Score:"+score+"/"+mQuestionBank.length);

    }

    private void checkAnswer(boolean userSelection){
        boolean correctAnswer = mQuestionBank[mIndex].isAnswer();
        if (userSelection == correctAnswer){
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            score++;
        }
        else {
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
        //63 video last watched
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ScoreKey",score);
        outState.putInt("IndexKey",mIndex);
    }
}