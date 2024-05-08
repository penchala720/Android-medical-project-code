package com.example.orthopedic2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class doc_p_reddy extends AppCompatActivity {
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;

    private ImageView img5;
    private ImageView img6;
    private ImageView img7;
    private ImageView img8;
    private TextView txt;
    String value;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_p_reddy);
        txt = findViewById(R.id.txt);
        img1 = findViewById(R.id.logout);
        img2 = findViewById(R.id.comp);
        img3 = findViewById(R.id.sug);

        img5 = findViewById(R.id.score);
        img6 = findViewById(R.id.med);
        img7 = findViewById(R.id.case_sheet);
        img8 = findViewById(R.id.review);
        Intent intent1 = getIntent();
        value = intent1.getStringExtra("id");
        txt.setText(value);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doc_p_reddy.this, doc_home.class);
                intent.putExtra("id", value);
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doc_p_reddy.this, doc_complaints.class);
                intent.putExtra("id", value);
                startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doc_p_reddy.this, surgery_1.class);
                intent.putExtra("id", value);
                startActivity(intent);
            }
        });


        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doc_p_reddy.this, score_sheet_1.class);
                intent.putExtra("id", value);
                startActivity(intent);
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doc_p_reddy.this, doc_medication.class);
                intent.putExtra("id", value);
                startActivity(intent);
            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doc_p_reddy.this, case1.class);
                intent.putExtra("id", value);
                startActivity(intent);
            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doc_p_reddy.this, doc_reviews.class);
                intent.putExtra("id", value);
                startActivity(intent);
            }
        });

    }
}
