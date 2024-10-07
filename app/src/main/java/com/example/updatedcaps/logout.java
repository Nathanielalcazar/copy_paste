package com.example.updatedcaps;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class logout extends AppCompatActivity {

    private Button yesButton;
    private Button buttonNum; // Declare the buttonNum variable
    private String age; // Declare the age variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Find the ImageButton by ID
        ImageButton backButton = findViewById(R.id.buttonNum);

        // Set an OnClickListener for the ImageButton
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity to return to the previous activity
                finish();
            }
        });

        yesButton = findViewById(R.id.yes);

        // Show the logout confirmation dialog when "Yes" button is clicked
        yesButton.setOnClickListener(v -> showLogoutConfirmationDialog());

        buttonNum = findViewById(R.id.buttonNum); // Initialize the buttonNum variable
        age = getIntent().getStringExtra("EXTRA_AGE"); // Initialize the age variable

        buttonNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (age != null) {
                    if (age.equals("4")) {
                        intent = new Intent(logout.this, home.class);
                    } else if (age.equals("5")) {
                        intent = new Intent(logout.this, home1.class);
                    } else if (age.equals("6")) {
                        intent = new Intent(logout.this, home2.class); // Add a new activity for age 6
                    } else {
                        // If the age is not 4, 5, or 6, navigate to home.class as a default
                        intent = new Intent(logout.this, home.class);
                    }

                    intent.putExtra("EXTRA_USERNAME", getIntent().getStringExtra("EXTRA_USERNAME"));
                    intent.putExtra("EXTRA_GENDER", getIntent().getStringExtra("EXTRA_GENDER"));
                    intent.putExtra("EXTRA_AGE", age);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void showLogoutConfirmationDialog() {

        // Create an AlertDialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Log Out Confirmation");
        builder.setMessage("Are you sure you want to log out?");

        // Set positive button
        builder.setPositiveButton("Yes", (dialog, which) -> {
            // Redirect to the login page
            Intent intent = new Intent(logout.this, login.class);
            startActivity(intent);
            finish(); // Close the current activity
        });

        // Set negative button
        builder.setNegativeButton("No", (dialog, which) -> {
        });

        // Show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}