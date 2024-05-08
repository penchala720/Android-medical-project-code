package com.example.orthopedic2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.example.orthopedic2.R;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class doctor_login extends AppCompatActivity {
    Button btn;
    private EditText eid, epassword;
    private String username, password;
    private String URL = "http://10.0.2.2/php/dlogin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        eid = findViewById(R.id.did);
        epassword = findViewById(R.id.dpass);
        btn = findViewById(R.id.dbtn);

        // Set input type of password EditText to textPassword
        epassword.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = eid.getText().toString();
                password = epassword.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    // Save password in SharedPreferences
                    savePassword(password);

                    // Replace the actual password with dots or stars
                    String maskedPassword = maskPassword(password);

                    // Log the masked password (optional)
                    Log.d("Masked Password", maskedPassword);

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
                            // Send the username and password as POST parameters
                            Map<String, String> data = new HashMap<>();
                            data.put("username", username);
                            data.put("password", password); // Send the actual password
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
                    Toast.makeText(doctor_login.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
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
            Intent intent = new Intent(doctor_login.this, doc_home.class);
            Log.d("mes",username);
            intent.putExtra("id",username);

            startActivity(intent);

        } else if ("failure".equals(status)) {
            Toast.makeText(doctor_login.this, "Invalid login", Toast.LENGTH_SHORT).show();
        }
    }

    // Handle network request errors
    private void handleError(VolleyError error) {
        if (error instanceof TimeoutError) {
            Toast.makeText(doctor_login.this, "Request timed out. Check your internet connection.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(doctor_login.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
        }
    }

    // Save password in SharedPreferences
    private void savePassword(String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("password", password);
        editor.apply();
    }

    // Retrieve the password from SharedPreferences
    private String getSavedPassword() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return sharedPreferences.getString("password", "");
    }

    // Mask the password with dots or stars
    private String maskPassword(String password) {
        StringBuilder maskedPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            maskedPassword.append('*'); // You can use dots ('.') instead of stars ('*') if you prefer
        }
        return maskedPassword.toString();
    }
}
