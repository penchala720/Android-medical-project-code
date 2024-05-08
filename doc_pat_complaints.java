package com.example.orthopedic2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class doc_complaints extends AppCompatActivity {
    Button btn;
    EditText sugg;
    TextView com;
    String id, suggestions;
    String URL = "http://10.0.2.2/php/dcomplaints.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_complaints);

        com = findViewById(R.id.text1);
        sugg = findViewById(R.id.text2);
        btn = findViewById(R.id.button);

        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
        Log.d("hufhirohforof", value);
        fetchDataFromPhp();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suggestions = sugg.getText().toString();
                if (!suggestions.isEmpty()) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    handleResponse1(response);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            handleError(error);
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("id", value);
                            data.put("suggestion", suggestions);
                            return data;
                        }
                    };

                    stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                            60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                } else {
                    Toast.makeText(doc_complaints.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void handleResponse1(String response) {
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
        Log.d("responseerror", response);
        Gson gson = new Gson();
        try {
            JsonObject jsonObject = gson.fromJson(response, JsonObject.class);

            if (jsonObject.has("status") ) {
                String status = jsonObject.get("status").getAsString();


                if ("success".equals(status)) {
                    Toast.makeText(doc_complaints.this, "Data sent successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(doc_complaints.this, doc_p_reddy.class);
                    intent.putExtra("id", value);
                    startActivity(intent);
                } else if ("failure".equals(status)) {
                    Toast.makeText(doc_complaints.this, "Invalid login", Toast.LENGTH_SHORT).show();
                }
            } else {
                Log.e("JSON Parsing Error", "Status or res is missing or null in JSON response");
            }
        } catch (Exception e) {
            Log.e("JSON Parsing Error", "Error parsing JSON response", e);
        }
    }

    private void handleError(VolleyError error) {
        if (error instanceof TimeoutError) {
            Toast.makeText(doc_complaints.this, "Request timed out. Check your internet connection.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(doc_complaints.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
        }
    }

    private void fetchDataFromPhp() {
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        handleResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handleError(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("id", value);
                return data;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }

    private void handleResponse(String response) {
        Gson gson = new Gson();
        Log.d("JSON Response", response);
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);

        if (jsonObject.has("status") && !jsonObject.get("status").isJsonNull() &&
                jsonObject.has("res") && !jsonObject.get("res").isJsonNull()) {
            String status = jsonObject.get("status").getAsString();
            String res = jsonObject.get("res").getAsString();

            if ("success".equals(status)) {
                com.setText(res);
            } else if ("failure".equals(status)) {
                Toast.makeText(doc_complaints.this, "Invalid login", Toast.LENGTH_SHORT).show();
            }
        } else {
            Log.e("JSON Parsing Error", "Status or res is missing or null in JSON response");
        }
    }
}
