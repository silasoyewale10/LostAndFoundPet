package com.example.lostandfoundpet;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserState;
import com.amazonaws.mobile.client.UserStateDetails;

import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;
    String cityName = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //location permission below
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        boolean permissionToAccessCoarseLocation = ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION)

                == PackageManager.PERMISSION_GRANTED;
        if(!permissionToAccessCoarseLocation){
            ActivityCompat.requestPermissions(this, new String[]{

                    Manifest.permission.ACCESS_COARSE_LOCATION}, 73);
        }
        else{
            getUserLocation();
        }





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



    //method to get user location
    //Reference for GEOCODER - https://stackoverflow.com/questions/22323974/how-to-get-city-name-by-latitude-longitude-in-android
    // https://developer.android.com/reference/android/location/Geocoder

    public void getUserLocation() {

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        if (location != null) {

                            double lat = location.getLatitude();
                            double longitude = location.getLongitude();
                            Geocoder geocoder = new Geocoder(MainActivity.this.getApplicationContext(), Locale.getDefault());


                            try {
                                List<Address> addresses = geocoder.getFromLocation(lat, longitude, 1);
                                cityName = addresses.get(0).getLocality();
                                Log.i("tag",cityName);
                                // String stateName = addresses.get(0).getAdminArea();


                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

    }

}