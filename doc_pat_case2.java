package com.example.orthopedic2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

public class case2 extends AppCompatActivity {

    // Declare TextViews for different sections
    private TextView modeOfInjuryTextView, presentComplaintsTextView, comorroid,
            drugHistoryTextView, pasthis, personalhi;
    private Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case2);

        // Initialize TextViews for different sections
        modeOfInjuryTextView = findViewById(R.id.moi);
        presentComplaintsTextView = findViewById(R.id.pc);
        btn = findViewById(R.id.addButton1);
        comorroid = findViewById(R.id.ci);
        drugHistoryTextView = findViewById(R.id.dh);
        pasthis = findViewById(R.id.ph);
        personalhi = findViewById(R.id.poh);
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
        // Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2/php/case_2.php";

        // Request a string response from the provided URL
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // Parsing JSON response
                            JSONObject jsonObject = new JSONObject(response);

                            // Extracting and formatting data
                            StringBuilder modeOfInjuryBuilder = new StringBuilder();
                            appendIfNotEmpty(jsonObject, modeOfInjuryBuilder, "1a", "Mode of Injury");
                            appendIfNotEmpty(jsonObject, modeOfInjuryBuilder, "1b", "");
                            appendIfNotEmpty(jsonObject, modeOfInjuryBuilder, "1c", "");
                            appendIfNotEmpty(jsonObject, modeOfInjuryBuilder, "1d", "");
                            appendIfNotEmpty(jsonObject, modeOfInjuryBuilder, "1e", "");

                            StringBuilder presentComplaintsBuilder = new StringBuilder();
                            appendIfNotEmpty(jsonObject, presentComplaintsBuilder, "2a", "Present Complaints");
                            appendIfNotEmpty(jsonObject, presentComplaintsBuilder, "2b", "");
                            appendIfNotEmpty(jsonObject, presentComplaintsBuilder, "2c", "");
                            appendIfNotEmpty(jsonObject, presentComplaintsBuilder, "2d", "");
                            appendIfNotEmpty(jsonObject, presentComplaintsBuilder, "2e", "");

                            StringBuilder medicalHistoryBuilder = new StringBuilder();
                            appendIfNotEmpty(jsonObject, medicalHistoryBuilder, "3a", "Medical History");
                            appendIfNotEmpty(jsonObject, medicalHistoryBuilder, "3b", "");
                            appendIfNotEmpty(jsonObject, medicalHistoryBuilder, "3c", "");
                            appendIfNotEmpty(jsonObject, medicalHistoryBuilder, "3d", "");
                            appendIfNotEmpty(jsonObject, medicalHistoryBuilder, "3e", "");
                            appendIfNotEmpty(jsonObject, medicalHistoryBuilder, "3f", "");
                            appendIfNotEmpty(jsonObject, medicalHistoryBuilder, "3g", "");
                            appendIfNotEmpty(jsonObject, medicalHistoryBuilder, "3h", "");
                            appendIfNotEmpty(jsonObject, medicalHistoryBuilder, "3i", "");
                            appendIfNotEmpty(jsonObject, medicalHistoryBuilder, "3j", "");
                            appendIfNotEmpty(jsonObject, medicalHistoryBuilder, "3k", "");
                            appendIfNotEmpty(jsonObject, medicalHistoryBuilder, "3l", "");

                            StringBuilder drugHistoryBuilder = new StringBuilder();
                            appendIfNotEmpty(jsonObject, drugHistoryBuilder, "4a", "Drug History");
                            appendIfNotEmpty(jsonObject, drugHistoryBuilder, "4b", "");
                            appendIfNotEmpty(jsonObject, drugHistoryBuilder, "4c", "");

                            StringBuilder surgicalHistoryBuilder = new StringBuilder();
                            appendIfNotEmpty(jsonObject, surgicalHistoryBuilder, "5a", "Surgical History");
                            appendIfNotEmpty(jsonObject, surgicalHistoryBuilder, "5b", "");
                            appendIfNotEmpty(jsonObject, surgicalHistoryBuilder, "5c", "");
                            appendIfNotEmpty(jsonObject, surgicalHistoryBuilder, "5d", "");

                            StringBuilder socialHistoryBuilder = new StringBuilder();
                            appendIfNotEmpty(jsonObject, socialHistoryBuilder, "a", "Social History");
                            appendIfNotEmpty(jsonObject, socialHistoryBuilder, "b", "");
                            appendIfNotEmpty(jsonObject, socialHistoryBuilder, "c", "");
                            appendIfNotEmpty(jsonObject, socialHistoryBuilder, "d", "");
                            appendIfNotEmpty(jsonObject, socialHistoryBuilder, "e", "");
                            appendIfNotEmpty(jsonObject, socialHistoryBuilder, "f", "");
                            appendIfNotEmpty(jsonObject, socialHistoryBuilder, "g", "");
                            appendIfNotEmpty(jsonObject, socialHistoryBuilder, "h", "");
                            appendIfNotEmpty(jsonObject, socialHistoryBuilder, "i", "");
                            appendIfNotEmpty(jsonObject, socialHistoryBuilder, "j", "");
                            appendIfNotEmpty(jsonObject, socialHistoryBuilder, "other", "");

                            // Set TextViews text
                            modeOfInjuryTextView.setText(modeOfInjuryBuilder.toString().trim());
                            presentComplaintsTextView.setText(presentComplaintsBuilder.toString().trim());
                            comorroid.setText(medicalHistoryBuilder.toString().trim());
                            drugHistoryTextView.setText(drugHistoryBuilder.toString().trim());
                            pasthis.setText(surgicalHistoryBuilder.toString().trim());
                            personalhi.setText(socialHistoryBuilder.toString().trim());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Parameters to be sent to the server.
                Map<String, String> params = new HashMap<>();
                params.put("ipNumber", value); // Change "1234" to the actual value
                return params;
            }
        };

        // Add the request to the RequestQueue
        queue.add(stringRequest);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(case2.this,case3.class);
                intent.putExtra("id",value);
                startActivity(intent);
            }
        });
    }

    // Function to append non-empty values to StringBuilder
    private void appendIfNotEmpty(JSONObject jsonObject, StringBuilder builder, String key, String prefix) throws JSONException {
        String value = jsonObject.getString(key);
        if (!value.isEmpty()) {
            if (!prefix.isEmpty()) {
                builder.append(prefix).append(": ");
            }
            builder.append(value).append("\n");
        }
    }
}
