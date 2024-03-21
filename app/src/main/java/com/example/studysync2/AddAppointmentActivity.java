package com.example.studysync2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddAppointmentActivity extends AppCompatActivity {

    private EditText topicEditText;
    private EditText classCodeEditText;
    private EditText timeEditText;
    private EditText locationEditText;
    private Button submitButton;

    private String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addappointmentactivity);

        // Retrieve the selected date from MainActivity2
        selectedDate = getIntent().getStringExtra("selectedDate");

        // Initialize EditText fields and button
        topicEditText = findViewById(R.id.topicEditText);
        classCodeEditText = findViewById(R.id.classCodeEditText);
        timeEditText = findViewById(R.id.timeEditText);
        locationEditText = findViewById(R.id.locationEditText);
        submitButton = findViewById(R.id.submitButton);

        // Handle submit button click
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve user input from EditText fields
                String topic = topicEditText.getText().toString();
                String classCode = classCodeEditText.getText().toString();
                String time = timeEditText.getText().toString();
                String location = locationEditText.getText().toString();

                // Pass the appointment details back to MainActivity2
                Intent resultIntent = new Intent();
                resultIntent.putExtra("selectedDate", selectedDate);
                resultIntent.putExtra("topic", topic);
                resultIntent.putExtra("classCode", classCode);
                resultIntent.putExtra("time", time);
                resultIntent.putExtra("location", location);
                setResult(RESULT_OK, resultIntent);

                // Finish AddAppointmentActivity and return to MainActivity2
                finish();
            }
        });
    }
}
