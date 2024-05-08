package com.example.orthopedic2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class add_patient3 extends AppCompatActivity {

    // Declare EditText variables for systemic examination
    private EditText appearanceEditText, pallorEditText, cyanosisEditText,
            treatmentEditText, familyEditText, builtEditText,
            icterusEditText, clubbingEditText, pulseEditText,
            bpEditText, pedalEdemaEditText, lymphadenopathyEditText;

    // Declare EditText variables for systemic examination
    private EditText respiratoryRateEditText, temperatureEditText,
            cardiovascularEditText, respiratorySystemEditText,
            abdomenEditText, centralNervousEditText,
            rightLimbEditText, leftLimbEditText, softTissueEditText,
            dischargeEditText1, neurovascularEditText, otherInjuriesEditText;

    // Declare EditText variables for diagnosis and treatment
    private EditText fractureEditText, openInjuryEditText, nonUnionEditText,
            finalDiagnosisEditText, initialTreatmentEditText, plannedSurgeryEditText,
            postOpPeriodEditText;


    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient3);
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
        // Initialize EditText fields for systemic examination
        appearanceEditText = findViewById(R.id.Appearance);
        pallorEditText = findViewById(R.id.Pallor);
        cyanosisEditText = findViewById(R.id.Cyanosis);
        treatmentEditText = findViewById(R.id.Treatment);
        familyEditText = findViewById(R.id.family);
        builtEditText = findViewById(R.id.Built);
        icterusEditText = findViewById(R.id.Icterus);
        clubbingEditText = findViewById(R.id.Clubbing);
        pulseEditText = findViewById(R.id.Pulse);
        bpEditText = findViewById(R.id.bp);
        pedalEdemaEditText = findViewById(R.id.Pedal_Edema);
        lymphadenopathyEditText = findViewById(R.id.Lymphadenopathy);

        // Initialize EditText fields for systemic examination
        respiratoryRateEditText = findViewById(R.id.Respiratory);
        temperatureEditText = findViewById(R.id.Temperature);
        cardiovascularEditText = findViewById(R.id.Cardiovascular);
        respiratorySystemEditText = findViewById(R.id.Respiratory_system);
        abdomenEditText = findViewById(R.id.Abdomen);
        centralNervousEditText = findViewById(R.id.Central_Nervous);
        rightLimbEditText = findViewById(R.id.right_limb);
        leftLimbEditText = findViewById(R.id.left_limb);
        softTissueEditText = findViewById(R.id.Soft_tissue);
        dischargeEditText1 = findViewById(R.id.Discharge1);
        neurovascularEditText = findViewById(R.id.Neurovascular);
        otherInjuriesEditText = findViewById(R.id.other_injuries);

        // Initialize EditText fields for diagnosis and treatment
        fractureEditText = findViewById(R.id.FRACTURE);
        openInjuryEditText = findViewById(R.id.OPEN_INJURY);
        nonUnionEditText = findViewById(R.id.NON_UNION);
        finalDiagnosisEditText = findViewById(R.id.FINAL_DIAGNOSIS);
        initialTreatmentEditText = findViewById(R.id.INITIAL_TREATMENT);
        plannedSurgeryEditText = findViewById(R.id.PLANNED_SURGERY);
        postOpPeriodEditText = findViewById(R.id.POST_OP_PERIOD);

        addButton = findViewById(R.id.addButton3);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertDataIntoDatabase();
            }

        });
    }

    private void insertDataIntoDatabase() {
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
        // Get text from EditText fields
        final String appearance = appearanceEditText.getText().toString().trim();
        final String pallor = pallorEditText.getText().toString().trim();
        final String cyanosis = cyanosisEditText.getText().toString().trim();
        final String treatment = treatmentEditText.getText().toString().trim();
        final String family = familyEditText.getText().toString().trim();
        final String built = builtEditText.getText().toString().trim();
        final String icterus = icterusEditText.getText().toString().trim();
        final String clubbing = clubbingEditText.getText().toString().trim();
        final String pulse = pulseEditText.getText().toString().trim();
        final String bp = bpEditText.getText().toString().trim();
        final String pedal = pedalEdemaEditText.getText().toString().trim();
        final String lymphadeno = lymphadenopathyEditText.getText().toString().trim();
        final String respiratory = respiratoryRateEditText.getText().toString().trim();
        final String temperature = temperatureEditText.getText().toString().trim();
        final String card = cardiovascularEditText.getText().toString().trim();
        final String respirat = respiratorySystemEditText.getText().toString().trim();
        final String abdomen = abdomenEditText.getText().toString().trim();
        final String central = centralNervousEditText.getText().toString().trim();
        final String right = rightLimbEditText.getText().toString().trim();
        final String left = leftLimbEditText.getText().toString().trim();
        final String soft = softTissueEditText.getText().toString().trim();
        final String discharge = dischargeEditText1.getText().toString().trim();
        final String neurova = neurovascularEditText.getText().toString().trim();
        final String other = otherInjuriesEditText.getText().toString().trim();
        final String fracture = fractureEditText.getText().toString().trim();
        final String open = openInjuryEditText.getText().toString().trim();
        final String non = nonUnionEditText.getText().toString().trim();
        final String fina = finalDiagnosisEditText.getText().toString().trim();
        final String initial = initialTreatmentEditText.getText().toString().trim();
        final String planned = plannedSurgeryEditText.getText().toString().trim();
        final String post = postOpPeriodEditText.getText().toString().trim();



        // Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(add_patient3.this);
        String url = "http://10.0.2.2/php/addPatient3.php"; // Replace with your PHP script URL

        // Request a string response from the provided URL
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response",response);
                        Intent intent1 = getIntent();
                        String value1 = intent1.getStringExtra("id1");
                        // Display a toast message upon successful storage
                        Toast.makeText(add_patient3.this, "Data stored successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(add_patient3.this,doc_home.class);
                        intent.putExtra("id",value1);
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Display a toast message upon error
                Toast.makeText(add_patient3.this, "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                // Pass parameters to PHP script
                params.put("id",value);
                params.put("appearance", appearance);
                params.put("pallor", pallor);
                params.put("cyanosis", cyanosis);
                params.put("treatment", treatment);
                params.put("family", family);
                params.put("built", built);
                params.put("icterus", icterus);
                params.put("clubbing", clubbing);
                params.put("pulse", pulse);
                params.put("bp", bp);
                params.put("pedal", pedal);
                params.put("lymphadeno", lymphadeno);
                params.put("respiratory", respiratory);
                params.put("temperature", temperature);
                params.put("card", card);
                params.put("respirat", respirat);
                params.put("abdomen", abdomen);
                params.put("central", central);
                params.put("right1", right);
                params.put("left1", left);
                params.put("soft", soft);
                params.put("discharge", discharge);
                params.put("neurova", neurova);
                params.put("other", other);
                params.put("fracture", fracture);
                params.put("open", open);
                params.put("non", non);
                params.put("fina", fina);
                params.put("initial", initial);
                params.put("planned", planned);
                params.put("post", post);
                // Add other parameters here...
                return params;
            }
        };

        // Add the request to the RequestQueue
        queue.add(stringRequest);
    }
}
