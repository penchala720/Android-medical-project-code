package com.example.orthopedic2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class doc_scoresheet extends AppCompatActivity {

    private EditText dateEditText, podEditText, fsEditText, rsEditText, xrEditText;

    private RatingBar ratingBar, ratingBar1;
    private TextView textViewRating, textViewRating1;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_scoresheet);

        // Initialize Views

        podEditText = findViewById(R.id.pod);
        rsEditText = findViewById(R.id.rs);
        xrEditText = findViewById(R.id.xr);
        ratingBar1 = findViewById(R.id.ratingBar1);
        textViewRating1 = findViewById(R.id.textViewRating1);
        saveButton = findViewById(R.id.dbtn);


        ratingBar1.setOnRatingBarChangeListener((ratingBar, rating, fromUser) ->
                textViewRating1.setText(String.valueOf(rating)));

        // Set a listener for the Save Button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle save button click
                saveData();
            }
        });
    }

    private void saveData() {
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
        // Retrieve data from the EditText and RatingBar as needed

        String pod = podEditText.getText().toString();
        String rs = rsEditText.getText().toString();
        String xr = xrEditText.getText().toString();
        float radiologicalScore = ratingBar1.getRating();

        // Create a Volley RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);

        // Define the URL of your PHP script
        String url =  "http://10.0.2.2/php/doc_scoresheet.php";

        // Create a StringRequest for the POST request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Handle the response from the server
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            // Check the status from the JSON response
                            String status = jsonResponse.getString("status");

                            if ("success".equals(status)) {
                                // Data inserted successfully
                                String message = jsonResponse.getString("message");
                                Toast.makeText(doc_scoresheet.this, message, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(doc_scoresheet.this,doc_p_reddy.class);
                                intent.putExtra("id",value);
                                startActivity(intent);
                            } else {
                                // Error during data insertion
                                String errorMessage = jsonResponse.getString("message");
                                Toast.makeText(doc_scoresheet.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors
                        error.printStackTrace();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                // Set the parameters for the POST request
                Map<String, String> params = new HashMap<>();
                params.put("id",value);

                params.put("pod", pod);
                params.put("rs", rs);
                params.put("xr", xr);
                params.put("radiologicalScore", String.valueOf(radiologicalScore));
                return params;
            }
        };

        // Add the request to the RequestQueue
        queue.add(stringRequest);
    }
}
