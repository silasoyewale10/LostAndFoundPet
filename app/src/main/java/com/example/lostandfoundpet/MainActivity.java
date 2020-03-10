package com.example.lostandfoundpet;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ThHollie";
    private AWSAppSyncClient mAWSAppSyncClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        View logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = AWSMobileClient.getInstance().getUsername();
                AWSMobileClient.getInstance().signOut();

                AWSMobileClient.getInstance().initialize(MainActivity.this.getApplicationContext(), new Callback<UserStateDetails>() {

                            @Override
                            public void onResult(UserStateDetails userStateDetails) {
                                Log.i("INIT", "onResult: " + userStateDetails.getUserState());
                                if (userStateDetails.getUserState().equals(UserState.SIGNED_OUT)) {
                                    AWSMobileClient.getInstance().showSignIn(MainActivity.this, new Callback<UserStateDetails>() {

                                        @Override
                                        public void onResult(UserStateDetails result) {
                                            Log.d(TAG, "onResult: " + result.getUserState());

                                        }

                                        @Override
                                        public void onError(Exception e) {
                                            Log.e(TAG, "onError: ", e);
                                        }
                                    });
                                }
                            }

                            @Override
                            public void onError(Exception e) {
                                Log.e("INIT", "Initialization error.", e);
                            }
                        }
                );

            }
        });

        //TODO Put this code into a method
        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {

                    @Override
                    public void onResult(UserStateDetails userStateDetails) {
                        Log.i("INIT", "onResult: " + userStateDetails.getUserState());
                        if (userStateDetails.getUserState().equals(UserState.SIGNED_OUT)) {
                            AWSMobileClient.getInstance().showSignIn(MainActivity.this, new Callback<UserStateDetails>() {

                                @Override
                                public void onResult(UserStateDetails result) {
                                    Log.d(TAG, "onResult: " + result.getUserState());

                                }

                                @Override
                                public void onError(Exception e) {
                                    Log.e(TAG, "onError: ", e);
                                }
                            });
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.e("INIT", "Initialization error.", e);
                    }
                }
        );

        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {
            @Override
            public void onResult(UserStateDetails userStateDetails) {
                try {
                    Amplify.addPlugin(new AWSS3StoragePlugin());
                    Amplify.configure(getApplicationContext());
                    Log.i("StorageQuickstart", "All set and ready to go!");
                } catch (Exception e) {
                    Log.e("StorageQuickstart", e.getMessage());
                }
            }


            @Override
            public void onError(Exception e) {
                Log.e("StorageQuickstart", "Initialization error.", e);
            }
        });


                    @Override
                    public void onResult(UserStateDetails userStateDetails){
            Log.i("INIT", "onResult: " + userStateDetails.getUserState());
            if (userStateDetails.getUserState().equals(UserState.SIGNED_OUT)) {
                // 'this' refers the the current active activity
                AWSMobileClient.getInstance().showSignIn(MainActivity.this, new Callback<UserStateDetails>() {
                            @Override
                            public void onResult(UserStateDetails result) {
                                Log.d(TAG, "onResult: " + result.getUserState());
                                if (result.getUserState().equals(UserState.SIGNED_IN)) {
                                    uploadWithTransferUtility();
                                }
                            }


                            @Override
                            public void onError(Exception e) {
                                Log.e("INIT", "Initialization error.", e);
                            }

                        }
                );


            }
        }
    }
}








