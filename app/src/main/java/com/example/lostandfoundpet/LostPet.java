package com.example.lostandfoundpet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class LostPet extends AppCompatActivity {
    TextView textTargetUri;
    ImageView targetImage;
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






        final Button buttonLoadImage = (Button) findViewById(R.id.button);
        textTargetUri = (TextView) findViewById(R.id.textView10);
        targetImage = (ImageView) findViewById(R.id.imageView2);
        buttonLoadImage.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
                buttonLoadImage.setText("Add Details");
            }
        });

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Uri targetUri = data.getData();
            textTargetUri.setText(targetUri.toString());
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                targetImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // reference http://code2care.org/pages/how-to-display-toast-on-button-click-android/?pages/how-to-display-toast-on-button-click-android
    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

    public void displayToastMessage(View v) {

        toastMsg("SUBMITTED! LETS FIND YOUR PET!");

    }



}
