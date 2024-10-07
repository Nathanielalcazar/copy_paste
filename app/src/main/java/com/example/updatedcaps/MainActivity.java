package com.example.updatedcaps;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    TextView appName;

    Animation Splash_top, Splash_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //splash

        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.appName);

        // For animation

        Splash_top = AnimationUtils.loadAnimation(this, R.anim.splash_top);
        Splash_bottom = AnimationUtils.loadAnimation(this, R.anim.splash_bottom);

        logo.setAnimation(Splash_top);
        appName.setAnimation(Splash_bottom);

        // Start the Welcome activity after animations end

        Splash_bottom.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Optionally handle animation start
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(MainActivity.this, Welcome.class);
                startActivity(intent);


                // Apply the custom transition
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                // Optionally finish the MainActivity
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Optionally handle animation repeat
            }
        });
    }
}