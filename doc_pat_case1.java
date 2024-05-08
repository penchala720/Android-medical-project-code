package com.example.orthopedic2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class case1 extends AppCompatActivity {

    // URL of your PHP script
    private static final String PHP_URL = "http://10.0.2.2/php/case_1.php";

    // TextViews to display data
    private TextView nameTextView, ageTextView, ipNumberTextView, addressTextView, contactTextView,
            admissionTextView, occupationTextView, educationTextView, surgeryTextView, dischargeTextView, socioecStatusTextView;
    private Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1);

        // Retrieve the value passed from the previous activity
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");

        // Initialize TextViews
        nameTextView = findViewById(R.id.Name);
        ageTextView = findViewById(R.id.age);
        ipNumberTextView = findViewById(R.id.ip_number);
        addressTextView = findViewById(R.id.address);
        contactTextView = findViewById(R.id.contact);
        admissionTextView = findViewById(R.id.admission);
        occupationTextView = findViewById(R.id.occupation);
        educationTextView = findViewById(R.id.education);
        surgeryTextView = findViewById(R.id.surgery);
        dischargeTextView = findViewById(R.id.Discharge);
        socioecStatusTextView = findViewById(R.id.Socioec_Status);
        btn = findViewById(R.id.addButton1);

        // Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);

        // Create a String request to the PHP URL
        StringRequest stringRequest = new StringRequest(Request.Method.POST, PHP_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            // Assuming keys are consistent with your PHP response
                            String name = jsonObject.getString("name");
                            String age = jsonObject.getString("age");
                            String ipNumber = jsonObject.getString("ipNumber");
                            String address = jsonObject.getString("address");
                            String contact = jsonObject.getString("contact");
                            String admission = jsonObject.getString("admission");
                            String occupation = jsonObject.getString("occupation");
                            String education = jsonObject.getString("education");
                            String surgery = jsonObject.getString("surgery");
                            String discharge = jsonObject.getString("discharge");
                            String socioecStatus = jsonObject.getString("socioecStatus");

                            // Update TextViews with the retrieved data
                            nameTextView.setText(name);
                            ageTextView.setText(age);
                            ipNumberTextView.setText(ipNumber);
                            addressTextView.setText(address);
                            contactTextView.setText(contact);
                            admissionTextView.setText(admission);
                            occupationTextView.setText(occupation);
                            educationTextView.setText(education);
                            surgeryTextView.setText(surgery);
                            dischargeTextView.setText(discharge);
                            socioecStatusTextView.setText(socioecStatus);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Pass IP number as a parameter to PHP script
                Map<String, String> params = new HashMap<>();
                params.put("ipNumber", value);
                return params;
            }
        };

        // Add the request to the RequestQueue
        queue.add(stringRequest);

        // Set OnClickListener for the button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the next activity
                Intent intent = new Intent(case1.this, case2.class);
                intent.putExtra("id", value); // Pass the same value to the next activity
                startActivity(intent);
            }
        });
    }
}
