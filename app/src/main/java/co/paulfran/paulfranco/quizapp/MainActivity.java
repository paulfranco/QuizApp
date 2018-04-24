package co.paulfran.paulfranco.quizapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultsTextView = (TextView) findViewById(R.id.resultsTextView);
        resultsTextView.setVisibility(View.INVISIBLE);

    }

    public void submitAnswers(View view) {

        EditText questionOneAnswerEditText = (EditText) findViewById(R.id.questionOneAnswerEditText);
        String answerOne = questionOneAnswerEditText.getText().toString().toLowerCase();
        Log.i("info", answerOne);

        EditText questionTwoAnswerEditText = (EditText) findViewById(R.id.questionTwoAnswerEditText);
        String answerTwo = questionTwoAnswerEditText.getText().toString().toLowerCase();
        Log.i("info", answerTwo);

        EditText questionThreeAnswerEditText = (EditText) findViewById(R.id.questionThreeAnswerEditText);
        String answerThree = questionThreeAnswerEditText.getText().toString().toLowerCase();
        Log.i("info", answerThree);

        EditText questionFourAnswerEditText = (EditText) findViewById(R.id.questionFourAnswerEditText);
        String answerFour = questionFourAnswerEditText.getText().toString().toLowerCase();
        Log.i("info", answerFour);

        EditText questionFiveAnswerEditText = (EditText) findViewById(R.id.questionFiveAnswerEditText);
        String answerFive = questionFiveAnswerEditText.getText().toString().toLowerCase();
        Log.i("info", answerFive);

        CheckBox trueCheckBox = (CheckBox) findViewById(R.id.trueCheckBox);
        boolean answeredTrue = trueCheckBox.isChecked();

        RadioButton yesRadioButton = (RadioButton) findViewById(R.id.yesRadioButton);
        boolean yes = yesRadioButton.isChecked();

        RadioButton noRadioButton = (RadioButton) findViewById(R.id.noRadioButton);
        boolean no = noRadioButton.isChecked();

        int results = calculateAnswers(answerOne, answerTwo, answerThree, answerFour, answerFive, answeredTrue, yes);
        displayResults(results);

    }

    public int calculateAnswers(String answerOne, String answerTwo, String answerThree, String answerFour, String answerFive, boolean answeredTrue, boolean yes) {
        int score = 0;
        if (answerOne.equals("blue")) {
            score = score + 1;
        }
        if (answerTwo.equals("aluminum")) {
            score = score + 1;
        }
        if (answerThree.equals("mercury")) {
            score = score + 1;
        }
        if (answerFour.equals("1998")) {
            score = score + 1;
        }
        if (answerFive.equals("toronto")){
            score = score + 1;
        }
        if (answeredTrue) {
            score = score + 1;
        }
        if (yes) {
            score = score + 1;
        }

        Log.i("info", String.valueOf(score));
        return score;
    }


    @SuppressLint("SetTextI18n")
    public void displayResults(int results){
        TextView resultsTextView = (TextView) findViewById(R.id.resultsTextView);
        resultsTextView.setVisibility(View.VISIBLE);
        if (results < 2) {
            resultsTextView.setText(" :0( You only answered " + String.valueOf(results) + " questions correctly");
        }
        if (results >= 3) {
            resultsTextView.setText(" YAY!!! You answered " + String.valueOf(results) + " questions correctly");
        }
    }



}
