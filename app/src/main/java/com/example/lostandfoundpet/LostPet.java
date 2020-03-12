package com.example.lostandfoundpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LostPet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_pet);






        // Sends User To ALLPAGE
        Button sendToAllPetsPage = findViewById(R.id.viewallButton);
        sendToAllPetsPage.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent sentToAllPetsIntent = new Intent(LostPet.this, AllFoundPets.class);

                LostPet.this.startActivity(sentToAllPetsIntent);

            }
        });

    }
}
