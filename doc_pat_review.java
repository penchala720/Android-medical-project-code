package com.example.orthopedic2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class doc_reviews extends AppCompatActivity {

    private LinearLayout dateEnterLayout;
    private Button saveButton;
    private Calendar selectedDate;
    private static final String SERVER_URL = "http://10.0.2.2/php/d_reviews.php";
    private static final String INSERT_URL = "http://10.0.2.2/php/insert_reviews.php";
    private static final String TAG = "DocReviewsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_reviews);

        dateEnterLayout = findViewById(R.id.date_enter);
        saveButton = findViewById(R.id.dbtn);
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");

        // Set up the date picker dialog
        final DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                selectedDate = Calendar.getInstance();
                selectedDate.set(Calendar.YEAR, year);
                selectedDate.set(Calendar.MONTH, month);
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                // Display the selected date on the screen and save it to the database
                addDateToLayout(selectedDate);
                insertDateToDatabase(selectedDate);
            }
        };

        // Handle the click event on the "Patient visit Dates" TextView
        TextView visitDatesTextView = findViewById(R.id.add_time);
        visitDatesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(dateSetListener);
            }
        });
        fetchDatesFromDatabase();
        // Handle the click event on the "SAVE" button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fetch dates from the database
                if (selectedDate != null) {
                    // Insert the selected date into the database
                    insertDateToDatabase(selectedDate);
                    Intent intent = new Intent(doc_reviews.this,doc_p_reddy.class);
                    intent.putExtra("id",value);
                    startActivity(intent);
                }

            }
        });
    }

    private void showDatePickerDialog(DatePickerDialog.OnDateSetListener dateSetListener) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, dayOfMonth);
        datePickerDialog.show();
    }

    private void addDateToLayout(Calendar date) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String formattedDate = dateFormat.format(date.getTime());

            // Create a TextView to display the selected date
            TextView dateTextView = new TextView(this);
            dateTextView.setText(formattedDate);
            dateTextView.setTextSize(18);
            dateTextView.setGravity(Gravity.CENTER);

            // Add the TextView to the dateEnterLayout
            dateEnterLayout.addView(dateTextView);
        }
    }



    private void fetchDatesFromDatabase() {
        // Execute AsyncTask to fetch dates from the database
        new FetchDatesTask().execute();
    }



    private class FetchDatesTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> dates = new ArrayList<>();

            try {
                // You need to provide the patient ID here (replace "your_patient_id" with the actual ID)
                Intent intent1 = getIntent();
                String value = intent1.getStringExtra("id");

                URL url = new URL(SERVER_URL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // Set request method to POST
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);

                // Create POST data string
                String data = URLEncoder.encode("pid", "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8");

                // Write data to the connection
                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                writer.write(data);
                writer.flush();
                writer.close();
                outputStream.close();

                // Get response from the server
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                // Parse JSON response
                String json = result.toString();
                if (!json.equals("No dates found")) {
                    String[] dateArray = json.replace("[", "").replace("]", "").split(",");
                    for (String date : dateArray) {
                        dates.add(date.trim());
                    }
                }

            } catch (Exception e) {
                Log.e(TAG, "Error fetching dates: " + e.getMessage());
            }

            return dates;
        }

        @Override
        protected void onPostExecute(ArrayList<String> dates) {
            // Update UI with fetched dates
            updateUIWithFetchedDates(dates);
        }
    }

    private void updateUIWithFetchedDates(ArrayList<String> dates) {
        // Clear existing dates from the layout
        dateEnterLayout.removeAllViews();

        // Add fetched dates to the layout
        for (String date : dates) {
            TextView dateTextView = new TextView(this);
            dateTextView.setText(date);
            dateTextView.setTextSize(18);
            dateTextView.setGravity(Gravity.CENTER);

            // Add the TextView to the dateEnterLayout
            dateEnterLayout.addView(dateTextView);
        }
    }


    private void insertDateToDatabase(Calendar date) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String formattedDate = dateFormat.format(date.getTime());

            // Assuming you have the patient ID stored in a variable (replace "your_patient_id" with the actual ID)
            Intent intent1 = getIntent();
            String value = intent1.getStringExtra("id");

            // Execute AsyncTask to insert date into the database
            new InsertDateTask1().execute(value, formattedDate);
        }
    }

    private class InsertDateTask1 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String patientId = params[0];
            String reviewDate = params[1];
            String result = "";

            try {
                URL url = new URL(INSERT_URL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // Set request method to POST
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);

                // Create POST data string
                String data = URLEncoder.encode("pid", "UTF-8") + "=" + URLEncoder.encode(patientId, "UTF-8") + "&" +
                        URLEncoder.encode("newDate", "UTF-8") + "=" + URLEncoder.encode(reviewDate, "UTF-8");

                // Write data to the connection
                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                writer.write(data);
                writer.flush();
                writer.close();
                outputStream.close();

                // Get response from the server
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }

                result = stringBuilder.toString();

            } catch (Exception e) {
                Log.e(TAG, "Error inserting date: " + e.getMessage());
                result = "Error inserting date";
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            // Handle the result after insertion (e.g., display a toast or log)
            Log.d(TAG, "InsertDateTask result: " + result);
        }
    }
}
