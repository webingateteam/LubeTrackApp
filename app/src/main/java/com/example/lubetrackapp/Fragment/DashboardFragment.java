package com.example.lubetrackapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lubetrackapp.ClientLocations;
import com.example.lubetrackapp.R;
import com.example.lubetrackapp.ReportsActivity;
import com.example.lubetrackapp.adapter.DashboardAdapter;
import com.example.lubetrackapp.object.DashboardVO;
import com.example.lubetrackapp.repository.HomeRepository;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    ArrayList<DashboardVO> productsList;
    ArrayList<DashboardVO> productsList1;
    DashboardAdapter productsAdapter1;
    RecyclerView rvProduct, rvProducts1;
    ImageView profileImageView;
    int noOfProductColumn = 4;
    int noOfPopularColumn = 2;
    TextView headingText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        initData();
        initUI(view);
        initDataBindings();
        initActions();
        return view;
    }
    private void initData() {
        productsList1 = HomeRepository.getAdminCommonFunc();
    }
    private void initUI(View view) {
        headingText = getActivity().findViewById(R.id.headingTV);
        headingText.setText("DASHBOARD");
        productsAdapter1 = new DashboardAdapter(productsList1);

        if (getActivity() != null) {
            rvProducts1 = view.findViewById(R.id.rvProducts1);
            GridLayoutManager gd= new GridLayoutManager(getActivity().getApplicationContext(), noOfProductColumn);
            rvProducts1.setLayoutManager(gd);
            rvProducts1.setItemAnimator(new DefaultItemAnimator());
            rvProducts1.setAdapter(productsAdapter1);
        }
    }
    private void initDataBindings() {
    }
    private void initActions() {


        productsAdapter1.setOnItemClickListener((view, promotion, position) -> {

           // startActivity(new Intent(getActivity(), ClientLocations.class));
            //getActivity().finish();

            switch(position){
                case 0:
                    startActivity(new Intent(getActivity(), ClientLocations.class));
                    break;
                case 1:
                    startActivity(new Intent(getActivity(), ReportsActivity.class));
                    break;
                default:
                    break;
            }
        });
    }
}
