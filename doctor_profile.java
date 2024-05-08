package com.example.orthopedic2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class doc_profile_edit extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;

    private  TextView textView7 ;
    ImageView img;
    private Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_profile_edit);
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
        Log.d("id---->",value);
        img = findViewById(R.id.img);
        textView1= findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);
        textView3=findViewById(R.id.text3);
        textView4=findViewById(R.id.text4);
        textView5=findViewById(R.id.text5);
        textView6=findViewById(R.id.text6);
        textView7 =findViewById(R.id.text7);

        // Make an HTTP request to your PHP script
        fetchStringFromPHP();
        btn = findViewById(R.id.edit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doc_profile_edit.this,doc_my_profile.class);
                intent.putExtra("id",value);
                startActivity(intent);
            }
        });

    }

    private void fetchStringFromPHP() {
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");

        String url = "http://10.0.2.2/PHP/dprofile.php"; // Replace with your PHP script's URL

        RequestQueue requestQueue1 = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    Gson gson = new Gson();
                    Log.d("JSON Response", response);
                    JsonObject jsonObject = gson.fromJson(response, JsonObject.class);

                    // Check if the "D_name" field exists in the JSON response
                    if (jsonObject.has("did")) {
                        String status = jsonObject.get("name").getAsString();
                        textView1.setText(status);
                        status = jsonObject.get("working").getAsString();
                        textView2.setText(status);

                        status = jsonObject.get("age").getAsString();
                        textView3.setText(status);
                        status = jsonObject.get("did").getAsString();
                        textView4.setText(status);

                        status = jsonObject.get("phno").getAsString();
                        textView5.setText(status);   status = jsonObject.get("email").getAsString();
                        textView6.setText(status);
                        status = jsonObject.get("qulaification").getAsString();
                        textView7.setText(status);
                        status = jsonObject.get("img").getAsString();
                        Toast.makeText(doc_profile_edit.this, status, Toast.LENGTH_SHORT).show();
                        Picasso.get().load("http://10.0.2.2/PHP/"+status).into(img);


                    } else {
                        textView1.setText("D_name not found in JSON response");
                    }
                } catch (Exception e) {
                    textView1.setText("Error: " + e.getMessage());
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle any errors here
                textView1.setText("Error: " + error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Send the username and password as POST parameters
                Map<String, String> data = new HashMap<>();
                data.put("P_id",value);

                return data;
            }
        };

        // Customize the retry policy
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        // Initialize the Volley request queue and add the request
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
        ;
    }
}
