package com.example.orthopedic2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import java.util.HashMap;
import java.util.Map;

public class ilizarov extends AppCompatActivity {

    private RadioGroup distractionRadioGroup;
    private RadioGroup dressingPinTrackRadioGroup;
    private RadioGroup dressingApparatusCleaningRadioGroup;
    private RadioGroup compressionRadioGroup;
    private Button submitButton;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilizarov);

        distractionRadioGroup = findViewById(R.id.d1);
        dressingPinTrackRadioGroup = findViewById(R.id.d2);
        dressingApparatusCleaningRadioGroup = findViewById(R.id.d3);
        compressionRadioGroup = findViewById(R.id.d4);
        submitButton = findViewById(R.id.btn2);
        submit = findViewById(R.id.btn1);
        Intent intent = getIntent();
        String value = intent.getStringExtra("id");

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ilizarov.this,patient_reddy.class);
                intent.putExtra("id",value);
                startActivity(intent);
                sendIlizarovData();
            }

        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ilizarov.this,pat_complaints.class);
                intent.putExtra("id",value);
                startActivity(intent);
                sendIlizarovData();
            }

        });
    }

    private void sendIlizarovData() {
        // Get selected options
        RadioButton selectedDistractionRadioButton = findViewById(distractionRadioGroup.getCheckedRadioButtonId());
        RadioButton selectedDressingPinTrackRadioButton = findViewById(dressingPinTrackRadioGroup.getCheckedRadioButtonId());
        RadioButton selectedDressingApparatusCleaningRadioButton = findViewById(dressingApparatusCleaningRadioGroup.getCheckedRadioButtonId());
        RadioButton selectedCompressionRadioButton = findViewById(compressionRadioGroup.getCheckedRadioButtonId());

        String distractionValue = selectedDistractionRadioButton.getText().toString();
        String dressingPinTrackValue = selectedDressingPinTrackRadioButton.getText().toString();
        String dressingApparatusCleaningValue = selectedDressingApparatusCleaningRadioButton.getText().toString();
        String compressionValue = selectedCompressionRadioButton.getText().toString();

        // Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2/php/pilizarov.php";  // Replace with your server endpoint

        // Make a POST request using Volley
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("res",response);
                        // Handle the response from the server
                        Toast.makeText(ilizarov.this, "Data sent successfully", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors that occurred while sending the request
                        Toast.makeText(ilizarov.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                // Set the parameters for the POST request
                Map<String, String> params = new HashMap<>();
                Log.d("tag",distractionValue);
                params.put("distraction", distractionValue);
                params.put("dressing_pin_track", dressingPinTrackValue);
                params.put("dressing_apparatus_cleaning", dressingApparatusCleaningValue);
                params.put("compression", compressionValue);
                return params;
            }
        };

        // Add the request to the RequestQueue
        queue.add(stringRequest);
    }
}
