package com.example.orthopedic2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class doc_home extends AppCompatActivity {
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_home);

        // Find views by their IDs
        img1 = findViewById(R.id.image1);
        img2 = findViewById(R.id.logout);
        img3 = findViewById(R.id.image3);
        img4 = findViewById(R.id.image4);
        img5 = findViewById(R.id.image5);

        // Set click listeners for your views
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout button click
                Intent intent = new Intent(doc_home.this,com_notification.class);
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout button click
                Intent intent = new Intent(doc_home.this,admin.class);
                startActivity(intent);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle view patient button click
                Intent intent1 = getIntent();
                String value = intent1.getStringExtra("id");
                Intent intent = new Intent(doc_home.this,add_patient.class);
                intent.putExtra("id",value);
                startActivity(intent);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle my profile button click
                Intent intent = new Intent(doc_home.this,doc_search.class);
                startActivity(intent);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle my profile button click
                Intent intent1 = getIntent();
                String value = intent1.getStringExtra("id");
                Intent intent = new Intent(doc_home.this,doc_profile_edit.class);
                intent.putExtra("id",value);
                startActivity(intent);
            }
        });
    }
}

