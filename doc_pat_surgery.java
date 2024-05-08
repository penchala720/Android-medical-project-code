package com.example.orthopedic2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class doc_surgery extends AppCompatActivity {

    private EditText diagnosisEditText, procedureNameEditText, intraEditText, dateEditText, timeEditText, bloodLossEditText;
    private Button saveButton;
    String value;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_surgery);
        Intent intent1 = getIntent();
        value = intent1.getStringExtra("id");
        Toast.makeText(this, "s"+value, Toast.LENGTH_SHORT).show();
        // Initialize EditTexts
        diagnosisEditText = findViewById(R.id.Diagnosis);
        procedureNameEditText = findViewById(R.id.Procedure_Name);
        intraEditText = findViewById(R.id.Intra);
        dateEditText = findViewById(R.id.Date);
        timeEditText = findViewById(R.id.time);
        bloodLossEditText = findViewById(R.id.Blood_Loss);

        // Initialize Button
        saveButton = findViewById(R.id.save);

        // Set onClickListener for the Save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the save button click event
                saveData();
            }
        });
    }

    // Method to handle the save button click event
    private void saveData() {

        // Retrieve data from EditTexts
        String diagnosis = diagnosisEditText.getText().toString();
        String procedureName = procedureNameEditText.getText().toString();
        String intraOperativeDetails = intraEditText.getText().toString();
        String surgeryDate = dateEditText.getText().toString();
        String surgeryTime = timeEditText.getText().toString();
        String bloodLoss = bloodLossEditText.getText().toString();

        // Create a Map to hold the data
        Map<String, String> requestData = new HashMap<>();
        requestData.put("diagnosis", diagnosis);
        requestData.put("pn", procedureName);
        requestData.put("io", intraOperativeDetails);
        requestData.put("surgery_date", surgeryDate);
        requestData.put("surgery_time", surgeryTime);
        requestData.put("blood_loss", bloodLoss);
        requestData.put("patient_id", value);
        // Make a Volley request to your server
        String url = "http://10.0.2.2/php/doc_surgery.php"; // Replace with your server URL
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Handle the server response (if needed)
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            // Check the status from the JSON response
                            String status = jsonResponse.getString("status");

                            if ("success".equals(status)) {
                                // Data inserted successfully
                                String message = jsonResponse.getString("message");
                                Toast.makeText(doc_surgery.this, message, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(doc_surgery.this, doc_p_reddy.class);
                                intent.putExtra("id",value);
                                startActivity(intent);
                            } else {
                                // Error during data insertion
                                String errorMessage = jsonResponse.getString("message");
                                Toast.makeText(doc_surgery.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors that occurred during the request
                        Log.e("VolleyError", "Error: " + error.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                // Pass the data to the server in the request body
                return requestData;
            }
        };

        // Add the request to the Volley request queue
        Volley.newRequestQueue(this).add(request);
    }
}
