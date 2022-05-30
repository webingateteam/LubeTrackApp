package com.example.lubetrackapp.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lubetrackapp.LoginActivity;
import com.example.lubetrackapp.ProfileDetails;
import com.example.lubetrackapp.R;
import com.example.lubetrackapp.Utils.ApplicationConstants;
import com.example.lubetrackapp.Utils.UserResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ProfileFragment extends Fragment {

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String ClientId = "clientidKey";
    public static final String UserName = "usernameKey";

    EditText emailTextView,phoneTextView,UsernameTextView,FirstnameTextView;
    TextView EmailErrorMsg,PhoneErrorMsg,UsernameErrorMsg,FirstnameErrorMsg;
    Button logout,edit;
    FloatingActionButton editFAB;
    ProgressDialog dialog;
    ArrayList<UserResponse> userlistresponse;
    int ctryId,stateId,cityId;
    String CAddress;
    TextView headingText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);



        InitUI(view);
        InitData();
        InitActions();
        return view;

    }

    private void InitActions() {
        logout.setOnClickListener(view -> {
            SharedPreferences sharedPref = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.clear();
            editor.apply();
            editor.commit();
            ApplicationConstants.clientid=0;
            ApplicationConstants.username = null;
            ApplicationConstants.firstname = null;
            ApplicationConstants.lastname = null;
            ApplicationConstants.emailid = null;
            ApplicationConstants.mobileno = null;
            ApplicationConstants.address = null;
            startActivity(new Intent(getContext(), LoginActivity.class));
            getActivity().finish();
        });

        edit.setOnClickListener(view -> {
          startActivity(new Intent(getContext(), ProfileDetails.class));
        });


    }

    private void InitData() {

        //GetDetails(ApplicationConstants.clientid);
    }

    private void InitUI(View view) {
        emailTextView = view.findViewById(R.id.emailTextView);
        phoneTextView = view.findViewById(R.id.phoneTextView);
        UsernameTextView = view.findViewById(R.id.UsernameTextView);
        FirstnameTextView = view.findViewById(R.id.FirstnameTextView);
        EmailErrorMsg = view.findViewById(R.id.EmailErrorMsg);
        PhoneErrorMsg = view.findViewById(R.id.PhoneErrorMsg);
        UsernameErrorMsg = view.findViewById(R.id.UsernameErrorMsg);
        FirstnameErrorMsg = view.findViewById(R.id.FirstnameErrorMsg);
        logout = view.findViewById(R.id.logout);
        edit = view.findViewById(R.id.editFAB);
        EmailErrorMsg.setVisibility(View.GONE);
        PhoneErrorMsg.setVisibility(View.GONE);
        UsernameErrorMsg.setVisibility(View.GONE);
        FirstnameErrorMsg.setVisibility(View.GONE);
        headingText = getActivity().findViewById(R.id.headingTV);
        headingText.setText("PROFILE");
    }

//    public void GetDetails(int Id) {
//        getCustomLayoutDialog();
//        com.example.lubetrackapp.Utils.DataPrepare.get(getContext()).getrestadapter()
//                .GetClientDetails(Id)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<List<UserResponse>>() {
//
//                    @Override
//                    public void onCompleted() {
//                        dialog.dismiss();
//                        //Log.d("Success","Successfull");
//                        //StopDialogue();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        try {
//                            dialog.dismiss();
//                            Log.d("OnError ", e.getMessage());
//                            //DisplayToast("Error");
//                            //StopDialogue();
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onNext(List<UserResponse> responselist) {
//                        dialog.dismiss();
//                        UserResponse res = responselist.get(0);
//
//                        if(res.getEmailId()!=null){
//                            emailTextView.setText(res.getEmailId());
//                        }
//                        if(res.getContactNo1()!=null){
//                            phoneTextView.setText(res.getContactNo1());
//                        }
//                        if(res.getClientName()!=null){
//                            UsernameTextView.setText(res.getClientName());
//                        }
//                        if(res.getAddress()!=null){
//                            FirstnameTextView.setText(res.getAddress());
//                        }
//
//                        ctryId = res.getCountryId();
//                        stateId = res.getStateId();
//                        cityId = res.getCityId();
//
//                        emailTextView.setFocusable(false);
//                        phoneTextView.setFocusable(false);
//                        UsernameTextView.setFocusable(false);
//                        FirstnameTextView.setFocusable(false);
//                    }
//                });
//    }

//    public void SaveProfile(JsonObject jsonObject){
//        getCustomLayoutDialog();
//        com.example.lubetrackapp.Utils.DataPrepare.get(getContext()).getrestadapter()
//                .SaveProfile(jsonObject)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<List<UserResponse>>() {
//
//                    @Override
//                    public void onCompleted() {
//                        dialog.dismiss();
//                        //Log.d("Success","Successfull");
//                        //StopDialogue();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        try {
//                            Log.d("OnError ", e.getMessage());
//                            dialog.dismiss();
//                            //DisplayToast("Error");
//                            //StopDialogue();
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onNext(List<UserResponse> responselist) {
//                        UserResponse res = responselist.get(0);
//                        dialog.dismiss();
//
//                        emailTextView.setFocusable(false);
//                        phoneTextView.setFocusable(false);
//                        UsernameTextView.setFocusable(false);
//                        FirstnameTextView.setFocusable(false);
//
//                        GetDetails(ApplicationConstants.clientid);
//
//                    }
//                });
//    }

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
