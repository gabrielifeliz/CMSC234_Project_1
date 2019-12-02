package com.zybooks.rectanglecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText rectangleWidth, rectangleHeight;
    private TextView rectangleArea, rectanglePerimeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Returns last instance of emulator
        super.onCreate(savedInstanceState);
        // Set activity main as the base content view
        setContentView(R.layout.activity_main);

        // Find edit text for width from layout XML and assign it to this variable
        rectangleWidth = findViewById(R.id.rectangleWidth);
        // Find edit text for height from layout XML and assign it to this variable
        rectangleHeight = findViewById(R.id.rectangleHeight);
        // Find text view for area from layout XML and assign it to this variable
        rectangleArea = findViewById(R.id.rectangleArea);
        // Find text view for perimeter from layout XML and assign it to this variable
        rectanglePerimeter = findViewById(R.id.rectanglePerimeter);
    }

    public void calculateClick(View view) {

        try {
            // Get the text that was typed into the EditText for width
            String widthInput = rectangleWidth.getText().toString();
            // Convert width into a double
            double width = Double.parseDouble(widthInput);

            // Get the text that was typed into the EditText for height
            String heightInput = rectangleHeight.getText().toString();
            // Convert height into a double
            double height = Double.parseDouble(heightInput);

            // Calculate and display area and perimeter of rectangle
            double area = height * width;
            double perimeter = (2 * height) + (2 * width);
            rectangleArea.setText(String.format(Locale.getDefault(),"%.2f", area));
            rectanglePerimeter.setText(String.format(Locale.getDefault(),"%.2f", perimeter));

        } catch (NumberFormatException e) {
            // Show a temporary message if the user didn't enter a number
            Toast.makeText(this, "Enter a number!", Toast.LENGTH_SHORT).show();
        }
    }

}
