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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class pat_profile_edit extends AppCompatActivity {

    private TextView textView1;

    private TextView textView3;

    private TextView textView5;
    private TextView textView6;

    private  TextView textView7 ;
    private Button btn;
    ImageView img;
    ImageView logout;
    String value;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_profile_edit);
        Intent intent1 = getIntent();
        value = intent1.getStringExtra("id");

        img = findViewById(R.id.img);
        logout = findViewById(R.id.logout);
        textView1= findViewById(R.id.text1);
        textView3=findViewById(R.id.text3);
        textView5=findViewById(R.id.text5);
        textView6=findViewById(R.id.text6);
        textView7 =findViewById(R.id.text7);

        // Make an HTTP request to your PHP script
        fetchStringFromPHP();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pat_profile_edit.this,admin.class);
                startActivity(intent);
            }
        });
        btn = findViewById(R.id.edit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pat_profile_edit.this,pat_profile.class);
                intent.putExtra("id",value);
                startActivity(intent);
            }
        });

    }

    private void fetchStringFromPHP() {


        String url = "http://10.0.2.2/PHP/pat_profile.php"; // Replace with your PHP script's URL

        RequestQueue requestQueue1 = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    // Check if the "id" field exists in the JSON response
                    if (jsonObject.has("pid")) {
                        String id = jsonObject.getString("pid");
                        String name = jsonObject.getString("name");
                        String age = jsonObject.getString("age");
                        String phno = jsonObject.getString("phno");
                        String email = jsonObject.getString("email");
                        String qualification = jsonObject.getString("qualification");
                        String image = jsonObject.getString("image");

                        // Now you can use these values as needed, for example:
                        textView1.setText(name);
                        textView3.setText(age);
                        textView5.setText(phno);
                        textView6.setText(email);
                        textView7.setText(qualification);

                        // Load image using Picasso library
                        Picasso.get().load("http://10.0.2.2/PHP/" + image).into(img);
                    } else {
                        textView1.setText("id not found in JSON response");
                    }
                } catch (JSONException e) {
                    // Handle JSON parsing error
                    Toast.makeText(pat_profile_edit.this, e.toString(), Toast.LENGTH_SHORT).show();
                    Log.e("dv","err"+e);
                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle any errors here
//                textView1.setText("Error: " + error.getMessage());

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
