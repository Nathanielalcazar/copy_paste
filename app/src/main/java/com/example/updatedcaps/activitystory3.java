package com.example.updatedcaps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import pl.droidsonroids.gif.GifImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import com.bumptech.glide.Glide;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activitystory3 extends AppCompatActivity {

    private RadioGroup question1RadioGroup;
    private TextView attemptsTextView;
    private Button submitButton;
    private Button nextButton;
    private Button tryAgainButton;
    private TextView resultTextView;
    private GifImageView gifImageView;
    private int currentQuestion = 1;
    private int incorrectAttempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitystory3);
        question1RadioGroup = findViewById(R.id.question1_radio_group);
        submitButton = findViewById(R.id.submit_button);
        nextButton = findViewById(R.id.next_button);
        tryAgainButton = findViewById(R.id.try_again_button);
        nextButton.setVisibility(View.GONE);
        tryAgainButton.setVisibility(View.GONE);
//        gifImageView = findViewById(R.id.my_gif_image_view);
//        gifImageView.setImageResource(R.drawable.my_gif); //
        attemptsTextView = findViewById(R.id.attempts_textview);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion == 1) {
                    if (question1RadioGroup.getCheckedRadioButtonId() == R.id.question1_answer1) {
                        Toast.makeText(activitystory3.this, "Question 1: Correct! Way To Go!!!", Toast.LENGTH_SHORT).show();
                        nextButton.setVisibility(View.VISIBLE);
                        submitButton.setVisibility(View.GONE);
                    } else {
                        Toast.makeText(activitystory3.this, "Question 1: Incorrect. Try Again", Toast.LENGTH_SHORT).show();
                        tryAgainButton.setVisibility(View.VISIBLE);
                        submitButton.setVisibility(View.GONE);
                        incorrectAttempts++;
                        attemptsTextView.setText("Incorrect attempts: " + incorrectAttempts);
                    }
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activitystory3.this, activitystory4.class);
                startActivity(intent);
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
    }}