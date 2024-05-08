// pat_medication.java
package com.example.orthopedic2;
import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pat_medication extends AppCompatActivity {

    private static final String TAG = pat_medication.class.getSimpleName();
    private RecyclerView recyclerView;
    private MedicationAdapter adapter;
    private List<Medication> medicationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_medication);
        Button takenButton = findViewById(R.id.taken);
        Button notTakenButton = findViewById(R.id.not_taken);
        // Set click listener for the "Taken" button
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
        takenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the "Taken" button click event
                // For now, let's display a toast message as an example
                Toast.makeText(pat_medication.this, "Medication taken!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(pat_medication.this,patient_reddy.class);
                intent.putExtra("id",value);
                startActivity(intent);
                finish();
            }
        });

        // Set click listener for the "Not Taken" button
        notTakenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the "Not Taken" button click event
                // For now, let's display a toast message as an example
                Toast.makeText(pat_medication.this, "Medication not taken!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(pat_medication.this,pat_complaints.class);
                intent.putExtra("id",value);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        medicationList = new ArrayList<>();
        adapter = new MedicationAdapter(this, medicationList);
        recyclerView.setAdapter(adapter);

        // Call fetchMedicationData method to fetch medication data
        fetchMedicationData(this, "23"); // Change "23" to the actual ID you want to send
    }

    private void fetchMedicationData(Context context, final String id) {
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://10.0.2.2/PHP/medDisplay.php"; // Replace with your PHP script URL

        // Create a StringRequest to hold the parameters
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "Response: " + response);
                        try {
                            // Parse the JSON array response
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject medObject = jsonArray.getJSONObject(i);
                                String medicineName = medObject.getString("Medicine_name");
                                String dose = medObject.getString("Dose");
                                String type = medObject.getString("Type");
                                // Create a Medication object and add it to the list
                                Medication medication = new Medication(medicineName, dose, type);
                                medicationList.add(medication);
                            }
                            // Notify the adapter that the dataset has changed
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Error: " + error.toString());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", value);
                return params;
            }
        };

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


}

// Medication.java


 class Medication {
    private String medicineName;
    private String dose;
    private String type;

    public Medication(String medicineName, String dose, String type) {
        this.medicineName = medicineName;
        this.dose = dose;
        this.type = type;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getDose() {
        return dose;
    }

    public String getType() {
        return type;
    }
}


 class MedicationAdapter extends RecyclerView.Adapter<MedicationAdapter.ViewHolder> {

    private Context context;
    private List<Medication> medicationList;

    public MedicationAdapter(Context context, List<Medication> medicationList) {
        this.context = context;
        this.medicationList = medicationList;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.medication_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medication medication = medicationList.get(position);
        holder.medicineNameTextView.setText("Medicine name  :  "+medication.getMedicineName());
        holder.doseTextView.setText("Dose                     :  "+medication.getDose());
        holder.typeTextView.setText("Medication          :  "+medication.getType());
    }

    @Override
    public int getItemCount() {
        return medicationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView medicineNameTextView;
        TextView doseTextView;
        TextView typeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            medicineNameTextView = itemView.findViewById(R.id.medicineNameTextView);
            doseTextView = itemView.findViewById(R.id.doseTextView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
        }
    }
}
