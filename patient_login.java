package com.example.orthopedic2;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class patient_login extends AppCompatActivity {
    Button btn;
    private EditText eid, epassword;
    private String username, password;
    private String URL = "http://10.0.2.2/php/pLogin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        eid = findViewById(R.id.id);
        epassword = findViewById(R.id.pass);
        // Set input type for password field
        epassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = eid.getText().toString();
                password = epassword.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    Log.d("inner", username);
                    Log.d("inner", password);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // Handle the response
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
                            Log.d("sending", username);
                            // Send the username and password as POST parameters
                            Map<String, String> data = new HashMap<>();
                            data.put("username", username);
                            data.put("password", password);
                            return data;
                        }
                    };

                    // Customize the retry policy
                    stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                            60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

                    // Initialize the Volley request queue and add the request
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                } else {
                    Toast.makeText(patient_login.this, "Fields cannot be empty1111", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Handle the JSON response
    private void handleResponse(String response) {
        Gson gson = new Gson();
        Log.d("JSON Response", response);
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        String status = jsonObject.get("status").getAsString();
        Log.d("JSON Response", status);

        if ("success".equals(status)) {
            Toast.makeText(patient_login.this, "Succesfully loged in", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(patient_login.this, patient_reddy.class);
            Log.d("mes", username);
            intent.putExtra("id", username);
            startActivity(intent);
        } else if ("failure".equals(status)) {
            Toast.makeText(patient_login.this, "Invalid login", Toast.LENGTH_SHORT).show();
        }
    }

    // Handle network request errors
    private void handleError(VolleyError error) {
        if (error instanceof TimeoutError) {
            Toast.makeText(patient_login.this, "Request timed out. Check your internet connection.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(patient_login.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
        }
    }
}
