package com.example.updatedcaps;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class numq extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_numq);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton numVidButton = findViewById(R.id.num_vid);

        numVidButton.setOnClickListener(v -> {
            Intent intent = new Intent(numq.this, numvid.class);
            startActivity(intent);
        });

        button = findViewById(R.id.one);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(numq.this, activitynum1.class);
                startActivity(intent);
                finish();

            }
        });

        // Find the ImageButton by its ID
        ImageButton buttonNum = findViewById(R.id.button_num);

        // Retrieve the age value from the intent
        String age = getIntent().getStringExtra("EXTRA_AGE");

        // Set an OnClickListener on the button
        buttonNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (age != null) {
                    if (age.equals("4")) {
                        intent = new Intent(numq.this, home.class);
                    } else if (age.equals("5")) {
                        intent = new Intent(numq.this, home1.class);
                    } else if (age.equals("6")) {
                        intent = new Intent(numq.this, home2.class); // Add a new activity for age 6
                    } else {
                        // If the age is not 4, 5, or 6, navigate to home.class as a default
                        intent = new Intent(numq.this, home.class);
                    }

                    intent.putExtra("EXTRA_USERNAME", getIntent().getStringExtra("EXTRA_USERNAME"));
                    intent.putExtra("EXTRA_GENDER", getIntent().getStringExtra("EXTRA_GENDER"));
                    intent.putExtra("EXTRA_AGE", getIntent().getStringExtra("EXTRA_AGE"));
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}