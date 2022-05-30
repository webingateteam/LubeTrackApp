package com.example.lubetrackapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lubetrackapp.Utils.ApplicationConstants;
import com.example.lubetrackapp.Utils.UserResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ProfileDetails extends AppCompatActivity {

    EditText emailTextView,phoneTextView,UsernameTextView,FirstnameTextView;
    TextView EmailErrorMsg,PhoneErrorMsg,UsernameErrorMsg,FirstnameErrorMsg;
    Button submit;
    ProgressDialog dialog;
    ArrayList<UserResponse> userlistresponse;
    int ctryId,stateId,cityId;
    String CAddress;
    ImageView backImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_details);

        initUI();
        initData();
        intiActions();
    }

    private void intiActions() {
        backImg.setOnClickListener(view -> {
            finish();
        });

        submit.setOnClickListener(view -> {
            if(emailTextView.getText().toString().matches("")){
                EmailErrorMsg.setVisibility(View.VISIBLE);
                return;
            }
            if(phoneTextView.getText().toString().matches("")){
                EmailErrorMsg.setVisibility(View.GONE);
                PhoneErrorMsg.setVisibility(View.VISIBLE);
                return;
            }
            if(UsernameTextView.getText().toString().matches("")){
                PhoneErrorMsg.setVisibility(View.GONE);
                UsernameErrorMsg.setVisibility(View.VISIBLE);
                return;
            }
            if(FirstnameTextView.getText().toString().matches("")){
                UsernameErrorMsg.setVisibility(View.GONE);
                FirstnameErrorMsg.setVisibility(View.VISIBLE);
                return;
            }
            else{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
                String date = sdf.format(new Date());

                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("Id", ApplicationConstants.clientid);
                jsonObject.addProperty("flag","U");
                jsonObject.addProperty("ClientName",UsernameTextView.getText().toString());
                jsonObject.addProperty("Email",emailTextView.getText().toString());
                jsonObject.addProperty("MobileNo",phoneTextView.getText().toString());
                jsonObject.addProperty("Address",FirstnameTextView.getText().toString());
                jsonObject.addProperty("Active",1);
                jsonObject.addProperty("countryId",ctryId);
                jsonObject.addProperty("stateid",stateId);
                jsonObject.addProperty("cityid",cityId);
                jsonObject.addProperty("zipcode","");
                jsonObject.addProperty("clientlogo","");
                jsonObject.addProperty("CreatedOn",date);
                //SaveProfile(jsonObject);

            }
        });
    }

    private void initData() {
    }

    private void initUI() {
        backImg = findViewById(R.id.addAddr_back_Img);
        emailTextView = findViewById(R.id.emailTextView);
        phoneTextView = findViewById(R.id.phoneTextView);
        UsernameTextView = findViewById(R.id.UsernameTextView);
        FirstnameTextView = findViewById(R.id.FirstnameTextView);
        EmailErrorMsg = findViewById(R.id.EmailErrorMsg);
        PhoneErrorMsg = findViewById(R.id.PhoneErrorMsg);
        UsernameErrorMsg = findViewById(R.id.UsernameErrorMsg);
        FirstnameErrorMsg = findViewById(R.id.FirstnameErrorMsg);
        submit = findViewById(R.id.submit);
        EmailErrorMsg.setVisibility(View.GONE);
        PhoneErrorMsg.setVisibility(View.GONE);
        UsernameErrorMsg.setVisibility(View.GONE);
        FirstnameErrorMsg.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
