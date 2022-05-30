package com.example.lubetrackapp;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class EquipmentDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment_details);

        initUI();
        initData();
        intiActions();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    private void intiActions() {
//        backImg.setOnClickListener(view -> {
//            finish();
//        });
    }

    private void initData() {
    }

    private void initUI() {

    }

}
