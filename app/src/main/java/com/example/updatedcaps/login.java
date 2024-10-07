package com.example.updatedcaps;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    private ImageButton boyButton, girlButton, age4Button, age5Button, age6Button, submitButton;
    private EditText usernameEditText;

    private boolean isBoySelected = false;
    private boolean isGirlSelected = false;
    private ImageButton selectedAgeButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons and EditText
        boyButton = findViewById(R.id.boy);
        girlButton = findViewById(R.id.girl);
        age4Button = findViewById(R.id.age4);
        age5Button = findViewById(R.id.age5);
        age6Button = findViewById(R.id.age6);
        submitButton = findViewById(R.id.con);
        usernameEditText = findViewById(R.id.Username);

        // Set character limit for username
        usernameEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(10) });


        // Set listeners for gender buttons
        boyButton.setOnClickListener(v -> {
            isBoySelected = !isBoySelected;
            isGirlSelected = false;
            updateGenderButtons();
        });

        girlButton.setOnClickListener(v -> {
            isGirlSelected = !isGirlSelected;
            isBoySelected = false;
            updateGenderButtons();
        });

        // Set listeners for age buttons
        age4Button.setOnClickListener(v -> selectAgeButton(age4Button));
        age5Button.setOnClickListener(v -> selectAgeButton(age5Button));
        age6Button.setOnClickListener(v -> selectAgeButton(age6Button));

        // Set listener for submit button
        submitButton.setOnClickListener(v -> handleSubmit(usernameEditText.getText().toString().trim()));
    }
    private String gender;

    private void updateGenderButtons() {
        boyButton.setAlpha(isBoySelected ? 1.0f : 0.5f);
        girlButton.setAlpha(isGirlSelected ? 1.0f : 0.5f);
        gender = isBoySelected ? "Boy" : isGirlSelected ? "Girl" : "Unknown";
    }

    private void selectAgeButton(ImageButton button) {
//
        // Make all age buttons transparent
        age4Button.setAlpha(0.3f);
        age5Button.setAlpha(0.3f);
        age6Button.setAlpha(0.3f);

        // Highlight the selected button
        button.setAlpha(1.0f);
        selectedAgeButton = button;
    }

    private Map<String, Class<?>> AGE_ACTIVITY_MAP;
    {
        // ...
        AGE_ACTIVITY_MAP = new HashMap<>();
        AGE_ACTIVITY_MAP.put("4", home.class);
        AGE_ACTIVITY_MAP.put("5", home1.class);
        AGE_ACTIVITY_MAP.put("6", home2.class);
        // ...
    }

    private void handleSubmit(String username) {
        // ...
        String age = getAgeFromButton(selectedAgeButton);
        Class<?> activityClass;
        switch (age) {
            case "4":
                activityClass = home.class;
                break;
            case "5":
                activityClass = home1.class;
                break;
            case "6":
                activityClass = home2.class;
                break;
            default:
                activityClass = null;
                break;
        }
        if (activityClass != null) {
            Intent intent = new Intent(this, activityClass);
            intent.putExtra("EXTRA_USERNAME", username);
            intent.putExtra("EXTRA_GENDER", gender);
            intent.putExtra("EXTRA_AGE", age);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Unexpected age selection.", Toast.LENGTH_SHORT).show();
        }
    }

    private String getAgeFromButton(ImageButton button) {
        if (button == age4Button) {
            return "4";
        } else if (button == age5Button) {
            return "5";
        } else if (button == age6Button) {
            return "6";
        } else {
            return "Unknown";
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(login.this, Welcome.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}