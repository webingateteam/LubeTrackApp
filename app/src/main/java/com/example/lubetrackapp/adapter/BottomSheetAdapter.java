package com.example.lubetrackapp.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.lubetrackapp.R;
import com.example.lubetrackapp.Utils.BuildingResponse;
import com.example.lubetrackapp.Utils.EquipmentMaster;

import java.util.ArrayList;

public class BottomSheetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<EquipmentMaster> shopItemList;
    public String currentTime;
    int row_index = -1;
    private BottomSheetAdapter.OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, EquipmentMaster obj, int position);

    }

    public void setOnItemClickListener(final BottomSheetAdapter.OnItemClickListener mItemClickListener) {
        this.itemClickListener = mItemClickListener;
    }

    public BottomSheetAdapter(ArrayList<EquipmentMaster> shopItemList) {
        this.shopItemList = shopItemList;
        //     this.currentTime = currenttime;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_sheet, parent, false);

        return new BottomSheetAdapter.ItemViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        EquipmentMaster response = shopItemList.get(position);

        BottomSheetAdapter.ItemViewHolder holder = (BottomSheetAdapter.ItemViewHolder) viewHolder;
        Context context = holder.holderCardView.getContext();

        holder.subCatNameTV.setText(response.getName());


        holder.holderCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(view, shopItemList.get(position), position);

                    row_index = position;
                    notifyDataSetChanged();

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        int a;
        if (shopItemList != null && !shopItemList.isEmpty()) {
            a = shopItemList.size();
        } else {
            a = 0;
        }
        return a;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView subCatNameTV;
        CardView holderCardView;

        ItemViewHolder(View view) {
            super(view);

            subCatNameTV = view.findViewById(R.id.subCatNameTV);
            holderCardView = view.findViewById(R.id.holderCardView);
        }
    }
}
