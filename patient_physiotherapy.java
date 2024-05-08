package com.example.orthopedic2;

import android.content.Intent;
import android.os.Bundle;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class pat_physiotherapy extends AppCompatActivity {

    private RadioButton doneRadioButton, notDoneRadioButton, anyDifficultyRadioButton;
    private String id;
    private Button sendToDoctorButton;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_physiotherapy);

        doneRadioButton = findViewById(R.id.done);
        notDoneRadioButton = findViewById(R.id.not_done);
        anyDifficultyRadioButton = findViewById(R.id.any_difficulty);
        sendToDoctorButton = findViewById(R.id.btn1);
        id = "1234";

        requestQueue = Volley.newRequestQueue(this);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Handle the radio button changes here
            }
        });

        sendToDoctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedOption = "";
                if (doneRadioButton.isChecked()) {
                    selectedOption = "Done";
                    Intent intent = new Intent(pat_physiotherapy.this, patient_reddy.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                } else if (notDoneRadioButton.isChecked()) {
                    selectedOption = "Not Done";
                    Intent intent = new Intent(pat_physiotherapy.this, patient_reddy.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                } else if (anyDifficultyRadioButton.isChecked()) {
                    selectedOption = "Any Difficulty";
                    sendToServer(id, selectedOption);
                    Intent intent = new Intent(pat_physiotherapy.this, pat_complaints.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }

                Toast.makeText(pat_physiotherapy.this, "Selected Option: " + selectedOption, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendToServer(String id, String selectedOption) {
        String url = "http://10.0.2.2/php/pcomplaints.php"; // Replace with your server endpoint
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("id", value);
            jsonBody.put("selectedOption", selectedOption);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle the response from the server
                        // You can process the response if needed
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }
}
