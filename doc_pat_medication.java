package com.example.orthopedic2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class doc_medication extends AppCompatActivity {

    private TextView courseTextView;
    private LinearLayout medicineLayout;
    private ArrayList<String> Ids = new ArrayList<>();
    private ArrayList<String> Dose = new ArrayList<>();
    private ArrayList<String> MedicineNames = new ArrayList<>();
    private ArrayList<String> Session = new ArrayList<>();
    private Button saveMed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_medication); // Replace 'your_layout' with the actual layout file name

        // Initialize views
        courseTextView = findViewById(R.id.courseTextView);

        medicineLayout = findViewById(R.id.medicineLayout);
        saveMed = findViewById(R.id.saveMed);
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");

        saveMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle saveMed button click
                saveMedicineToDatabase(); // Replace "key" and "value" with your actual data
                Intent intent = new Intent(doc_medication.this,doc_p_reddy.class);
                intent.putExtra("id",value);
                startActivity(intent);

            }
        });

        // Set up other necessary logic as needed
    }

    // Example method for handling the click event of add course button
    public void showMedicineDialog(View view) {
        MedicineInputDialog dialog = new MedicineInputDialog(doc_medication.this);


            dialog.show();
    }

    public void displayMedicineInformation(

            String medicine, String dose, String session) {
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
        // Add details to the ArrayLists
        Ids.add(value);
        MedicineNames.add(medicine);
        Dose.add(dose);
        Session.add(session);


        // Display details on the screen
        displayMedicineDetails();

    }

    private void displayMedicineDetails() {

        LinearLayout linearLayout = findViewById(R.id.medicineLayout);
        // Clear the existing views to avoid duplication
        linearLayout.removeAllViews();

        for (int i = 0; i < MedicineNames.size(); i++) {
            // Create CardView for each medicine entry
            CardView cardView = getFormattedTitleText(
                    MedicineNames.get(i),
                    Dose.get(i),
                    Session.get(i)
            );

            // Set top margin for CardView
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(0, 30, 0, 0);
            cardView.setLayoutParams(layoutParams);

            // Add the CardView to the LinearLayout
            linearLayout.addView(cardView);
        }


    }


    private CardView getFormattedTitleText(
            String Medicinede,String dosede, String sessionde) {
        // Inflate the custom layout for each medicine entry
        CardView cardView = (CardView) getLayoutInflater().inflate(R.layout.medicine_card_view, null);

        // Find TextViews in the custom layout
        TextView medicineTextView = cardView.findViewById(R.id.medicineDoc);
        TextView DoseTextView = cardView.findViewById(R.id.doseDoc);
        TextView SessionTextView = cardView.findViewById(R.id.sessionDoc);


        // Set the text for each TextView
        medicineTextView.setText("Medicine        :  " + Medicinede);
        DoseTextView.setText("Dose               :  " + dosede);
        SessionTextView.setText("Session          :  " + sessionde);


        return cardView;
    }

    public void saveMedicineToDatabase() {
        // Create a JSON array to store the medicine details
        JsonArray jsonArray = new JsonArray();

        for (int i = 0; i < MedicineNames.size(); i++) {
            JsonObject medicineJson = new JsonObject();
            medicineJson.addProperty("id", Ids.get(i));
            medicineJson.addProperty("medicine_name", MedicineNames.get(i));
            medicineJson.addProperty("dose", Dose.get(i));
            medicineJson.addProperty("session", Session.get(i));

            // Add more fields to the JSON object if needed

            // Add the JSON object to the array
            jsonArray.add(medicineJson);
        }

        // Call a method to send the JSON array to the PHP file for database insertion using Retrofit
        sendToPhpFile(jsonArray);
    }
    private void sendToPhpFile(JsonArray jsonArray) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/php/") // Update with your base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Medicine apiService = retrofit.create(Medicine.class);

      Call<JsonElement> call = apiService.saveMedicine(jsonArray);

        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Intent intent1 = getIntent();
                String value = intent1.getStringExtra("id");
                if (response.isSuccessful()) {
                    JsonElement jsonResponse = response.body();

                    if (jsonResponse != null) {
                        if (jsonResponse.isJsonObject()) {
                            // Handle JSON object
                            JsonObject jsonObject = jsonResponse.getAsJsonObject();
                            if (jsonObject.has("status")) {
                                String status = jsonObject.get("status").getAsString();
                                if ("success".equals(status)) {
                                    // Handle success
                                    Toast.makeText(doc_medication.this, "Successfully inserted", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(doc_medication.this,doc_p_reddy.class);
                                    intent.putExtra("id", value);
//
//                                    // Set the result and finish the current activity
//                                    setResult(doc_medication.RESULT_OK, intent);
//                                    finish();
                                } else {
                                    // Handle error
                                    if (jsonObject.has("message")) {
                                        String message = jsonObject.get("message").getAsString();
                                        Toast.makeText(doc_medication.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(doc_medication.this, "Unknown error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            } else {
                                // Handle unexpected response format
                                Toast.makeText(doc_medication.this, "Unexpected response format", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Handle unexpected response format
                            Toast.makeText(doc_medication.this, "Unexpected response format", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Handle unexpected response format
                        Toast.makeText(doc_medication.this, "Unexpected response format", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Handle the error case
                    Toast.makeText(doc_medication.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                // Handle the failure case
                Toast.makeText(doc_medication.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                Log.e("doc_medicine", "Error: " + t.getMessage());
            }
        });
    }
}

