package com.example.orthopedic2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class case3 extends AppCompatActivity {

    // Declare TextViews for all fields
    private TextView appearanceTextView, pallorTextView, cyanosisTextView, treatmentTextView, familyTextView,
            builtTextView, icterusTextView, clubbingTextView, pulseTextView, bpTextView, pedalEdemaTextView,
            lymphadenopathyTextView, respiratoryRateTextView, temperatureTextView, cardiovascularTextView,
            respiratorySystemTextView, abdomenTextView, centralNervousSystemTextView, rightLimbTextView,
            leftLimbTextView, softTissueTextView, dischargeTextView, neurovascularTextView, otherInjuriesTextView,
            fractureTextView;
    private TextView openInjuryTextView, typeOfUnionTextView, diagnosisTextView,
            initialTreatmentTextView, plannedSurgeryTextView, postOpPeriodTextView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case3);
        Intent intent1 = getIntent();
        String value = intent1.getStringExtra("id");
btn = findViewById(R.id.addButton3);
        // Initialize TextViews for all fields
        appearanceTextView = findViewById(R.id.Appearance);
        pallorTextView = findViewById(R.id.Pallor);
        cyanosisTextView = findViewById(R.id.Cyanosis);
        treatmentTextView = findViewById(R.id.Treatment);
        familyTextView = findViewById(R.id.family);
        builtTextView = findViewById(R.id.Built);
        icterusTextView = findViewById(R.id.Icterus);
        clubbingTextView = findViewById(R.id.Clubbing);
        pulseTextView = findViewById(R.id.Pulse);
        bpTextView = findViewById(R.id.bp);
        pedalEdemaTextView = findViewById(R.id.Pedal_Edema);
        lymphadenopathyTextView = findViewById(R.id.Lymphadenopathy);
        respiratoryRateTextView = findViewById(R.id.Respiratory);
        temperatureTextView = findViewById(R.id.Temperature);
        cardiovascularTextView = findViewById(R.id.Cardiovascular);
        respiratorySystemTextView = findViewById(R.id.Respiratory_system);
        abdomenTextView = findViewById(R.id.Abdomen);
        centralNervousSystemTextView = findViewById(R.id.Central_Nervous);
        rightLimbTextView = findViewById(R.id.right_limb);
        leftLimbTextView = findViewById(R.id.left_limb);
        softTissueTextView = findViewById(R.id.Soft_tissue);
        dischargeTextView = findViewById(R.id.Discharge1);
        neurovascularTextView = findViewById(R.id.Neurovascular);
        otherInjuriesTextView = findViewById(R.id.other_injuries);
        fractureTextView = findViewById(R.id.FRACTURE);
        openInjuryTextView = findViewById(R.id.OPEN_INJURY);
        typeOfUnionTextView = findViewById(R.id.NON_UNION);
        diagnosisTextView = findViewById(R.id.FINAL_DIAGNOSIS);
        initialTreatmentTextView = findViewById(R.id.INITIAL_TREATMENT);
        plannedSurgeryTextView = findViewById(R.id.PLANNED_SURGERY);
        postOpPeriodTextView = findViewById(R.id.POST_OP_PERIOD);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2/php/case_3.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // Parsing JSON response
                            JSONObject jsonObject = new JSONObject(response);

                            // Extracting data and setting it to TextViews
                            appearanceTextView.setText(jsonObject.getString("appearance"));
                            pallorTextView.setText(jsonObject.getString("pallor"));
                            cyanosisTextView.setText(jsonObject.getString("cyanosis"));
                            treatmentTextView.setText(jsonObject.getString("treatment"));
                            familyTextView.setText(jsonObject.getString("family"));
                            builtTextView.setText(jsonObject.getString("built"));
                            icterusTextView.setText(jsonObject.getString("icterus"));
                            clubbingTextView.setText(jsonObject.getString("clubbing"));
                            pulseTextView.setText(jsonObject.getString("pulse"));
                            bpTextView.setText(jsonObject.getString("bp"));
                            pedalEdemaTextView.setText(jsonObject.getString("pedal"));
                            lymphadenopathyTextView.setText(jsonObject.getString("lymphadeno"));
                            respiratoryRateTextView.setText(jsonObject.getString("respiratory"));
                            temperatureTextView.setText(jsonObject.getString("temperature"));
                            cardiovascularTextView.setText(jsonObject.getString("card"));
                            respiratorySystemTextView.setText(jsonObject.getString("respirat"));
                            abdomenTextView.setText(jsonObject.getString("abdomen"));
                            centralNervousSystemTextView.setText(jsonObject.getString("central"));
                            rightLimbTextView.setText(jsonObject.getString("right1"));
                            leftLimbTextView.setText(jsonObject.getString("left1"));
                            softTissueTextView.setText(jsonObject.getString("soft"));
                            dischargeTextView.setText(jsonObject.getString("discharge"));
                            neurovascularTextView.setText(jsonObject.getString("neurova"));
                            otherInjuriesTextView.setText(jsonObject.getString("other"));
                            fractureTextView.setText(jsonObject.getString("fracture"));
                            openInjuryTextView.setText(jsonObject.getString("open"));
                            typeOfUnionTextView.setText(jsonObject.getString("non"));
                            diagnosisTextView.setText(jsonObject.getString("fina"));
                            initialTreatmentTextView.setText(jsonObject.getString("initial"));
                            plannedSurgeryTextView.setText(jsonObject.getString("planned"));
                            postOpPeriodTextView.setText(jsonObject.getString("post"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
        @Override
        protected Map<String, String> getParams() {
            // Parameters to be sent to the server.
            Map<String, String> params = new HashMap<>();
            params.put("ipNumber",value);
            return params;
        }
    };

        // Add the request to the RequestQueue.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(case3.this,doc_p_reddy.class);
                intent.putExtra("id",value);
                startActivity(intent);
            }
        });
        queue.add(stringRequest);
    }
}
