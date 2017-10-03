package com.example.android.quizzapp;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    private RadioButton firstAnswer;
    private RadioButton secondAnswer;
    private RadioButton thirdAnswer;
    private RadioButton fourthAnswer;
    private RadioButton lastQuestionFirstAnswer;
    private RadioButton lastQuestionSecondAnswer;
    private RadioButton lastQuestionThirdAnswer;
    private CheckBox secondQuestionFirstAnswer;
    private CheckBox secondQuestionSecondAnswer;
    private CheckBox secondQuestionThirdAnswer;
    private EditText thirdQuestion;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstAnswer = (RadioButton) findViewById(R.id.first_answer_radio_button);
        secondAnswer = (RadioButton) findViewById(R.id.second_answer_radio_button);
        thirdAnswer = (RadioButton) findViewById(R.id.third_answer_radio_button);
        fourthAnswer = (RadioButton) findViewById(R.id.fourth_answer_radio_button);
        lastQuestionFirstAnswer = (RadioButton) findViewById(R.id.first_answer_radio_button2);
        lastQuestionSecondAnswer = (RadioButton) findViewById(R.id.second_answer_radio_button2);
        lastQuestionThirdAnswer = (RadioButton) findViewById(R.id.third_answer_radio_button2);
        secondQuestionFirstAnswer = (CheckBox) findViewById(R.id.first_answer_checkbox);
        secondQuestionSecondAnswer = (CheckBox) findViewById(R.id.second_answer_checkbox);
        secondQuestionThirdAnswer = (CheckBox) findViewById(R.id.third_answer_checkbox);
        thirdQuestion = (EditText) findViewById(R.id.third_question_edit_text);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int score = 0;
            if(secondAnswer.isChecked())
                score++;
            if(secondQuestionThirdAnswer.isChecked())
                score++;
            if(thirdQuestion.getText().toString().toLowerCase().equals("chuck norris"))
                score++;
            if(lastQuestionFirstAnswer.isChecked())
                score++;

            Toast.makeText(MainActivity.this, "Total Point " + score +"/4", Toast.LENGTH_SHORT).show();
        }
    };
}
