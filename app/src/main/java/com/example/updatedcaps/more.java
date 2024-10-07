package com.example.updatedcaps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class more extends AppCompatActivity {

    private String username;
    private String gender;
    private String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_more);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the Intent extras
        Intent intent = getIntent();
        username = intent.getStringExtra("EXTRA_USERNAME");
        gender = intent.getStringExtra("EXTRA_GENDER");
        age = intent.getStringExtra("EXTRA_AGE");

        ImageButton imageButton1 = findViewById(R.id.imageButton4);
        ImageButton imageButton2 = findViewById(R.id.imageButton5);
        ImageButton imageButton3 = findViewById(R.id.imageButton2);
        ImageButton imageButton4 = findViewById(R.id.imageButton3);

        // Set up OnClickListeners for the ImageButtons
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the mathq activity and pass the Intent extras
                Intent mathqIntent = new Intent(more.this, mathq.class);
                mathqIntent.putExtra("EXTRA_USERNAME", username);
                mathqIntent.putExtra("EXTRA_GENDER", gender);
                mathqIntent.putExtra("EXTRA_AGE", age);
                startActivity(mathqIntent);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the mathq activity and pass the Intent extras
                Intent mathqIntent = new Intent(more.this, scienceq.class);
                mathqIntent.putExtra("EXTRA_USERNAME", username);
                mathqIntent.putExtra("EXTRA_GENDER", gender);
                mathqIntent.putExtra("EXTRA_AGE", age);
                startActivity(mathqIntent);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the mathq activity and pass the Intent extras
                Intent mathqIntent = new Intent(more.this, animalq.class);
                mathqIntent.putExtra("EXTRA_USERNAME", username);
                mathqIntent.putExtra("EXTRA_GENDER", gender);
                mathqIntent.putExtra("EXTRA_AGE", age);
                startActivity(mathqIntent);
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the mathq activity and pass the Intent extras
                Intent mathqIntent = new Intent(more.this, storieq.class);
                mathqIntent.putExtra("EXTRA_USERNAME", username);
                mathqIntent.putExtra("EXTRA_GENDER", gender);
                mathqIntent.putExtra("EXTRA_AGE", age);
                startActivity(mathqIntent);
            }
        });

        // Add similar OnClickListeners for the other ImageButtons

        // Set up an OnClickListener for the iconPf ImageButton
        ImageButton iconPf = findViewById(R.id.imageButton6);
        iconPf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the logout activity
                Intent intent = new Intent(more.this, logout.class);
                startActivity(intent);
            }
        });

        // Set up an OnClickListener for the button_more ImageButton
        // Set up an OnClickListener for the button_more ImageButton
        ImageButton buttonMore = findViewById(R.id.button_more);
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the user's age is 6
                if (age.equals("6")) {
                    // Create an Intent to start the home2 activity and pass the Intent extras
                    Intent homeIntent = new Intent(more.this, home2.class);
                    homeIntent.putExtra("EXTRA_USERNAME", username);
                    homeIntent.putExtra("EXTRA_GENDER", gender);
                    homeIntent.putExtra("EXTRA_AGE", age);
                    startActivity(homeIntent);
                    finish(); // finish the more activity
                } else if (age.equals("5")) {
                    // Create an Intent to start the home1 activity and pass the Intent extras
                    Intent homeIntent = new Intent(more.this, home1.class);
                    homeIntent.putExtra("EXTRA_USERNAME", username);
                    homeIntent.putExtra("EXTRA_GENDER", gender);
                    homeIntent.putExtra("EXTRA_AGE", age);
                    startActivity(homeIntent);
                    finish(); // finish the more activity
                } else {
                    // Create an Intent to start the home activity and pass the Intent extras
                    Intent homeIntent = new Intent(more.this, home.class);
                    homeIntent.putExtra("EXTRA_USERNAME", username);
                    homeIntent.putExtra("EXTRA_GENDER", gender);
                    homeIntent.putExtra("EXTRA_AGE", age);
                    startActivity(homeIntent);
                    finish(); // finish the more activity
                }
            }
        });}}