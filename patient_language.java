package com.example.orthopedic2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class pat_lang extends AppCompatActivity {

    Button btnEnglish, btnTamil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_lang);

        btnEnglish = findViewById(R.id.btn1);
        btnTamil = findViewById(R.id.btn2);
        Intent intent = getIntent();
        String value = intent.getStringExtra("id");

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when English button is clicked
                // For example, start a new activity
                Intent intent = new Intent(pat_lang.this, eng_questions.class);
                intent.putExtra("id",value);
                startActivity(intent);
            }
        });

        btnTamil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when Tamil button is clicked
                // For example, start a new activity
                Intent intent = new Intent(pat_lang.this, tam_questions.class);
                intent.putExtra("id",value);
                startActivity(intent);
            }
        });
    }
}
