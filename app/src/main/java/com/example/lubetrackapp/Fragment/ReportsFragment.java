package com.example.lubetrackapp.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lubetrackapp.EquipmentTypes;
import com.example.lubetrackapp.R;
import com.example.lubetrackapp.Utils.ApplicationConstants;
import com.example.lubetrackapp.Utils.BuildingResponse;
import com.example.lubetrackapp.adapter.ClientLocationsAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ReportsFragment extends Fragment {

    RecyclerView locsRecyclerView;
    ImageView backImg;
    TextView sizeText;
    ClientLocationsAdapter adapter;
    ProgressDialog dialog;
    ArrayList<BuildingResponse> locsresponse;
    TextView headingText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reports_fragment, container, false);



        initUI(view);
        initData();
        intiActions();
        return view;

    }

    private void initData() {
      // GetClientLocations();
    }

    private void intiActions() {

    }

    private void initUI(View view) {
        locsRecyclerView = (RecyclerView) view.findViewById(R.id.clocationlist);

        sizeText = view.findViewById(R.id.sizeText);
       // sizeText.setVisibility(View.GONE);

        adapter = new ClientLocationsAdapter(null);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext());
        locsRecyclerView.setLayoutManager(mLayoutManager1);
        locsRecyclerView.setItemAnimator(new DefaultItemAnimator());

        headingText = getActivity().findViewById(R.id.headingTV);
        headingText.setText("REPORTS LIST");
    }


    public void GetClientLocations() {
        getCustomLayoutDialog();
        com.example.lubetrackapp.Utils.DataPrepare.get(getContext()).getrestadapter()
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
                            adapter = new ClientLocationsAdapter(locsresponse);
                            locsRecyclerView.setAdapter(adapter);
                        }
                        else {
                            sizeText.setVisibility(View.VISIBLE);
                        }
                        adapter.setOnItemClickListener(new ClientLocationsAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, BuildingResponse obj, int position) {

                                ApplicationConstants.locid = obj.getId();

                                startActivity(new Intent(getContext(), EquipmentTypes.class));

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
