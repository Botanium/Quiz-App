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
import android.widget.RadioGroup;
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

    private RadioGroup firstQuestion;
    private RadioGroup lastQuesiton;
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
        firstQuestion = (RadioGroup) findViewById(R.id.first_question_radio_group);
        lastQuesiton = (RadioGroup) findViewById(R.id.forth_question_radio_group);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(onClickListener);

    }

    // function to check if the any checkbox is checked and return the valus for validation
    private boolean checkCheckBox(CheckBox... checkBoxes){
        for (CheckBox checkBox: checkBoxes){
            checkBox.isChecked();
            return true;
        }
        return false;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // checking if all the questions are answered.
            if(checkCheckBox(secondQuestionFirstAnswer, secondQuestionSecondAnswer, secondQuestionThirdAnswer) && thirdQuestion.length() > 0 && firstQuestion.getCheckedRadioButtonId() !=-1 && lastQuesiton.getCheckedRadioButtonId() !=-1) {
                int score = 0;
                if (secondAnswer.isChecked())
                    score++;
                if (secondQuestionFirstAnswer.isChecked() && secondQuestionSecondAnswer.isChecked() && !secondQuestionThirdAnswer.isChecked())
                    score++;
                if (thirdQuestion.getText().toString().equalsIgnoreCase("chuck norris"))
                    score++;
                if (lastQuestionFirstAnswer.isChecked())
                    score++;
                // if all the questions are answered then calculate
                Toast.makeText(MainActivity.this, "Total Point " + score + "/4", Toast.LENGTH_SHORT).show();
            }
            //tell the user to answer all the questions
            else
                Toast.makeText(MainActivity.this, "Please Answer All Questions", Toast.LENGTH_SHORT).show();
        }
    };
}
