    package com.example.orthopedic2;
    
    import android.annotation.SuppressLint;
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
    
    
    
    // Import statements
    
    public class p_suggestions extends AppCompatActivity {
        Button btn;
        private EditText sugg;
        private TextView com;
        private String id, suggestions;
        private String URL = "http://10.0.2.2/php/p_suggPrint.php";
    
        @SuppressLint("WrongViewCast")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_p_suggestions);
    
            com = findViewById(R.id.text1);
    
            btn = findViewById(R.id.button);
            Intent intent1 = getIntent();
            String value = intent1.getStringExtra("id");
    
            // Assuming you get the "id" from somewhere, modify this accordingly

            fetchDataFromPhp();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(p_suggestions.this,patient_reddy.class);
                    intent.putExtra("id",value);
                    startActivity(intent);
                }
            });
    
    
    
        }
    
        // Handle the JSON response
        private void handleResponse1(String response) {
            Log.d("responseerror", response);
            Gson gson = new Gson();
            try {
                // Parse the response string into a JsonObject
                JsonObject jsonObject = gson.fromJson(response, JsonObject.class);

                String status = jsonObject.get("status").getAsString();
                String res = jsonObject.get("res").getAsString();
                Log.d("JSON Response", status);

                if ("success".equals(status)) {
                    Log.d("JSON Response", response);
                    // Assuming "res" is the key in your JSON response containing the success message
                    String message = res;

                    // Display the success message
                    com.setText(message);

                    // Navigate to the next activity

                } else if ("failure".equals(status)) {
                    Toast.makeText(p_suggestions.this, "Invalid login", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Log.e("JSON Parsing Error", "Error parsing JSON response", e);
                // Handle the error as needed
            }
        }

        // Handle network request errors
        private void handleError(VolleyError error) {
            if (error instanceof TimeoutError) {
                Toast.makeText(p_suggestions.this, "Request timed out. Check your internet connection.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(p_suggestions.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }
    
        private void fetchDataFromPhp() {
            Intent intent1 = getIntent();
            String value = intent1.getStringExtra("id");
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
                    // Send the id as a POST parameter
                    Map<String, String> data = new HashMap<>();
                    data.put("P_id", value);
                    return data;
                }
            };
    
            // Customize the retry policy
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                    60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    
            // Initialize the Volley request queue and add the request
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    
        // Handle the JSON response
        private void handleResponse(String response) {
            Gson gson = new Gson();
            Log.d("JSON Response", response);
            JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
            String status = jsonObject.get("status").getAsString();
            String res = jsonObject.get("res").getAsString();
            Log.d("JSON Response", status);
    
            if ("success".equals(status)) {
                // Assuming "res" is the key in your JSON response containing the text you want to set
                String textFromPhp = res;
    
                // Set the retrieved text in your EditText widget
                com.setText(textFromPhp);
            } else if ("failure".equals(status)) {
                Toast.makeText(p_suggestions.this, "Invalid login", Toast.LENGTH_SHORT).show();
            }
        }
    }
