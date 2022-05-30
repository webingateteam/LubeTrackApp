package com.example.lubetrackapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class loadingpage extends AppCompatActivity {

    Toast toast;

    private static final int PERMISSIONS_ALL = 4;
    String[] PERMISSIONS = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.INTERNET};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingpage);


        CheckServerTask checkServerTask = new CheckServerTask();
        checkServerTask.execute();
//        checkPermissions();

        //rotate_image = (ImageView) findViewById(R.id.splashImageView);

  /*      RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,  Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(2500);
        rotate_image.startAnimation(rotate);*/

     /*   Animation aniRotateClk = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        rotate_image.startAnimation(aniRotateClk);*/

        Thread timer = new Thread() {
            public void run() {
                try {
                    //Display for 3 seconds
                    sleep(1600);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {

                    //                  startActivity(new Intent(getApplicationContext(), SplashScreenDummyActivity.class));

                    //  SharedPreferences sharedPref = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
                    //  SharedPreferences.Editor editor = sharedPref.edit();
                    //   editor.putString(CountryCurrency, "₹");
                    //   editor.putString(CountryCurrencyCode, "INR");
                    //  editor.putInt(CountryId, 101);
                    //    editor.commit();

                    /*SharedPreferences sharedPref1 = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
                    String isSellerOrBuyer = sharedPref1.getString(isSeller, "0");

                    if(isSellerOrBuyer.equals("1")) {
                        startActivity(new Intent(getApplicationContext(), SellerDashboardActivity.class));
                    } else {
                        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                    }*/

                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                    finish();

                }
            }
        };
        timer.start();

        //       location();

    }

    public void DisplayToast(String text) {
        if (toast != null) {
            toast.cancel();
            toast = null;

        }
        toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();

    }

    private void checkPermissions() {
        if (hasPermissions(this, PERMISSIONS).size() > 0) {
            //ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
            ActivityCompat.requestPermissions(this, hasPermissions(this, PERMISSIONS).toArray(new String[0]), PERMISSIONS_ALL);

        } else if (hasPermissions(this, PERMISSIONS).size() == 0) {
            // DisplaySplashscreen();
        }
//        if (Build.VERSION.SDK_INT >= 23) {
//            if (ContextCompat.checkSelfPermission(login_activity.this,
//                    Manifest.permission.SYSTEM_ALERT_WINDOW)
//                    != PackageManager.PERMISSION_GRANTED)
//                checkDrawOverlayPermission();
//        }
    }

    public static ArrayList<String> hasPermissions(Context context, String... permissions) {

        ArrayList<String> perms = new ArrayList<>();
        //if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
        if (Build.VERSION.SDK_INT >= 23 && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    perms.add(permission);

                }
            }
        }

        return perms;
    }

    class CheckServerTask extends AsyncTask<String, Void, String[]> {
        ProgressDialog dialog = new ProgressDialog(loadingpage.this);

        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setMessage("Please Wait...");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();

        }

        @Override
        protected String[] doInBackground(String... strings) {

            return new String[0];
        }

        @Override
        protected void onPostExecute(String... result) {
            dialog.dismiss();
           /* SharedPreferences sharedPref = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
            ApplicationConstants.customerMobileNumber = sharedPref.getString(CustomerMobileNumber,null);*/
        }
    }


}