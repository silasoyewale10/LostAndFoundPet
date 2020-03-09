package com.example.lostandfoundpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Sends User To Lost Page
        Button sendToLostPage = findViewById(R.id.lostbutton);
        sendToLostPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent sentToLostIntent = new Intent(MainActivity.this, LostPet.class);

                MainActivity.this.startActivity(sentToLostIntent);

            }
        });






        // Sends User To Found Page
        Button sendtoFoundPage = findViewById(R.id.foundbutton);
        sendtoFoundPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent sentToFoundIntent = new Intent(MainActivity.this, FoundPet.class);

                MainActivity.this.startActivity(sentToFoundIntent);

            }
        });









    }
}

