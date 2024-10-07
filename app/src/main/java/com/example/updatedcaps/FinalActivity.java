package com.example.updatedcaps;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent; // Add this import statement

public class FinalActivity extends AppCompatActivity {

    private TextView percentageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        percentageTextView = findViewById(R.id.percentage_textview);

        Intent intent = getIntent();
        int correctAnswers = intent.getIntExtra("correctAnswers", 0);
        int totalQuestions = intent.getIntExtra("totalQuestions", 0);

        if (totalQuestions == 0) {
            percentageTextView.setText("No questions answered.");
        } else {
            float percentage = (float) correctAnswers / totalQuestions * 100;
            String percentageString = String.format("%.2f", percentage) + "%";
            percentageTextView.setText("Your score: " + percentageString);
        }
    }
}