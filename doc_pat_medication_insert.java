package com.example.orthopedic2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class doc_medication_insertion extends AppCompatActivity {

    private LinearLayout medicineLayout;
    private Button saveMed;
    private EditText medicineNameEditText, doseEditText, sessionEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_medication_insertion);

        medicineLayout = findViewById(R.id.medicineLayout);
        saveMed = findViewById(R.id.okButton);
        medicineNameEditText = findViewById(R.id.medicineNameEditText);
        doseEditText = findViewById(R.id.dose);
        sessionEditText = findViewById(R.id.session);

        // Save medicines button click listener
        saveMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(doc_medication_insertion.this,doc_medication.class);
                startActivity(intent);
                String medicineName = medicineNameEditText.getText().toString();
                String dose = doseEditText.getText().toString();
                String session = sessionEditText.getText().toString();

                // Add medicine information to the layout
                TextView medicineTextView = new TextView(doc_medication_insertion.this);
                medicineTextView.setText(medicineName + "\n" + dose + "\n" + session);
                medicineLayout.addView(medicineTextView);

                // Clear the input fields
                medicineNameEditText.setText("");
                doseEditText.setText("");
                sessionEditText.setText("");
            }
        });
    }
}
