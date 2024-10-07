package com.example.updatedcaps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class shapeq extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shapeq);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton numVidButton = findViewById(R.id.num_vid);

        numVidButton.setOnClickListener(v -> {
            Intent intent = new Intent(shapeq.this, shapevid.class);
            startActivity(intent);
        });

        button = findViewById(R.id.one);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shapeq.this, activityshapes1.class);
                startActivity(intent);
                finish();

            }
        });

        ImageButton buttonNum = findViewById(R.id.back);

        // Set an OnClickListener on the button
        buttonNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shapeq.this, home.class);
                intent.putExtra("EXTRA_USERNAME", getIntent().getStringExtra("EXTRA_USERNAME"));
                intent.putExtra("EXTRA_GENDER", getIntent().getStringExtra("EXTRA_GENDER"));
                intent.putExtra("EXTRA_AGE", getIntent().getStringExtra("EXTRA_AGE"));
                startActivity(intent);
                finish();
            }
        });}}