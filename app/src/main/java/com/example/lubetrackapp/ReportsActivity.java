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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lubetrackapp.Utils.ApplicationConstants;
import com.example.lubetrackapp.Utils.BuildingResponse;
import com.example.lubetrackapp.adapter.ClientLocationsAdapter;
import com.example.lubetrackapp.adapter.ReportsAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ReportsActivity extends AppCompatActivity {
    RecyclerView locsRecyclerView;
    ImageView backImg;
    TextView sizeText;
    ReportsAdapter adapter;
    ProgressDialog dialog;
    ArrayList<BuildingResponse> locsresponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reports_activity);

        initUI();
        initData();
        intiActions();
    }

    private void initData() {
       // GetClientLocations();
    }

    private void intiActions() {
        backImg.setOnClickListener(view -> {
            finish();
        });
    }

    private void initUI() {
        backImg = findViewById(R.id.addAddr_back_Img);
        locsRecyclerView = (RecyclerView) findViewById(R.id.clocationlist);

        sizeText = findViewById(R.id.sizeText);
       // sizeText.setVisibility(View.GONE);

        adapter = new ReportsAdapter(null);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(this);
        locsRecyclerView.setLayoutManager(mLayoutManager1);
        locsRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void GetClientLocations() {
        getCustomLayoutDialog();
        com.example.lubetrackapp.Utils.DataPrepare.get(this).getrestadapter()
                .GetCustomerLocations()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<BuildingResponse>>() {

                    @Override
                    public void onCompleted() {
                        dialog.dismiss();
                        //Log.d("Success","Successfull");
                        //StopDialogue();
                    }

                    @Override
                    public void onError(Throwable e) {
                        try {
                            dialog.dismiss();
                            Log.d("OnError ", e.getMessage());
                            //DisplayToast("Error");
                            //StopDialogue();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                    @Override
                    public void onNext(List<BuildingResponse> responselist) {
                        //TrapResponse res = responselist.get(0);
                        dialog.dismiss();
                        if(responselist.size()>0) {
                            locsresponse  = (ArrayList<BuildingResponse>) responselist;
                            adapter = new ReportsAdapter(locsresponse);
                            locsRecyclerView.setAdapter(adapter);
                        }
                        else {
                            sizeText.setVisibility(View.VISIBLE);
                        }
                        adapter.setOnItemClickListener(new ReportsAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, BuildingResponse obj, int position) {

                                ApplicationConstants.locid = obj.getId();

                                startActivity(new Intent(ReportsActivity.this,EquipmentTypes.class));

                            }
                        });

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
