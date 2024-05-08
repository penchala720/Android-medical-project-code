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

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class eng_questions extends AppCompatActivity {

    private RadioGroup question1RadioGroup;
    private RadioGroup question2RadioGroup;
    private RadioGroup question3RadioGroup;
    private RadioGroup question4RadioGroup;
    private RadioGroup question5RadioGroup;
    private RadioGroup question6RadioGroup;
    private RadioGroup question7RadioGroup;
    private RadioGroup question8RadioGroup;
    private RadioGroup question9RadioGroup;
    private RadioGroup question10RadioGroup;

    private String URL = "http://10.0.2.2/PHP/eng_questions.php";

    // Define RadioGroups for all questions...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng_questions);

        question1RadioGroup = findViewById(R.id.question1_radio_group);
        question2RadioGroup = findViewById(R.id.question2_radio_group);
        question3RadioGroup = findViewById(R.id.question3_radio_group);
        question4RadioGroup = findViewById(R.id.question4_radio_group);
        question5RadioGroup = findViewById(R.id.question5_radio_group);
        question6RadioGroup = findViewById(R.id.question6_radio_group);
        question7RadioGroup = findViewById(R.id.question7_radio_group);
        question8RadioGroup = findViewById(R.id.question8_radio_group);
        question9RadioGroup = findViewById(R.id.question9_radio_group);
        question10RadioGroup = findViewById(R.id.question10_radio_group);


        Button submitButton = findViewById(R.id.btn1);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        // Get the selected options for each question
        int selectedOption1Id = getSelectedOptionId(question1RadioGroup);
        int selectedOption2Id = getSelectedOptionId(question2RadioGroup);
        int selectedOption3Id = getSelectedOptionId(question3RadioGroup);
        int selectedOption4Id = getSelectedOptionId(question4RadioGroup);
        int selectedOption5Id = getSelectedOptionId(question5RadioGroup);
        int selectedOption6Id = getSelectedOptionId(question6RadioGroup);
        int selectedOption7Id = getSelectedOptionId(question7RadioGroup);
        int selectedOption8Id = getSelectedOptionId(question8RadioGroup);
        int selectedOption9Id = getSelectedOptionId(question9RadioGroup);
        int selectedOption10Id = getSelectedOptionId(question10RadioGroup);

        // You now have the values 1 for selected option 1 and 0 for unselected option for all questions.
            // You can use these values as needed, such as storing them in variables, arrays, or performing calculations.
        if (selectedOption1Id != -1 && selectedOption2Id != -1 && selectedOption3Id != -1 && selectedOption4Id != -1 && selectedOption5Id != -1 && selectedOption6Id != -1 && selectedOption7Id != -1 && selectedOption8Id != -1) {
            // For demonstration, here we are just displaying a toast message with the selected values
            String message = "Response : ";

            int count=0;
            count=count+selectedOption1Id;
            count=count+selectedOption2Id;
            count=count+selectedOption3Id;
            count=count+selectedOption4Id;
            count=count+selectedOption5Id;
            count=count+selectedOption6Id;
            count=count+selectedOption7Id;
            count=count+selectedOption8Id;
            count=count+selectedOption9Id;
            count=count+selectedOption10Id;
            count=count*20;
            String review;
            int ans=count/10;
            if(ans>79)
            {
                review="Failure";
            }
            else if(ans>59)
            {
                review="Poor";
            }
            else if(ans>39)
            {
                review="Fair";
            }
            else if(ans>19)
            {
                review="Good";
            }
            else
            {
                review="Excellent";
            }
            transferdatatodatabase(review);
            message=message+review;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            // If any question is not answered, display a toast message asking to complete the questionnaire
            Toast.makeText(this, "Please answer all questions", Toast.LENGTH_SHORT).show();
        }
    }
    // Function to get the selected option index in a RadioGroup
    private int getSelectedOptionId(RadioGroup radioGroup) {
        int selectedOptionIndex = radioGroup.indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId()));
        // Adding 1 to convert index to option number
        return selectedOptionIndex + 1;
    }
    //now creating a function to transfer the result data to the database
    private void transferdatatodatabase(String val) {
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
        // Get the data from EditText fields
        String tx1 = val;
        String tx2 = value;


        // Create a JSON object with the data
        JSONObject jsonData = new JSONObject();
        try {
            Log.d("tag1",tx1);
            Log.d("tag2",tx2);
            jsonData.put("field1", tx1);
            jsonData.put("field2", tx2);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Send the JSON data to the PHP script using Volley
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        // Check if the JSON response contains a "status" key
                        if (response.has("status")) {
                            String status = null;
                            try {
                                status = response.getString("status");
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            if (status.equals("success")) {
                                // Data was updated successfully
                                try {
                                    String message = response.getString("message");
                                    Toast.makeText(eng_questions.this, message, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(eng_questions.this, patient_reddy.class);
                                    intent.putExtra("id",value);
                                    startActivity(intent);
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }

                            } else {
                                // Data update was not successful
                                try {
                                    String message = response.getString("message");
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }

                            }
                        } else {

                        }
                    }


                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors (if needed)
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }
}
