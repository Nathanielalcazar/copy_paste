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


public class home2 extends AppCompatActivity {

    private TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        displayTextView = findViewById(R.id.displayTextView);


        // Get the data from the Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("EXTRA_USERNAME");
        String gender = intent.getStringExtra("EXTRA_GENDER");
        String age = intent.getStringExtra("EXTRA_AGE");

        // Display the data
        displayTextView.setText("Username: " + username + "\nGender: " + gender + "\nAge: " + age);

        // Find ImageButtons by their IDs
        ImageButton imageButton1 = findViewById(R.id.num);
        ImageButton imageButton2 = findViewById(R.id.let);
        ImageButton imageButton3 = findViewById(R.id.color);
        ImageButton imageButton4 = findViewById(R.id.shape);
        ImageButton moreButton = findViewById(R.id.more);

        // Set onClickListener for each ImageButton
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to another activity
                Intent intent = new Intent(home2.this, numq.class);
                intent.putExtra("EXTRA_USERNAME", username);
                intent.putExtra("EXTRA_GENDER", gender);
                intent.putExtra("EXTRA_AGE", age);
                startActivity(intent);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to another activity
                Intent intent = new Intent(home2.this, letq.class);
                intent.putExtra("EXTRA_USERNAME", username);
                intent.putExtra("EXTRA_GENDER", gender);
                intent.putExtra("EXTRA_AGE", age);
                startActivity(intent);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to another activity
                Intent intent = new Intent(home2.this, colq.class);
                intent.putExtra("EXTRA_USERNAME", username);
                intent.putExtra("EXTRA_GENDER", gender);
                intent.putExtra("EXTRA_AGE", age);
                startActivity(intent);
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to another activity
                Intent intent = new Intent(home2.this, shapeq.class);
                intent.putExtra("EXTRA_USERNAME", username);
                intent.putExtra("EXTRA_GENDER", gender);
                intent.putExtra("EXTRA_AGE", age);
                startActivity(intent);
            }
        });
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to another activity
                Intent intent = new Intent(home2.this, more_age6.class);
                intent.putExtra("EXTRA_USERNAME", username);
                intent.putExtra("EXTRA_GENDER", gender);
                intent.putExtra("EXTRA_AGE", age);
                startActivity(intent);
            }
        });
        // Find the ImageButton by its ID
        ImageButton iconPf = findViewById(R.id.icon_pf);

        // Set up an OnClickListener
        iconPf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the TargetActivity
                Intent intent = new Intent(home2.this, logout.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
// super.onBackPressed();
        // Show a message indicating that the user is already on the home page
        Toast.makeText(getApplicationContext(), "You are already on the home page", Toast.LENGTH_SHORT).show();
    }
}