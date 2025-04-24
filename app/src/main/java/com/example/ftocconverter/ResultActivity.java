package com.example.ftocconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView tvResult;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);  // Loads the layout that shows the result screen

        // Connect TextView and Button from XML to Java
        tvResult = findViewById(R.id.tvResult);
        btnBack = findViewById(R.id.btnBack);

        // Receive the Fahrenheit value that was passed from MainActivity
        Intent intent = getIntent();
        double fahrenheit = intent.getDoubleExtra("fahrenheitValue", 0.0);

        // Convert the value from Fahrenheit to Celsius using the formula
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;

        // Format the result to two decimal places and display it in the TextView
        String result = String.format("%.2f°F is %.2f°C", fahrenheit, celsius);
        tvResult.setText(result);

        // When user taps "Go Back", close this activity and return to the input screen
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Ends this activity and returns to MainActivity
            }
        });
    }
}
