package com.example.lubetrackapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.lubetrackapp.Utils.ApplicationConstants;
import com.example.lubetrackapp.Utils.UserResponse;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ForgotPwdActivity extends AppCompatActivity {

    Button submit,submitBtn1,submitBtn2;
    TextView MBText,ErrorMsg,OtpErrorMsgTV,PasswordErrorMsgTV;
    EditText MBEditText,OTPEditText,PasswordEditText;
    ProgressDialog dialog;
    //Spinner spinnerText;
    //ArrayAdapter types;
   // List<String> spinnertypes = new ArrayList<String>();
   // int rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        initUI();
        initActions();
    }

    private void initActions() {
        submit.setOnClickListener(view -> {
            if(MBEditText.getText().toString().matches("")){
                ErrorMsg.setVisibility(View.VISIBLE);
                return;
            }
            else{
                    ErrorMsg.setVisibility(View.GONE);
                    ApplicationConstants.mobileno = MBEditText.getText().toString();
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("flag","S");
                    jsonObject.addProperty("Mobileno",MBEditText.getText().toString());
                    GetForgotPwd(jsonObject);
//                if(ApplicationConstants.logintype==0){
//                    ErrorMsg.setVisibility(View.GONE);
//                    JsonObject jsonObject = new JsonObject();
//                    jsonObject.addProperty("flag","C");
//                    jsonObject.addProperty("Mobileno",MBEditText.getText().toString());
//                    GetForgotPwd(jsonObject);
//                }
//                else{
//                    ErrorMsg.setVisibility(View.GONE);
//                    ApplicationConstants.mobileno = MBEditText.getText().toString();
//                    JsonObject jsonObject = new JsonObject();
//                    jsonObject.addProperty("flag","S");
//                    jsonObject.addProperty("Mobileno",MBEditText.getText().toString());
//                    GetForgotPwd(jsonObject);
//                }

            }

        });

        submitBtn1.setOnClickListener(view -> {
            if(OTPEditText.getText().toString().matches("")){
                OtpErrorMsgTV.setVisibility(View.VISIBLE);
                return;
            }
            else{
                if(ApplicationConstants.logintype==0){
                    OtpErrorMsgTV.setVisibility(View.GONE);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("flag","C");
                    jsonObject.addProperty("Mobileno",ApplicationConstants.mobileno);
                    jsonObject.addProperty("mobileotp",OTPEditText.getText().toString());
                    OTPVerification(jsonObject);
                }
                else{
                    OtpErrorMsgTV.setVisibility(View.GONE);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("flag","S");
                    jsonObject.addProperty("Mobileno",ApplicationConstants.mobileno);
                    jsonObject.addProperty("mobileotp",OTPEditText.getText().toString());
                    OTPVerification(jsonObject);
                }
            }
        });

        submitBtn2.setOnClickListener(view -> {
            if(PasswordEditText.getText().toString().matches("")){
                PasswordErrorMsgTV.setVisibility(View.VISIBLE);
                return;
            }
            else{
                if(ApplicationConstants.logintype==0){
                    PasswordErrorMsgTV.setVisibility(View.GONE);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("flag","C");
                    jsonObject.addProperty("Mobileno",ApplicationConstants.mobileno);
                    jsonObject.addProperty("NewPassword",PasswordEditText.getText().toString());
                    UpdatePassword(jsonObject);
                }
                else{
                    PasswordErrorMsgTV.setVisibility(View.GONE);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("flag","S");
                    jsonObject.addProperty("Mobileno",ApplicationConstants.mobileno);
                    jsonObject.addProperty("NewPassword",PasswordEditText.getText().toString());
                    UpdatePassword(jsonObject);
                }
            }
        });


    }

    private void initUI() {
        MBText = findViewById(R.id.MBText);
        MBEditText = findViewById(R.id.MBEditText);
        OTPEditText = findViewById(R.id.OTPEditText);
        PasswordEditText = findViewById(R.id.PasswordEditText);
        ErrorMsg = findViewById(R.id.ErrorMsgTV);
        OtpErrorMsgTV = findViewById(R.id.OtpErrorMsgTV);
        PasswordErrorMsgTV = findViewById(R.id.PasswordErrorMsgTV);
        ErrorMsg.setVisibility(View.GONE);
        OtpErrorMsgTV.setVisibility(View.GONE);
        PasswordErrorMsgTV.setVisibility(View.GONE);
        submit = findViewById(R.id.submitBtn);
        submitBtn1 = findViewById(R.id.submitBtn1);
        submitBtn2 = findViewById(R.id.submitBtn2);
        submitBtn1.setVisibility(View.GONE);
        submitBtn2.setVisibility(View.GONE);
//        logintype = findViewById(R.id.logintype);
//        spinnerText = findViewById(R.id.spinnerText);
//        spinnerErrorText = findViewById(R.id.spinnerErrorText);
//        spinnerErrorText.setVisibility(View.GONE);
//        spinnerText.setOnItemSelectedListener(this);

//        spinnertypes.add("UKS Staff");
//        spinnertypes.add("UKS Customer");
//
//        types = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, spinnertypes);
//        types.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerText.setAdapter(types);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

    public void GetForgotPwd(JsonObject jsonObject) {
        getCustomLayoutDialog();
        com.example.lubetrackapp.Utils.DataPrepare.get(com.example.lubetrackapp.ForgotPwdActivity.this).getrestadapter()
                .GetForgotPassword(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<UserResponse>>() {

                    @Override
                    public void onCompleted() {
                        dialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        try {
                            dialog.dismiss();
                            Log.d("OnError ", e.getMessage());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    @Override
                    public void onNext(List<UserResponse> responselist) {
                        UserResponse  res = responselist.get(0);
                        dialog.dismiss();
                        MBText.setText("Please Enter OTP sent to Mobile Number");
                        MBEditText.setVisibility(View.GONE);
                        ErrorMsg.setVisibility(View.GONE);
                        submit.setVisibility(View.GONE);
                        OTPEditText.setVisibility(View.VISIBLE);
                        submitBtn1.setVisibility(View.VISIBLE);
                    }
                });
    }

    public void OTPVerification(JsonObject jsonObject) {
        getCustomLayoutDialog();
        com.example.lubetrackapp.Utils.DataPrepare.get(com.example.lubetrackapp.ForgotPwdActivity.this).getrestadapter()
                .OTPVerification(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<UserResponse>>() {

                    @Override
                    public void onCompleted() {
                        dialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        try {
                            dialog.dismiss();
                            Log.d("OnError ", e.getMessage());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    @Override
                    public void onNext(List<UserResponse> responselist) {
                        UserResponse  res = responselist.get(0);
                        dialog.dismiss();
                        MBText.setText("Please Enter New Password");
                        MBEditText.setVisibility(View.GONE);
                        OTPEditText.setVisibility(View.GONE);
                        submit.setVisibility(View.GONE);
                        submitBtn1.setVisibility(View.GONE);
                        submitBtn2.setVisibility(View.VISIBLE);
                        PasswordEditText.setVisibility(View.VISIBLE);
                    }
                });
    }

    public void UpdatePassword(JsonObject jsonObject) {
        getCustomLayoutDialog();
        com.example.lubetrackapp.Utils.DataPrepare.get(this).getrestadapter()
                .UpdatePassword(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<UserResponse>>() {

                    @Override
                    public void onCompleted() {
                        dialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        try {
                            dialog.dismiss();
                            Log.d("OnError ", e.getMessage());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    @Override
                    public void onNext(List<UserResponse> responselist) {
                        UserResponse  res = responselist.get(0);
                        dialog.dismiss();
                        //startActivity(new Intent(ForgotPwdActivity.this,LoginActivity.class));
                        finish();
                    }
                });
    }

    private void getCustomLayoutDialog() {
        dialog = new ProgressDialog(this,R.style.MyAlertDialogStyle);
        dialog.setMessage("Please Wait...");
        dialog.setCanceledOnTouchOutside(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        if (dialog.getWindow() != null) {

            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.show();
            dialog.getWindow().setAttributes(lp);
        }
    }


}
