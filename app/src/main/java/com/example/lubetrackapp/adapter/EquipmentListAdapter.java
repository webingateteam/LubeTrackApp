package com.example.lubetrackapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lubetrackapp.R;
import com.example.lubetrackapp.Utils.EquipmentMaster;

import java.util.List;

public class EquipmentListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<EquipmentMaster> locslist;
    private OnItemClickListener itemClickListener;
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    public interface OnItemClickListener {
        void onItemClick(View view, EquipmentMaster obj, int position);
    }

    public void setOnItemClickListener(final EquipmentListAdapter.OnItemClickListener mItemClickListener) {
        this.itemClickListener = mItemClickListener;
    }

    public EquipmentListAdapter(List<EquipmentMaster> locslist) {
        this.locslist = locslist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


       // if (viewType == VIEW_TYPE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.equipment_list_items, parent, false);
            return new ItemViewHolder(itemView);
       // } else {
           // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_more_loading_layout, parent, false);
          //  return new LoadingViewHolder(view);
       // }

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder ItemViewHolder, int position) {

        if (ItemViewHolder instanceof ItemViewHolder) {


            EquipmentMaster response = locslist.get(position);

            EquipmentListAdapter.ItemViewHolder holder = (EquipmentListAdapter.ItemViewHolder) ItemViewHolder;
            Context context = holder.holderCardView.getContext();

            if(response.getCode()!=null&&response.getEquipmentComponent()!=null){
                holder.ClientNameText.setText(response.getCode() +" - "+response.getEquipmentComponent());
            }
            else if(response.getCode()!=null&&response.getEquipmentComponent()==null){
                holder.ClientNameText.setText(response.getCode());
            }
            else if(response.getCode()==null&&response.getEquipmentComponent()!=null){
                holder.ClientNameText.setText(response.getEquipmentComponent());
            }

            holder.CodeText.setText(response.getName());
            holder.ComponentNameText.setText(response.getEquipmentComponent());
            holder.LocationNameText.setText(response.getBuildingName()+", "+response.getDepartmentName()+", "+response.getLocationName());

            holder.InspectText.setTextColor(context.getResources().getColor(R.color.white));
            holder.InspectText.setBackgroundColor(context.getResources().getColor(R.color.red_600));

            if (itemClickListener != null) {
                holder.holderCardView.setOnClickListener((View v) -> itemClickListener.onItemClick(v, locslist.get(position), position));
            }
        }
        else if (ItemViewHolder instanceof LoadingViewHolder) {
            showLoadingView((LoadingViewHolder) ItemViewHolder, position);

        }

    }

    private class LoadingViewHolder extends RecyclerView.ViewHolder {

        ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            //progressBar = itemView.findViewById(R.id.progressBar);
        }
    }

    private void showLoadingView(LoadingViewHolder viewHolder, int position) {
        //ProgressBar would be displayed

    }

    @Override
    public int getItemViewType(int position) {
        return locslist.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }


    @Override
    public int getItemCount() {
        int a;
        if (locslist != null && !locslist.isEmpty()) {
            a = locslist.size();
        } else {
            a = 0;
        }
        return a;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView ClientNameText,LocationNameText,CodeText,ComponentNameText,InspectText;
        CardView holderCardView;

        ItemViewHolder(View view) {
            super(view);
            holderCardView = view.findViewById(R.id.holderCardView);
            ClientNameText = view.findViewById(R.id.ClientNameText);
            CodeText = view.findViewById(R.id.CodeText);
            ComponentNameText = view.findViewById(R.id.ComponentNameText);
            LocationNameText = view.findViewById(R.id.LocationNameText);
            InspectText = view.findViewById(R.id.InspectText);
        }
    }
}
