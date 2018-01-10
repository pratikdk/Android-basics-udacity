package com.example.android.myquizapp;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    // set Arrays // Trash EditText
    private int[] correctAnswersID = {R.id.answer1_1, R.id.answer2_2, R.id.answer3_3, R.id.answer4_1};
    private int[] questionID = {R.id.question1, R.id.question2, R.id.question3, R.id.question4};

    private ArrayList<Integer> correctAnswersIDList = new ArrayList<Integer>();
    private ArrayList<Integer> questionIDList = new ArrayList<Integer>();
    private HashMap<Integer,Integer> questionCorrectAnswersIDList = new HashMap<Integer,Integer>();
    private HashMap<Integer,Boolean> questionsAnsweredCorrectList = new HashMap<Integer,Boolean>();

    private int totalScore = 0;
    // flags
    private boolean correctAnswerFlag = false;
    private boolean questionChange = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//
//            //window.getDecorView().setSystemUiVisibility(
//            //        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//            //                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//
//            //window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            //window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
//            //window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//            //window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//            //window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            //window.setStatusBarColor(Color.BLUE);
//        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
        toolbar.setContentInsetsAbsolute(0,0);

        //LinearLayout layout = findViewById(R.id.question1);
        //int count = layout.getChildCount();
        //Log.i("Death", "This is the fucking child count" + count);
        //boolean validity = (questionID[0] == R.id.question1) ? true : false;
        //Log.i("Death", "lets try with index 0 " + validity);

        populateLists(correctAnswersID, questionID);
//        boolean validity = questionIDList.get(0) == R.id.question1;
//        Log.i("Death", "lets try with index 0 " + questionIDList.get(0));
//        Log.i("Death", "lets try with index 0 " + validity);

        // Keep em live
        ArrayList<CheckBox> questionTypeCheckBoxAnswers = new ArrayList<CheckBox>();
        ArrayList<RadioGroup> questionTypeRadioBoxRadioGroup = new ArrayList<RadioGroup>();

        int filledTimeCount = 0;
        for (int i = 0; i < questionIDList.size(); i++){
            final LinearLayout layoutRoot = findViewById(questionIDList.get(i));
            int layoutRootChildCount = layoutRoot.getChildCount();

            if (layoutRoot.getChildAt(0) instanceof CheckBox) {
                final ArrayList<CheckBox> answerOptions = new ArrayList<CheckBox>();
                //Log.i("Death", "questionIDList.size(): " + questionIDList.size());
                //Log.i("Death", "lets try with index 0, Instance of CheckBox: " + true);
                for (int j=0; j < layoutRootChildCount; j++) {
                    answerOptions.add((CheckBox) layoutRoot.getChildAt(j));
                }
                //correctAnswerFlag = false;
                //Log.i("Death", "answerOptions.size(): " + answerOptions.size());
                for (CheckBox answerOption: answerOptions) {
                    answerOption.setOnClickListener(new View.OnClickListener() {
                        //int selectionCount = 0;
                        @Override
                        public void onClick(View view) {
                            CheckBox selectedCheckBox = (CheckBox) view;

                            int selectedCheckBoxID = selectedCheckBox.getId();
                            //Toast.makeText(getApplicationContext(), "" + answerOption.getText(), Toast.LENGTH_SHORT).show();
                            for (int answer: correctAnswersIDList) {

                                for (CheckBox eachAnswerCheckBox: answerOptions) {
                                    int eachAnswerCheckBoxId = eachAnswerCheckBox.getId();

                                    if (eachAnswerCheckBoxId != selectedCheckBoxID) {
                                        eachAnswerCheckBox.setChecked(false);
                                        eachAnswerCheckBox.setTextColor(Color.parseColor("#828991"));
                                    }

                                    if (answer != selectedCheckBoxID && answer == eachAnswerCheckBoxId) {
                                        if (questionsAnsweredCorrectList.get(layoutRoot.getId())) {
                                            totalScore -= 1;
                                            questionsAnsweredCorrectList.put(layoutRoot.getId(), false);
                                        }
                                        selectedCheckBox.setChecked(true);
                                        selectedCheckBox.setTextColor(Color.parseColor("#D32F2F"));
//                                        if (correctAnswerFlag) {
//                                            correctAnswerFlag = false;
//                                        } else if (correctAnswerFlag) {
//                                            totalScore -= 1;
//                                            correctAnswerFlag = false;
//                                        }

                                    }

                                    if (selectedCheckBoxID == answer && answer == eachAnswerCheckBoxId) {
//                                        if (correctAnswerFlag && questionChange) {
//                                            correctAnswerFlag = false;
//                                            questionChange = false;
//                                        }
//                                        if (!correctAnswerFlag && !questionChange) {
//                                            totalScore += 1;
//                                            correctAnswerFlag = true;
//                                        }
                                        //Toast.makeText(getApplicationContext(), "" + this.getFlag(), Toast.LENGTH_SHORT).show();
//                                        if (selectionCount == 0) {
//                                            totalScore += 1;
//                                            selectionCount += 1;
//                                        }
                                        if (!questionsAnsweredCorrectList.get(layoutRoot.getId())) {
                                            totalScore += 1;
                                            questionsAnsweredCorrectList.put(layoutRoot.getId(), true);
                                        }
                                        selectedCheckBox.setChecked(true);
                                        selectedCheckBox.setTextColor(Color.parseColor("#ef9c2f"));
                                        break;
                                    }

                                }
                            }
                            Toast.makeText(getApplicationContext(), "" + totalScore, Toast.LENGTH_SHORT).show();
                        }
                    });
                    questionTypeCheckBoxAnswers.add(answerOption);
                }
                //filledTimeCount++;
            }

            if (layoutRoot.getChildAt(0) instanceof RadioGroup) {
//                boolean validity = (layoutRoot.getChildAt(0) instanceof RadioGroup);
//                Log.i("Death", "RadioGroup instance incoming: " + validity);
                RadioGroup radioGroup = (RadioGroup) layoutRoot.getChildAt(0);
                //Log.i("Death", "Total elements in RadioGroup: " + radioGroup.getChildCount());

//                boolean validity = radioGroup.getId() == questionTypeRadioBoxRadioGroup.get(questionTypeRadioBoxRadioGroup.size() - 1).getId();
//                Log.i("Death", "Is radioGroup we dealing with the same that we just added :" + validity);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    boolean correctAnswer = false;
                    @Override
                    public void onCheckedChanged(RadioGroup answersRadioGroup, int checkedId) {
                        int selectedRadioGroupId = answersRadioGroup.getId();
//                        Toast.makeText(getApplicationContext(), "" + ((RadioButton)findViewById(checkedId)).getText(), Toast.LENGTH_SHORT).show();
                        RadioButton selectedRadioButton = (RadioButton)findViewById(checkedId);

                        int radioButtonsCount = answersRadioGroup.getChildCount();
                        ArrayList<RadioButton> answerOptions = new ArrayList<RadioButton>();

                        for (int j = 0; j < radioButtonsCount; j++) {
                            answerOptions.add((RadioButton) answersRadioGroup.getChildAt(j));
                        }
//                        Toast.makeText(getApplicationContext(), "" + answerOptions.size(), Toast.LENGTH_SHORT).show();


                        for (int answer: correctAnswersIDList) {
                            for (RadioButton answerOption: answerOptions) {
                                int answerOptionID = answerOption.getId();
                                //fucked if up logic
//                                if (answerOptionID != selectedRadioButton.getId()) {
//                                    answerOption.setTextColor(Color.parseColor("#828991"));
//                                }
//                                if (answer == answerOptionID && answerOptionID != selectedRadioButton.getId()) {
//                                    selectedRadioButton.setTextColor(Color.parseColor("#D32F2F"));
//                                }
//                                if (answer == answerOptionID && answerOptionID == selectedRadioButton.getId()) {
//                                    selectedRadioButton.setTextColor(Color.parseColor("#ef9c2f"));
//                                    break;
//                                }
                                //Corrected logic
                                if (answerOptionID != selectedRadioButton.getId()) {
                                    answerOption.setTextColor(Color.parseColor("#828991"));

                                }
                                if (answer != selectedRadioButton.getId() && answer == answerOptionID) {
                                    Log.i("Death", "value of correctAnswer :" + correctAnswer);
                                    if (correctAnswer) {
                                        Log.i("Death", "The error has been visited and value of total score is :" + totalScore);
                                        totalScore -= 1;
                                        Log.i("Death", "The error has been visited .. value of total score after :" + totalScore);
                                        correctAnswer = false;
                                    }
                                    selectedRadioButton.setTextColor(Color.parseColor("#D32F2F"));
                                }
                                if (answer == selectedRadioButton.getId() && answer == answerOptionID) {
                                    if (!correctAnswer) {
                                        totalScore += 1;
                                        correctAnswer = true;
                                    }
                                    selectedRadioButton.setTextColor(Color.parseColor("#ef9c2f"));
                                    //break;
                                }

                            }
                        }


//                        switch (checkedId) {
//                            case R.id.button1:
//
//                                // Do something
//                                Toast.makeText(getApplicationContext(), radioButton1.getText() + " clicked", Toast.LENGTH_SHORT).show();
//                                break;
//
//                            case R.id.button2:
//
//                                // Do something
//                                Toast.makeText(getApplicationContext(), radioButton2.getText() + " clicked", Toast.LENGTH_SHORT).show();
//                                break;
//
//                        }
                        Toast.makeText(getApplicationContext(), "" + totalScore, Toast.LENGTH_SHORT).show();
                    }
                });

                questionTypeRadioBoxRadioGroup.add(radioGroup);

            }

//            for (int j=0; j < answerElementsCount; j++) {
//                answerOptions.add(layoutRoot.getChildAt(j));
//            }

        }
        //Log.i("Death", "Filled times Count " + filledTimeCount);


        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_actionbar));


    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void populateLists(int[] answers, int[] questions) {
        for (int question: questions) {
            questionIDList.add(question);
        }

        for (int answer: answers) {
            correctAnswersIDList.add(answer);
        }

        for (int i = 0; i < questionIDList.size(); i++) {
            questionCorrectAnswersIDList.put(questionIDList.get(i), correctAnswersIDList.get(i));
        }
        for (int i = 0; i < questionIDList.size(); i++) {
            questionsAnsweredCorrectList.put(questionIDList.get(i), false);
        }

    }

    public void resetScore() {
        totalScore = 0;
    }


}
