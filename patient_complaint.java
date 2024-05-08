package com.example.orthopedic2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class pat_complaints extends AppCompatActivity {

    private EditText complaintEditText;
    private RadioGroup doctorVisitRadioGroup;
    private Button submitButton;
    String currentDate;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_complaints);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        currentDate = dateFormat.format(new Date());


        complaintEditText = findViewById(R.id.complaints);
        doctorVisitRadioGroup = findViewById(R.id.d1);
        submitButton = findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendComplaintData();
            }
        });
    }

    private void sendComplaintData() {
        Intent intent1 = getIntent();
       String value = intent1.getStringExtra("id");

        // Get user input
        String complaintText = complaintEditText.getText().toString();
        RadioButton selectedRadioButton = findViewById(doctorVisitRadioGroup.getCheckedRadioButtonId());
        String doctorVisitAnswer = selectedRadioButton.getText().toString();

        // Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2/php/pcomplaints.php";  // Replace with your server endpoint

        // Make a POST request using Volley
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Handle the response from the server

                        Toast.makeText(pat_complaints.this, "Data sent successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(pat_complaints.this,patient_reddy.class);
                    intent.putExtra("id",value);
                    startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors that occurred while sending the request
                        Toast.makeText(pat_complaints.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                // Set the parameters for the POST request
                Map<String, String> params = new HashMap<>();
                params.put("complaint", complaintText);
                params.put("doctor_visit", doctorVisitAnswer);
                params.put("pid",value);
                params.put("date",currentDate);
                return params;
            }
        };

        // Add the request to the RequestQueue
        queue.add(stringRequest);
    }
}
