//package com.example.lostandfoundpet;
//
//import android.Manifest;
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.location.Address;
//import android.location.Geocoder;
//import android.location.Location;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//
//
//import com.amazonaws.mobile.client.AWSMobileClient;
//import com.amazonaws.mobile.client.Callback;
//import com.amazonaws.mobile.client.UserState;
//import com.amazonaws.mobile.client.UserStateDetails;
//
//import com.amazonaws.mobile.config.AWSConfiguration;
//import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
//import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
//import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
//import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
//import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
//import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amplifyframework.core.Amplify;
//import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
////import com.google.android.gms.location.FusedLocationProviderClient;
////import com.google.android.gms.location.LocationServices;
////import com.google.android.gms.tasks.OnSuccessListener;
////import com.google.android.gms.location.FusedLocationProviderClient;
////import com.google.android.gms.location.LocationServices;
////import com.google.android.gms.tasks.OnSuccessListener;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.List;
//import java.util.Locale;
//
//public class MainActivity extends AppCompatActivity {
////    private AWSAppSyncClient awsAppSyncClient;
////    static String callTheTag = "silas";
////    private FusedLocationProviderClient fusedLocationClient;
//    String cityName = " ";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
////        getApplicationContext().startService(new Intent(getApplicationContext(), TransferService.class));
//
////        awsAppSyncClient = AWSAppSyncClient.builder()
////                .context(getApplicationContext())
////                .awsConfiguration(new AWSConfiguration(getApplicationContext()))
////                .build();
//
//        //location permission below
////        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
//
//        boolean permissionToAccessCoarseLocation = ActivityCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_COARSE_LOCATION)
//
//                == PackageManager.PERMISSION_GRANTED;
//        if (!permissionToAccessCoarseLocation) {
//            ActivityCompat.requestPermissions(this, new String[]{
//
//                    Manifest.permission.ACCESS_COARSE_LOCATION}, 73);
//        } else {
////            getUserLocation();
//        }
//
//
//        // Sends User To Lost Page
//        Button sendToLostPage = findViewById(R.id.lostbutton);
//        sendToLostPage.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                Intent sentToLostIntent = new Intent(MainActivity.this, LostPet.class);
//
//                MainActivity.this.startActivity(sentToLostIntent);
//
//            }
//        });
//
//
//        // Sends User To Found Page
//        Button sendtoFoundPage = findViewById(R.id.foundbutton);
//        sendtoFoundPage.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                Intent sentToFoundIntent = new Intent(MainActivity.this, FoundPet.class);
//
//                MainActivity.this.startActivity(sentToFoundIntent);
//
//            }
//        });
//
//
//        //method to get user location
//        //Reference for GEOCODER - https://stackoverflow.com/questions/22323974/how-to-get-city-name-by-latitude-longitude-in-android
//        // https://developer.android.com/reference/android/location/Geocoder
//
////    public void getUserLocation() {
////
//////        fusedLocationClient.getLastLocation()
//////                .addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
////                    @Override
////                    public void onSuccess(Location location) {
////
////                        if (location != null) {
////
////                            double lat = location.getLatitude();
////                            double longitude = location.getLongitude();
////                            Geocoder geocoder = new Geocoder(MainActivity.this.getApplicationContext(), Locale.getDefault());
////
////
////                            try {
////                                List<Address> addresses = geocoder.getFromLocation(lat, longitude, 1);
////                                cityName = addresses.get(0).getLocality();
////                                Log.i("tag",cityName);
////                                // String stateName = addresses.get(0).getAdminArea();
////
////
////                            } catch (IOException e) {
////                                e.printStackTrace();
////                            }
////                        }
////                    }
////                });
////
////    }
//
//
//
//
//
//
//
//
////        getApplicationContext().startService(new Intent(getApplicationContext(), TransferService.class));
////
////
////        //uncomment right away
////
////        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {
////
////                    @Override
////                    public void onResult(final UserStateDetails userStateDetails) {
////                        Log.i("INIT", "onResult: " + userStateDetails.getUserState());
////                        if(userStateDetails.getUserState().equals(UserState.SIGNED_OUT)){
////                            AWSMobileClient.getInstance().showSignIn(MainActivity.this, new Callback<UserStateDetails>() {
////                                @Override
////                                public void onResult(UserStateDetails result) {
////                                    Log.d(callTheTag, "onResult: " + result.getUserState());
////                                    if(result.getUserState().equals(UserState.SIGNED_IN)){
////                                        uploadWithTransferUtility();
////
////                                    }
////                                }
////
////                                @Override
////                                public void onError(Exception e) {
////                                    Log.e(callTheTag, "onError: ", e);
////                                }
////                            });
////
////                        }
////                    }
////                    @Override
////                    public void onError(Exception e) {
////                        Log.e("INIT", "Initialization error.", e);
////                    }
////                }
////        );
//
//
//        //uncomment right away
//
////        Button logout = findViewById(R.id.logout);
////        logout.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                AWSMobileClient.getInstance().signOut();
////                AWSMobileClient.getInstance().showSignIn(MainActivity.this, new Callback<UserStateDetails>() {
////                    @Override
////                    public void onResult(UserStateDetails result) {
////                        Log.d(callTheTag, "onResult: " + result.getUserState());
////                        if(result.getUserState().equals(UserState.SIGNED_IN)){
////                            uploadWithTransferUtility();
////
////                        }
////                        @SuppressLint("WrongViewCast") EditText username2 = findViewById(R.id.username);
////                        String username = username2.getText().toString();
////                    }
////
////                    @Override
////                    public void onError(Exception e) {
////                        Log.e(callTheTag, "onError: ", e);
////                    }
////                });
////
////            }
////        });
////
////        TextView username2 = findViewById(R.id.username);
////        username2.setText(AWSMobileClient.getInstance().getUsername());
//    }
//
////    public void uploadWithTransferUtility() {
////
////        TransferUtility transferUtility =
////                TransferUtility.builder()
////                        .context(getApplicationContext())
////                        .awsConfiguration(AWSMobileClient.getInstance().getConfiguration())
////                        .s3Client(new AmazonS3Client(AWSMobileClient.getInstance()))
////                        .build();
////
////        File file = new File(getApplicationContext().getFilesDir(), "sample.txt");
////        try {
////            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
////            writer.append("Howdy World!");
////            writer.close();
////        }
////        catch(Exception e) {
////            Log.e(callTheTag, e.getMessage());
////        }
////
////        TransferObserver uploadObserver =
////                transferUtility.upload(
////                        "public/sample.txt",
////                        new File(getApplicationContext().getFilesDir(),"sample.txt"));
////
////        // Attach a listener to the observer to get state update and progress notifications
////        uploadObserver.setTransferListener(new TransferListener() {
////
////            @Override
////            public void onStateChanged(int id, TransferState state) {
////                if (TransferState.COMPLETED == state) {
////                    // Handle a completed upload.
////                }
////            }
////
////            @Override
////            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
////                float percentDonef = ((float) bytesCurrent / (float) bytesTotal) * 100;
////                int percentDone = (int)percentDonef;
////
////                Log.d(callTheTag, "ID:" + id + " bytesCurrent: " + bytesCurrent
////                        + " bytesTotal: " + bytesTotal + " " + percentDone + "%");
////            }
////
////            @Override
////            public void onError(int id, Exception ex) {
////                // Handle errors
////            }
////
////        });
////        if (TransferState.COMPLETED == uploadObserver.getState()) {
////            // Handle a completed upload.
////        }
////
////        Log.d(callTheTag, "Bytes Transferred: " + uploadObserver.getBytesTransferred());
////        Log.d(callTheTag, "Bytes Total: " + uploadObserver.getBytesTotal());
////    }
//
//
//
//
//
//
//}
//
//
//
//
//
//
//
//
//
//

















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
//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.location.LocationServices;
//import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

//    private FusedLocationProviderClient fusedLocationClient;
    String cityName = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //location permission below
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        boolean permissionToAccessCoarseLocation = ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION)

                == PackageManager.PERMISSION_GRANTED;
        if(!permissionToAccessCoarseLocation){
            ActivityCompat.requestPermissions(this, new String[]{

                    Manifest.permission.ACCESS_COARSE_LOCATION}, 73);
        }
        else{
//            getUserLocation();
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

//    public void getUserLocation() {
//
//        fusedLocationClient.getLastLocation()
//                .addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location location) {
//
//                        if (location != null) {
//
//                            double lat = location.getLatitude();
//                            double longitude = location.getLongitude();
//                            Geocoder geocoder = new Geocoder(MainActivity.this.getApplicationContext(), Locale.getDefault());
//
//
//                            try {
//                                List<Address> addresses = geocoder.getFromLocation(lat, longitude, 1);
//                                cityName = addresses.get(0).getLocality();
//                                Log.i("tag",cityName);
//                                // String stateName = addresses.get(0).getAdminArea();
//
//
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                });
//
//    }

}