package com.example.lostandfoundpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);



        String getTask = getIntent().getStringExtra("mNameView");
        String getTask2 = getIntent().getStringExtra("mDetailsView");
        String getTask3 = getIntent().getStringExtra("mCityView");

        TextView taskText2 = findViewById(R.id.detailsTextView);
        taskText2.setText(getTask2);


        TextView taskText = findViewById(R.id.City);
        taskText.setText(getTask3);
//
        TextView taskText3 = findViewById(R.id.contactTextView);
        taskText3.setText(getTask);
//







    }
}
