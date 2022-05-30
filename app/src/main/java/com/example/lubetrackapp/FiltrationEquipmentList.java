package com.example.lubetrackapp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lubetrackapp.Utils.ApplicationConstants;
import com.example.lubetrackapp.Utils.EquipmentMaster;
import com.example.lubetrackapp.adapter.BottomSheetAdapter;
import com.example.lubetrackapp.adapter.EquipmentListAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class FiltrationEquipmentList extends AppCompatActivity {

    RecyclerView elistRecyclerView;
    ImageView backImg;
    TextView sizeText;
    Button filter;
    EquipmentListAdapter adapter;
    ProgressDialog dialog;
    ArrayList<EquipmentMaster> eqlistresponse;
    Dialog dialog1;
    EditText SumpEditText,DurationEditText,CommentsEdit;
    TextView SumpErrorMsg,DurationErrorMsg,headerText;
    TextView oilgradeEdit,oilgradeErrorMsg;
    ArrayList<EquipmentMaster> buildingresponse;
    BottomSheetAdapter bottomSheetAdapter;
    BottomSheetDialog dialog2;
    TextView noStatusTV;
    RecyclerView statusRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eqipment_list);

        initUI();
        initData();
        intiActions();
    }

    private void initData() {
        if(ApplicationConstants.eqtypeid!=0){
            GetEquipmentList(ApplicationConstants.eqtypeid);
        }

    }

    private void intiActions() {
        backImg.setOnClickListener(view -> {
            finish();
        });
    }

    private void initUI() {
        backImg = findViewById(R.id.addAddr_back_Img);
        filter = findViewById(R.id.locfilter);
        elistRecyclerView = (RecyclerView) findViewById(R.id.equiplist);

        sizeText = findViewById(R.id.sizeText);
        sizeText.setVisibility(View.GONE);

        adapter = new EquipmentListAdapter(null);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(this);
        elistRecyclerView.setLayoutManager(mLayoutManager1);
        elistRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void GetEquipmentList(int Id) {
        getCustomLayoutDialog();
        com.example.lubetrackapp.Utils.DataPrepare.get(this).getrestadapter()
                .GetEquipments(Id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<EquipmentMaster>>() {

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
                    public void onNext(List<EquipmentMaster> responselist) {
                        //TrapResponse res = responselist.get(0);
                        dialog.dismiss();
                        if(responselist.size()>0) {
                            eqlistresponse  = (ArrayList<EquipmentMaster>) responselist;
                            adapter = new EquipmentListAdapter(eqlistresponse);
                            elistRecyclerView.setAdapter(adapter);
                        }
                        else {
                            sizeText.setVisibility(View.VISIBLE);
                        }
                        adapter.setOnItemClickListener(new EquipmentListAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, EquipmentMaster obj, int position) {

                                ApplicationConstants.eqid = obj.getId();
                                ApplicationConstants.eqcode = obj.getCode();
                                showDialog();
                               // startActivity(new Intent(EquipmentList.this,EquipmentDetails.class));

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


    public void showDialog() {

        dialog1 = new Dialog(FiltrationEquipmentList.this);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog1.setContentView(R.layout.filteration_popup);
        dialog1.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog1.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        headerText = dialog1.findViewById(R.id.headerText);
        headerText.setText(ApplicationConstants.eqcode+"("+ApplicationConstants.eqtypename+")");

         ((EditText) dialog1.findViewById(R.id.SumpEditText)).setMovementMethod(LinkMovementMethod.getInstance());
        SumpEditText =  dialog1.findViewById(R.id.SumpEditText);
         ((EditText) dialog1.findViewById(R.id.DurationEditText)).setMovementMethod(LinkMovementMethod.getInstance());
        DurationEditText =  dialog1.findViewById(R.id.DurationEditText);
        ((EditText) dialog1.findViewById(R.id.CommentsEdit)).setMovementMethod(LinkMovementMethod.getInstance());
        CommentsEdit = dialog1.findViewById(R.id.CommentsEdit);


        ((TextView) dialog1.findViewById(R.id.SumpErrorMsg)).setMovementMethod(LinkMovementMethod.getInstance());
        SumpErrorMsg = dialog1.findViewById(R.id.SumpErrorMsg);

        ((TextView) dialog1.findViewById(R.id.DurationErrorMsg)).setMovementMethod(LinkMovementMethod.getInstance());
        DurationErrorMsg = dialog1.findViewById(R.id.DurationErrorMsg);

        oilgradeEdit = dialog1.findViewById(R.id.oilgradeEdit);
        oilgradeErrorMsg = dialog1.findViewById(R.id.oilgradeErrorMsg);

        SumpErrorMsg.setVisibility(View.GONE);
        DurationErrorMsg.setVisibility(View.GONE);

        oilgradeEdit.setOnClickListener(view -> {
            showBottomDialog();
        });


        ((Button) dialog1.findViewById(R.id.no_Btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });

        ((Button) dialog1.findViewById(R.id.yes_Btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(SumpEditText.getText().toString().matches("")){
                    SumpErrorMsg.setVisibility(View.VISIBLE);
                    return;
                }
                if(DurationEditText.getText().toString().matches("")){
                    SumpErrorMsg.setVisibility(View.GONE);
                    DurationErrorMsg.setVisibility(View.VISIBLE);
                    return;
                }
                if(ApplicationConstants.oilgradeid==0){
                    DurationErrorMsg.setVisibility(View.GONE);
                    oilgradeErrorMsg.setVisibility(View.VISIBLE);
                }
                else{
                    oilgradeErrorMsg.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"clicked save",Toast.LENGTH_SHORT).show();
                }
            }
        });



        dialog1.show();
        dialog1.getWindow().setAttributes(lp);
    }

    public void showBottomDialog() {
        View view1 = getLayoutInflater().inflate(R.layout.bottom_dialog_layout, null);
        dialog2 = new BottomSheetDialog(this);
        dialog2.setContentView(view1);

        noStatusTV = (TextView) dialog2.findViewById(R.id.noStatusTV);
        statusRV = (RecyclerView) dialog2.findViewById(R.id.statusRV);

        noStatusTV.setVisibility(View.GONE);

        GetLubegradesList(2);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        statusRV.setLayoutManager(mLayoutManager); // 1 column
        statusRV.setItemAnimator(new DefaultItemAnimator());

        ((LinearLayout) dialog2.findViewById(R.id.cancelLL)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });

        dialog2.show();

    }

    public void GetLubegradesList(int Id) {
        getCustomLayoutDialog();
        com.example.lubetrackapp.Utils.DataPrepare.get(this).getrestadapter()
                .GetTypesByGroup(Id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<EquipmentMaster>>() {

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
                    public void onNext(List<EquipmentMaster> responselist) {
                        dialog.dismiss();
                        dialog2.show();

                        buildingresponse  = (ArrayList<EquipmentMaster>) responselist;
                        bottomSheetAdapter = new BottomSheetAdapter(buildingresponse);
                        statusRV.setAdapter(bottomSheetAdapter);

                        bottomSheetAdapter.setOnItemClickListener(new BottomSheetAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, EquipmentMaster obj, int position) {

                                dialog2.dismiss();
                                ApplicationConstants.oilgradeid = obj.getId();
                                oilgradeEdit.setText(obj.getName());
                            }
                        });
                    }
                });
    }



}
