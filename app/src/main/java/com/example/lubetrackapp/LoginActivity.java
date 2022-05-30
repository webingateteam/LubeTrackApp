package com.example.lubetrackapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Toast toast;

    private static final int PERMISSIONS_ALL = 4;
    String[] PERMISSIONS = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.INTERNET};

    EditText signInMobileEmailET,signInPasswordET;
    TextView signInMobileEmailErrorTV,signInPasswordErrorTV,ForgotPwd;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        initUI();
        initActions();
        getWindow().setSoftInputMode(
        WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }

    private void initActions() {
        submit.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this,Dashboard.class));
            finish();
        });
        ForgotPwd.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this,ForgotPwdActivity.class));
        });
    }

    private void initUI() {
        signInMobileEmailET = findViewById(R.id.signInMobileEmailET);
        signInPasswordET = findViewById(R.id.signInPasswordET);
        signInMobileEmailErrorTV =findViewById(R.id.signInMobileEmailErrorTV);
        signInPasswordErrorTV = findViewById(R.id.signInPasswordErrorTV);
        submit = findViewById(R.id.loginContinueBtn);
        ForgotPwd = findViewById(R.id.ForgotPwdTV);
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
        ProgressDialog dialog = new ProgressDialog(LoginActivity.this);

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
