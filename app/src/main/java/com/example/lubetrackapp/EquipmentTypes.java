package com.example.lubetrackapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lubetrackapp.Fragment.DashboardFragment;
import com.example.lubetrackapp.Fragment.EquipmentTypeFragment;
import com.example.lubetrackapp.Utils.ApplicationConstants;
import com.example.lubetrackapp.Utils.BuildingResponse;
import com.example.lubetrackapp.Utils.EquipmentMaster;
import com.example.lubetrackapp.adapter.ClientLocationsAdapter;
import com.example.lubetrackapp.adapter.EquipmentTypesAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class EquipmentTypes extends AppCompatActivity {

    ImageView backImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eqipment_types);

        initUI();
        initData();
        intiActions();
    }

    private void initData() {

    }

    private void intiActions() {
        backImg.setOnClickListener(view -> {
            finish();
        });
    }

    private void initUI() {
        backImg = findViewById(R.id.addAddr_back_Img);

        loadFragment(new EquipmentTypeFragment());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void loadFragment(Fragment fragment) {
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.home9Frame, fragment)
                .commitAllowingStateLoss();
    }


}
