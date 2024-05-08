package com.example.orthopedic2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
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
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class doc_my_profile extends AppCompatActivity {
    private Button button;
    ImageView img;
    private EditText etxt1;
    private EditText etxt2;
    private EditText etxt3;
    private EditText etxt4;
    private EditText etxt5;
    private EditText etxt6;
    private EditText etxt7;


    private String URL = "http://10.0.2.2/PHP/dprofileU.php";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_my_profile);

        button = findViewById(R.id.savede);
        etxt1 = findViewById(R.id.text1);
        etxt2 = findViewById(R.id.text2);
        etxt3 = findViewById(R.id.text3);
        etxt4 = findViewById(R.id.text4);
        etxt5 = findViewById(R.id.text5);
        etxt6 = findViewById(R.id.text6);
        etxt7 = findViewById(R.id.text7);

        fetchStringFromPHP();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendJsonData();

            }
        });
        img = findViewById(R.id.profile_image);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageDialog();
            }
        });
    }

    private void showImageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Image Source");
        builder.setItems(new CharSequence[]{"Camera", "Gallery"}, (dialog, which) -> {
            if (which == 0) {
                dispatchTakePictureIntent();
            } else if (which == 1) {
                pickImageFromGallery();
            }
        });
        builder.show();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        imageCaptureLauncher.launch(takePictureIntent);
    }

    private void pickImageFromGallery() {
        Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        imageGalleryLauncher.launch(pickIntent);
    }

    ActivityResultLauncher<Intent> imageCaptureLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Bundle extras = result.getData().getExtras();
                        Bitmap imageBitmap = (Bitmap) extras.get("data");
                        img.setImageBitmap(imageBitmap);
                    }
                }
            }
    );

    ActivityResultLauncher<Intent> imageGalleryLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        if (result.getData() != null) {
                            try {
                                Uri selectedImageUri = result.getData().getData();
                                Bitmap bitmap = MediaStore.Images.Media.getBitmap(
                                        doc_my_profile.this.getContentResolver(),
                                        selectedImageUri
                                );
                                img.setImageBitmap(bitmap);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
    );

    // Method to convert Bitmap to Base64
    private String convertBitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Log.e("ad", "base64" + byteArray.toString());
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    private void sendJsonData() {
        // Get the data from EditText fields
        String tx1 = etxt1.getText().toString();
        String tx2 = etxt2.getText().toString();
        String tx3 = etxt3.getText().toString();
        String tx4 = etxt4.getText().toString();
        String tx5 = etxt5.getText().toString();
        String tx6 = etxt6.getText().toString();
        String tx7 = etxt7.getText().toString();

        Bitmap imageBitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
        String encodedImage = convertBitmapToBase64(imageBitmap);
        // Create a JSON object with the data
        JSONObject jsonData = new JSONObject();
        try {
            jsonData.put("field1", tx1);
            jsonData.put("field2", tx2);
            jsonData.put("field3", tx3);
            jsonData.put("field4", tx4);
            jsonData.put("field5", tx5);
            jsonData.put("field6", tx6);
            jsonData.put("field7", tx7);
            jsonData.put("profile", encodedImage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");

        // Send the JSON data to the PHP script using Volley
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("sdf","respponse"+response.toString());
                        // Check if the JSON response contains a "status" key
                        if (response.has("status")) {
                            try {
                                String status = response.getString("status");
                                if (status.equals("success")) {
                                    String message = response.getString("message");
                                    Toast.makeText(doc_my_profile.this, message, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(doc_my_profile.this, doc_home.class);
                                    intent.putExtra("id", value);
                                    startActivity(intent);
                                } else {
                                    // Data update was not successful
                                    Toast.makeText(doc_my_profile.this, "Data update failed", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors (if needed)
                        Toast.makeText(doc_my_profile.this, "Error occurred: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }


    private EditText textView1;
    private EditText textView2;
    private EditText textView3;
    private EditText textView4;
    private EditText textView5;
    private EditText textView6;
    private EditText textView7;

    private void fetchStringFromPHP() {
        String url = "http://10.0.2.2/PHP/dprofile.php";
        // Replace with your PHP script's URL
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");

        RequestQueue requestQueue1 = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                textView1 = findViewById(R.id.text1);
                textView2 = findViewById(R.id.text2);
                textView3 = findViewById(R.id.text3);
                textView4 = findViewById(R.id.text4);
                textView5 = findViewById(R.id.text5);
                textView6 = findViewById(R.id.text6);
                textView7 = findViewById(R.id.text7);
                try {
                    Gson gson = new Gson();
                    Log.d("JSON Response", response);
                    JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
                    Log.d("tag", String.valueOf(jsonObject));

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
                        textView5.setText(status);
                        status = jsonObject.get("email").getAsString();
                        textView6.setText(status);
                        status = jsonObject.get("qulaification").getAsString();
                        textView7.setText(status);
                        status = jsonObject.get("img").getAsString();
                        Picasso.get().load("http://10.0.2.2/PHP/"+status).into(img);


                    } else {
                        textView1.setText("D_name not found in JSON response");
                    }
                } catch (Exception e) {
                    textView1.setText("Error: " + e.getMessage());
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle any errors here
                textView1.setText("Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Send the username and password as POST parameters
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
}
