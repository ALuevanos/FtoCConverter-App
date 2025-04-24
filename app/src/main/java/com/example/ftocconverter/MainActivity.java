package com.example.ftocconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Input field for the user to enter the temperature in Fahrenheit
    EditText etFahrenheit;

    // Button to trigger the conversion
    Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Connects this Java file to the layout XML

        // Linking XML views to Java code
        etFahrenheit = findViewById(R.id.etFahrenheit);
        btnConvert = findViewById(R.id.btnConvert);

        // Set up what happens when the Convert button is clicked
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the user's input from the EditText
                String input = etFahrenheit.getText().toString().trim();

                if (input.isEmpty()) {
                    // If input is empty, show a quick message (Toast)
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                } else {
                    // Convert the input to a double (numerical value)
                    double fahrenheit = Double.parseDouble(input);

                    // Create an Intent to move to the ResultActivity screen
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    // Pass the input value to the next activity
                    intent.putExtra("fahrenheitValue", fahrenheit);
                    // Start ResultActivity
                    startActivity(intent);
                }
            }
        });
    }
}
