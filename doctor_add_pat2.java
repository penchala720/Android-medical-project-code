package com.example.orthopedic2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

public class add_patient2 extends AppCompatActivity {
    String pc1 = "";
    String pc2 = "";
    String pc3 = "";
    String pc4 = "";
    String pc5 = "";
    String pc6 = "";
    String pc7 = "";
    String pc8 = "";
    String pc9 = "";
    String pc10 = "";
    String pc11 = "";
    String pc12 = "";
    String pc13 = "";
    String pc14 = "";
    String pc15 = "";
    String pc16 = "";
    String pc17 = "";
    String pc18 = "";
    String pc19 = "";
    String pc20 = "";
    String pc21 = "";
    String pc22 = "";
    String pc23 = "";
    String pc24 = "";
    String pc25 = "";
    String pc26 = "";
    String pc27 = "";
    String pc28 = "";
    String pc29 = "";
    String pc30 = "";
    String pc31 = "";
    String pc32 = "";
    String pc33 = "";
    String pc34 = "";
    String pc35 = "";
    String pc36 = "";
    String pc37 = "";
    String pc38 = "";
    String pc39 = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient2);
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");

        // Initialize UI elements
        CheckBox c1 = findViewById(R.id.c1);
        CheckBox c2 = findViewById(R.id.c2);
        CheckBox c3 = findViewById(R.id.c3);
        CheckBox c4 = findViewById(R.id.c4);
        CheckBox c5 = findViewById(R.id.c5);
        CheckBox c6 = findViewById(R.id.c6);
        CheckBox c7 = findViewById(R.id.c7);
        CheckBox c8 = findViewById(R.id.c8);
        CheckBox c9 = findViewById(R.id.c9);
        CheckBox c10 = findViewById(R.id.c10);
        CheckBox c11 = findViewById(R.id.c11);
        CheckBox c12 = findViewById(R.id.c12);
        CheckBox c13 = findViewById(R.id.c13);
        CheckBox c14 = findViewById(R.id.c14);
        CheckBox c15 = findViewById(R.id.c15);
        CheckBox c16 = findViewById(R.id.c16);
        CheckBox c17 = findViewById(R.id.c17);
        CheckBox c18 = findViewById(R.id.c18);
        CheckBox c19 = findViewById(R.id.c19);
        CheckBox c20 = findViewById(R.id.c20);
        CheckBox c21 = findViewById(R.id.c21);
        CheckBox c22 = findViewById(R.id.c22);
        CheckBox c23 = findViewById(R.id.c23);
        CheckBox c24 = findViewById(R.id.c24);
        CheckBox c25 = findViewById(R.id.c25);
        CheckBox c26 = findViewById(R.id.c26);
        CheckBox c27 = findViewById(R.id.c27);
        CheckBox c28 = findViewById(R.id.c28);
        CheckBox c29 = findViewById(R.id.c29);
        CheckBox c30 = findViewById(R.id.c30);
        CheckBox c31 = findViewById(R.id.c31);
        CheckBox c32 = findViewById(R.id.c32);
        CheckBox c33 = findViewById(R.id.c33);
        CheckBox c34 = findViewById(R.id.c34);
        CheckBox c35 = findViewById(R.id.c35);
        CheckBox c36 = findViewById(R.id.c36);
        CheckBox c37 = findViewById(R.id.c37);
        CheckBox c38 = findViewById(R.id.c38);
        CheckBox c39 = findViewById(R.id.c39);
        EditText others = findViewById(R.id.others);
        Button addButton2 = findViewById(R.id.addButton2);

        // Set click listener for the NEXT PAGE button
        addButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder selectedItems = new StringBuilder();

                // Check each checkbox and append its text to the selectedItems string if checked
                if (c1.isChecked()) pc1 = c1.getHint().toString();
                if (c2.isChecked()) pc2 = c2.getHint().toString();
                if (c3.isChecked()) pc3 = c3.getHint().toString();
                if (c4.isChecked()) pc4 = c4.getHint().toString();
                if (c5.isChecked()) pc5 = c5.getHint().toString();
                if (c6.isChecked()) pc6 = c6.getHint().toString();
                if (c7.isChecked()) pc7 = c7.getHint().toString();
                if (c8.isChecked()) pc8 = c8.getHint().toString();
                if (c9.isChecked()) pc9 = c9.getHint().toString();
                if (c10.isChecked()) pc10 = c10.getHint().toString();
                if (c11.isChecked()) pc11 = c11.getHint().toString();
                if (c12.isChecked()) pc12 = c12.getHint().toString();
                if (c13.isChecked()) pc13 = c13.getHint().toString();
                if (c14.isChecked()) pc14 = c14.getHint().toString();
                if (c15.isChecked()) pc15 = c15.getHint().toString();
                if (c16.isChecked()) pc16 = c16.getHint().toString();
                if (c17.isChecked()) pc17 = c17.getHint().toString();
                if (c18.isChecked()) pc18 = c18.getHint().toString();
                if (c19.isChecked()) pc19 = c19.getHint().toString();
                if (c20.isChecked()) pc20 = c20.getHint().toString();
                if (c21.isChecked()) pc21 = c21.getHint().toString();
                if (c22.isChecked()) pc22 = c22.getHint().toString();
                if (c23.isChecked()) pc23 = c23.getHint().toString();
                if (c24.isChecked()) pc24 = c24.getHint().toString();
                if (c25.isChecked()) pc25 = c25.getHint().toString();
                if (c26.isChecked()) pc26 = c26.getHint().toString();
                if (c27.isChecked()) pc27 = c27.getHint().toString();
                if (c28.isChecked()) pc28 = c28.getHint().toString();
                if (c29.isChecked()) pc29 = c29.getHint().toString();
                if (c30.isChecked()) pc30 = c30.getHint().toString();
                if (c31.isChecked()) pc31 = c31.getHint().toString();
                if (c32.isChecked()) pc32 = c32.getHint().toString();
                if (c33.isChecked()) pc33 = c33.getHint().toString();
                if (c34.isChecked()) pc34 = c34.getHint().toString();
                if (c35.isChecked()) pc35 = c35.getHint().toString();
                if (c36.isChecked()) pc36 = c36.getHint().toString();
                if (c37.isChecked()) pc37 = c37.getHint().toString();
                if (c38.isChecked()) pc38 = c38.getHint().toString();
                if (c39.isChecked()) pc39 = c39.getHint().toString();




                // Add the text from the 'others' EditText if it's not empty
                String otherText = others.getText().toString().trim();
                if (!otherText.isEmpty()) {
                    selectedItems.append(otherText);
                }


                // Create an intent to start the next activity
//                Intent intent = new Intent(add_patient2.this, add_patient3.class);
//                // Put the selected items string as an extra to pass it to the next activity
//                intent.putExtra("selectedItems", selectedItems.toString());
//                // Start the next activity
//                startActivity(intent);


                RequestQueue queue = Volley.newRequestQueue(add_patient2.this);
                String url = "http://10.0.2.2/php/addPatient2.php"; // Replace with your PHP script URL

                // Request a string response from the provided URL
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Intent intent1 = getIntent();
                                String value1 = intent1.getStringExtra("id1");
                                // Display a toast message upon successful storage
                                Toast.makeText(add_patient2.this, "Data stored successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(add_patient2.this,add_patient3.class);
                                intent.putExtra("id",value);
                                intent.putExtra("id1",value1);
                                startActivity(intent);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Display a toast message upon error
                        Toast.makeText(add_patient2.this, "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        // Pass parameters to PHP script
                        params.put("id", value);
                        params.put("c1", pc1);
                        params.put("c2", pc2);
                        params.put("c3", pc3);
                        params.put("c4", pc4);
                        params.put("c5", pc5);
                        params.put("c6", pc6);
                        params.put("c7", pc7);
                        params.put("c8", pc8);
                        params.put("c9", pc9);
                        params.put("c10", pc10);
                        params.put("c11", pc11);
                        params.put("c12", pc12);
                        params.put("c13", pc13);
                        params.put("c14", pc14);
                        params.put("c15", pc15);
                        params.put("c16", pc16);
                        params.put("c17", pc17);
                        params.put("c18", pc18);
                        params.put("c19", pc19);
                        params.put("c20", pc20);
                        params.put("c21", pc21);
                        params.put("c22", pc22);
                        params.put("c23", pc23);
                        params.put("c24", pc24);
                        params.put("c25", pc25);
                        params.put("c26", pc26);
                        params.put("c27", pc27);
                        params.put("c28", pc28);
                        params.put("c29", pc29);
                        params.put("c30", pc30);
                        params.put("c31", pc31);
                        params.put("c32", pc32);
                        params.put("c33", pc33);
                        params.put("c34", pc34);
                        params.put("c35", pc35);
                        params.put("c36", pc36);
                        params.put("c37", pc37);
                        params.put("c38", pc38);
                        params.put("c39", pc39);
                        params.put("text",otherText);

                        return params;
                    }
                };
                queue.add(stringRequest);





            }
        });
    }
}
