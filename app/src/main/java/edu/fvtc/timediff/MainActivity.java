package edu.fvtc.timediff;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeDiffButton();
    }
    private void timeDiffButton() {
        Button tbnShowTimeDiff = findViewById(R.id.btnTimeDifference);

        tbnShowTimeDiff.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                //Get Start Time input and store it into a String
                EditText tmStartTime = findViewById(R.id.StartTime);
                String startTimeInput = tmStartTime.getText().toString();

                //Get End Time input and store it into a String
                EditText tmEndTime = findViewById(R.id.EndTime);
                String endTimeInput = tmEndTime.getText().toString();



                try {
                    //Format string to (HH:mm:ss)
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                    //**
                    Date startTime = format.parse(startTimeInput);
                    Date endTime = format.parse(endTimeInput);


                    long difference = startTime.getTime() - endTime.getTime();

                    // Convert difference
                    long seconds = difference / 1000;
                    long minutes = seconds / 60;
                    seconds = seconds % 60;
                    long hours = minutes / 60;
                    minutes = minutes % 60;

                    //zero fill each component
                    String formattedHours = String.format("%02d", hours);
                    String formattedMinutes = String.format("%02d", minutes);
                    String formattedSeconds = String.format("%02d", seconds);

                    String formattedDifference = formattedHours + ":" + formattedMinutes + ":" + formattedSeconds;

                    TextView tvResult = findViewById(R.id.textView5);
                    tvResult.setText(formattedDifference);

                    // Perform operations with startTime and endTime
                } catch (ParseException e) {
                    e.printStackTrace(); // Print the error message
                    // Handle the parsing exception
                    Toast.makeText(MainActivity.this, "Invalid time format. Please enter time in HH:mm:ss format.", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}