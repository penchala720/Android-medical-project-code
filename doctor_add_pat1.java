package com.example.orthopedic2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class add_patient extends AppCompatActivity {

    // Declare EditText variables for patient details
    private EditText nameEditText, ageEditText, ipNumberEditText, addressEditText,
            contactEditText, admissionEditText, occupationEditText, educationEditText,
            surgeryEditText, dischargeEditText, socioecStatusEditText;

    // Declare Button variable for adding patient
    private Button addButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        // Initialize EditText fields for patient details
        nameEditText = findViewById(R.id.Name);
        ageEditText = findViewById(R.id.age);
        ipNumberEditText = findViewById(R.id.ip_number);
        addressEditText = findViewById(R.id.address);
        contactEditText = findViewById(R.id.contact);
        admissionEditText = findViewById(R.id.admission);
        occupationEditText = findViewById(R.id.occupation);
        educationEditText = findViewById(R.id.education);
        surgeryEditText = findViewById(R.id.surgery);
        dischargeEditText = findViewById(R.id.Discharge);
        socioecStatusEditText = findViewById(R.id.Socioec_Status);

        addButton = findViewById(R.id.addButton1);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get text from EditText fields
                final String name = nameEditText.getText().toString().trim();
                final String age = ageEditText.getText().toString().trim();
                final String ipNumber = ipNumberEditText.getText().toString().trim();
                final String address = addressEditText.getText().toString().trim();
                final String contact = contactEditText.getText().toString().trim();
                final String admission = admissionEditText.getText().toString().trim();
                final String occupation = occupationEditText.getText().toString().trim();
                final String education = educationEditText.getText().toString().trim();
                final String surgery = surgeryEditText.getText().toString().trim();
                final String discharge = dischargeEditText.getText().toString().trim();
                final String socioecStatus = socioecStatusEditText.getText().toString().trim();

                // Instantiate the RequestQueue
                RequestQueue queue = Volley.newRequestQueue(add_patient.this);
                String url = "http://10.0.2.2/php/addPatient.php"; // Replace with your PHP script URL

                // Request a string response from the provided URL
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Intent intent1 = getIntent();
                                String value = intent1.getStringExtra("id");
                                // Display a toast message upon successful storage
                                Toast.makeText(add_patient.this, "Data stored successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(add_patient.this,add_patient2.class);
                                intent.putExtra("id",ipNumber);
                                intent.putExtra("id1",value);
                                startActivity(intent);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Display a toast message upon error
                        Toast.makeText(add_patient.this, "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        // Pass parameters to PHP script
                        params.put("name", name);
                        params.put("age", age);
                        params.put("ipNumber", ipNumber);
                        params.put("address", address);
                        params.put("contact", contact);
                        params.put("admission", admission);
                        params.put("occupation", occupation);
                        params.put("education", education);
                        params.put("surgery", surgery);
                        params.put("discharge", discharge);
                        params.put("socioecStatus", socioecStatus);
                        return params;
                    }
                };

                // Add the request to the RequestQueue
                queue.add(stringRequest);
            }
        });
    }
}
