package com.example.updatedcaps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activitynum5 extends AppCompatActivity {

    private RadioGroup question1RadioGroup;
    private TextView attemptsTextView;
    private Button submitButton;
    private Button nextButton;
    private Button tryAgainButton;
    private TextView resultTextView;
    private int currentQuestion = 1;
    private int incorrectAttempts = 0; // new

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitynum5);
        question1RadioGroup = findViewById(R.id.question1_radio_group);
        submitButton = findViewById(R.id.submit_button);
        nextButton = findViewById(R.id.next_button);
        tryAgainButton = findViewById(R.id.try_again_button);
        nextButton.setVisibility(View.GONE);
        tryAgainButton.setVisibility(View.GONE);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion == 1) {
                    if (question1RadioGroup.getCheckedRadioButtonId() == R.id.question1_answer1) {
                        Toast.makeText(activitynum5.this, "Question 1: Correct! Way To Go!!!", Toast.LENGTH_SHORT).show();
                        nextButton.setVisibility(View.VISIBLE);
                        submitButton.setVisibility(View.GONE);
                    } else {
                        Toast.makeText(activitynum5.this, "Question 1: Incorrect. Try Again", Toast.LENGTH_SHORT).show();
                        tryAgainButton.setVisibility(View.VISIBLE);
                        submitButton.setVisibility(View.GONE);
                        incorrectAttempts++; // increment incorrect attempts
                    }

                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(activitynum5.this, activitynum6.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion == 1) {
                    question1RadioGroup.clearCheck();
                }
                tryAgainButton.setVisibility(View.GONE);
                submitButton.setVisibility(View.VISIBLE);
            }
        });

        attemptsTextView = findViewById(R.id.attempts_textview);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion == 1) {
                    if (question1RadioGroup.getCheckedRadioButtonId() == R.id.question1_answer1) {
                        Toast.makeText(activitynum5.this, "Question 1: Correct! Way To Go!!!", Toast.LENGTH_SHORT).show();
                        nextButton.setVisibility(View.VISIBLE);
                        submitButton.setVisibility(View.GONE);
                    } else {
                        Toast.makeText(activitynum5.this, "Question 1: Incorrect. Try Again", Toast.LENGTH_SHORT).show();
                        tryAgainButton.setVisibility(View.VISIBLE);
                        submitButton.setVisibility(View.GONE);
                        incorrectAttempts++;
                        attemptsTextView.setText("Incorrect attempts: " + incorrectAttempts);
                    }

                }
            }
        });
    }
}