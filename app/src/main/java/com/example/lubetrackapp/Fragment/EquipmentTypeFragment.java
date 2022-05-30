package com.example.lubetrackapp.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lubetrackapp.FiltrationEquipmentList;
import com.example.lubetrackapp.GreasingEquipmentList;
import com.example.lubetrackapp.OilEquipmentList;
import com.example.lubetrackapp.R;
import com.example.lubetrackapp.Utils.ApplicationConstants;
import com.example.lubetrackapp.Utils.EquipmentMaster;
import com.example.lubetrackapp.adapter.EquipmentTypesAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class EquipmentTypeFragment extends Fragment {

    EquipmentTypesAdapter adapter;
    ProgressDialog dialog;
    ArrayList<EquipmentMaster> eqresponse;
    RecyclerView eqtypes;
    int noOfProductColumn = 4;
    TextView sizeText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.equipment_type_fragment, container, false);

        initUI(view);
        initData();
        initActions();
        return view;
    }

    private void initActions() {

    }

    private void initUI(View view) {

        sizeText = view.findViewById(R.id.sizeText);
        sizeText.setVisibility(View.GONE);
        adapter = new EquipmentTypesAdapter(null);
        if (getActivity() != null) {
            eqtypes = view.findViewById(R.id.rvProducts1);
            GridLayoutManager gd= new GridLayoutManager(getActivity().getApplicationContext(), noOfProductColumn);
            eqtypes.setLayoutManager(gd);
            eqtypes.setItemAnimator(new DefaultItemAnimator());
            eqtypes.setAdapter(adapter);
        }
    }

    private void initData() {
        GetEquipmentTypes(1);
    }

    public void GetEquipmentTypes(int Id) {
        getCustomLayoutDialog();
        com.example.lubetrackapp.Utils.DataPrepare.get(getContext()).getrestadapter()
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
                        //TrapResponse res = responselist.get(0);
                        dialog.dismiss();
                        if(responselist.size()>0) {
                            eqresponse  = (ArrayList<EquipmentMaster>) responselist;
                            adapter = new EquipmentTypesAdapter(eqresponse);
                            eqtypes.setAdapter(adapter);
                        }
                        else {
                            sizeText.setVisibility(View.VISIBLE);
                        }
                        adapter.setOnItemClickListener(new EquipmentTypesAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, EquipmentMaster obj, int position) {

                                ApplicationConstants.eqtypeid = obj.getId();
                                ApplicationConstants.eqtypename = obj.getName();

                                if(ApplicationConstants.eqtypeid==1){
                                    startActivity(new Intent(getContext(), GreasingEquipmentList.class));
                                }
                                else if(ApplicationConstants.eqtypeid==2){
                                    startActivity(new Intent(getContext(), OilEquipmentList.class));
                                }
                                else if(ApplicationConstants.eqtypeid==3){
                                    startActivity(new Intent(getContext(), FiltrationEquipmentList.class));
                                }
                                else{
                                    startActivity(new Intent(getContext(), OilEquipmentList.class));
                                }
                            }
                        });

                    }
                });
    }

    private void getCustomLayoutDialog() {
        dialog = new ProgressDialog(getContext(),R.style.MyAlertDialogStyle);
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
