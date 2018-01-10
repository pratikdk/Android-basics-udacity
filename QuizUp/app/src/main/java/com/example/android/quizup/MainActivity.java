package com.example.android.quizup;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

    //private HashMap<Integer, Integer> questionCorrectAnswersIDList = new HashMap<Integer, Integer>();

    private HashMap<Integer, Boolean> questionsAnsweredCorrectList = new HashMap<Integer, Boolean>();

    private ArrayList<View> checkedReferences = new ArrayList<View>();

    private int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
        toolbar.setContentInsetsAbsolute(0, 0);

        populateLists(correctAnswersID, questionID);

        ArrayList<CheckBox> questionTypeCheckBoxAnswers = new ArrayList<CheckBox>();
        ArrayList<RadioGroup> questionTypeRadioBoxRadioGroup = new ArrayList<RadioGroup>();

        for (int i = 0; i < questionIDList.size(); i++) {
            final LinearLayout layoutRoot = findViewById(questionIDList.get(i));
            int layoutRootChildCount = layoutRoot.getChildCount();

            if (layoutRoot.getChildAt(0) instanceof CheckBox) {
                final ArrayList<CheckBox> answerOptions = new ArrayList<CheckBox>();

                for (int j = 0; j < layoutRootChildCount; j++) {
                    answerOptions.add((CheckBox) layoutRoot.getChildAt(j));
                }
                for (CheckBox answerOption : answerOptions) {
                    answerOption.setOnClickListener(new View.OnClickListener() {
                        //int selectionCount = 0;
                        @Override
                        public void onClick(View view) {
                            CheckBox selectedCheckBox = (CheckBox) view;

                            int selectedCheckBoxID = selectedCheckBox.getId();

                            for (int answer : correctAnswersIDList) {

                                for (CheckBox eachAnswerCheckBox : answerOptions) {
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
                                        checkedReferences.add(selectedCheckBox);
                                        selectedCheckBox.setChecked(true);
                                        selectedCheckBox.setTextColor(Color.parseColor("#D32F2F"));

                                    }

                                    if (selectedCheckBoxID == answer && answer == eachAnswerCheckBoxId) {

                                        if (!questionsAnsweredCorrectList.get(layoutRoot.getId())) {
                                            totalScore += 1;
                                            questionsAnsweredCorrectList.put(layoutRoot.getId(), true);
                                        }
                                        checkedReferences.add(selectedCheckBox);
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
            }

            if (layoutRoot.getChildAt(0) instanceof RadioGroup) {
                RadioGroup radioGroup = (RadioGroup) layoutRoot.getChildAt(0);

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    boolean correctAnswer = false;

                    @Override
                    public void onCheckedChanged(RadioGroup answersRadioGroup, int checkedId) {
                        int selectedRadioGroupId = answersRadioGroup.getId();

                        RadioButton selectedRadioButton = (RadioButton) findViewById(checkedId);

                        int radioButtonsCount = answersRadioGroup.getChildCount();
                        ArrayList<RadioButton> answerOptions = new ArrayList<RadioButton>();

                        for (int j = 0; j < radioButtonsCount; j++) {
                            answerOptions.add((RadioButton) answersRadioGroup.getChildAt(j));
                        }

                        for (int answer : correctAnswersIDList) {
                            for (RadioButton answerOption : answerOptions) {
                                int answerOptionID = answerOption.getId();

                                if (answerOptionID != selectedRadioButton.getId()) {
                                    answerOption.setTextColor(Color.parseColor("#828991"));

                                }
                                if (answer != selectedRadioButton.getId() && answer == answerOptionID) {
                                    if (correctAnswer) {
                                        totalScore -= 1;
                                        correctAnswer = false;
                                    }
                                    checkedReferences.add(answersRadioGroup);
                                    selectedRadioButton.setTextColor(Color.parseColor("#D32F2F"));
                                }
                                if (answer == selectedRadioButton.getId() && answer == answerOptionID) {
                                    if (!correctAnswer) {
                                        totalScore += 1;
                                        correctAnswer = true;
                                    }
                                    checkedReferences.add(answersRadioGroup);
                                    selectedRadioButton.setTextColor(Color.parseColor("#ef9c2f"));
                                }

                            }
                        }

                        Toast.makeText(getApplicationContext(), "" + totalScore, Toast.LENGTH_SHORT).show();
                    }
                });

                questionTypeRadioBoxRadioGroup.add(radioGroup);

            }

        }

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
        for (int question : questions) {
            questionIDList.add(question);
        }

        for (int answer : answers) {
            correctAnswersIDList.add(answer);
        }

//        for (int i = 0; i < questionIDList.size(); i++) {
//            questionCorrectAnswersIDList.put(questionIDList.get(i), correctAnswersIDList.get(i));
//        }
        for (int i = 0; i < questionIDList.size(); i++) {
            questionsAnsweredCorrectList.put(questionIDList.get(i), false);
        }

    }

    public void resetScore(View v) {
        for (View eachReference: checkedReferences) {
            if (eachReference instanceof RadioGroup) {
                RadioGroup eachRadioGroup = ((RadioGroup) eachReference);
                eachRadioGroup.setOnCheckedChangeListener(null);
                eachRadioGroup.clearCheck();
            }
            if (eachReference instanceof CheckBox) {
                if (((CheckBox) eachReference).isChecked()) {
                    ((CheckBox) eachReference).toggle();
                }
            }
        }
        recreate();
        totalScore = 0;
        checkedReferences.clear();
    }

}
