package com.example.updatedcaps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class scienceq extends AppCompatActivity {

    private Button button;
    private String username;
    private String gender;
    private String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scienceq);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve Intent extras
        Intent intent = getIntent();
        username = intent.getStringExtra("EXTRA_USERNAME");
        gender = intent.getStringExtra("EXTRA_GENDER");
        age = intent.getStringExtra("EXTRA_AGE");

        ImageButton numVidButton = findViewById(R.id.num_vid);

        numVidButton.setOnClickListener(v -> {
            Intent vidIntent = new Intent(scienceq.this, sciencevid.class);
            startActivity(vidIntent);
        });

        button = findViewById(R.id.one);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scienceq.this, activityscience1.class);
                startActivity(intent);
                finish();
            }
        });

        ImageButton buttonMore = findViewById(R.id.back);
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the user's age is 6
                if (age != null && age.equals("6")) {
                    // Create an Intent to start the home2 activity and pass the Intent extras
                    Intent homeIntent = new Intent(scienceq.this, more_age6.class);
                    homeIntent.putExtra("EXTRA_USERNAME", username);
                    homeIntent.putExtra("EXTRA_GENDER", gender);
                    homeIntent.putExtra("EXTRA_AGE", age);
                    startActivity(homeIntent);
                    finish(); // finish the more activity
                } else if (age != null && age.equals("5")) {
                    // Create an Intent to start the home1 activity and pass the Intent extras
                    Intent homeIntent = new Intent(scienceq.this, more.class);
                    homeIntent.putExtra("EXTRA_USERNAME", username);
                    homeIntent.putExtra("EXTRA_GENDER", gender);
                    homeIntent.putExtra("EXTRA_AGE", age);
                    startActivity(homeIntent);
                    finish(); // finish the more activity
                } else {
                    // Create an Intent to start the home activity and pass the Intent extras
                    Intent homeIntent = new Intent(scienceq.this, more.class);
                    homeIntent.putExtra("EXTRA_USERNAME", username);
                    homeIntent.putExtra("EXTRA_GENDER", gender);
                    homeIntent.putExtra("EXTRA_AGE", age);
                    startActivity(homeIntent);
                    finish(); // finish the more activity
                }
            }
        });
    }
}