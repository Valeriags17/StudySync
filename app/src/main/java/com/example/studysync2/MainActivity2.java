import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studysync2.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {

    private TextView selectedDateTextView;
    private EditText appointmentDetailsEditText;
    private CalendarView calendarView;
    private Button scheduleButton;
    private Button feedbackButton; // Add feedback button
    private EditText feedbackEditText; // Add feedback EditText

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        selectedDateTextView = findViewById(R.id.selectedDateTextView);
        appointmentDetailsEditText = findViewById(R.id.appointmentDetailsEditText);
        scheduleButton = findViewById(R.id.scheduleButton);
        calendarView = findViewById(R.id.calendarView);

        // Find feedback related views
        feedbackButton = findViewById(R.id.feedbackButton);
        feedbackEditText = findViewById(R.id.feedbackEditText);

        // Set the current date as the default selected date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = sdf.format(new Date(calendarView.getDate()));
        selectedDateTextView.setText(currentDate);

        // Listen for date selection changes
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                selectedDateTextView.setText(selectedDate);
            }
        });

        // Handle scheduling button click
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scheduleAppointment();
            }
        });

        // Handle feedback button click
        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendFeedback();
            }
        });
    }

    private void scheduleAppointment() {
        String selectedDate = selectedDateTextView.getText().toString();
        String appointmentDetails = appointmentDetailsEditText.getText().toString();

        // Perform validation if needed

        // For demonstration purposes, just show a toast with the scheduling information
        String message = "Appointment Scheduled!\nDate: " + selectedDate + "\nDetails: " + appointmentDetails;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void sendFeedback() {
        String feedback = feedbackEditText.getText().toString();
        // You can implement the logic to send feedback to the system here

        // For demonstration purposes, just show a toast with the feedback
        Toast.makeText(this, "Feedback sent: " + feedback, Toast.LENGTH_LONG).show();
    }
}
