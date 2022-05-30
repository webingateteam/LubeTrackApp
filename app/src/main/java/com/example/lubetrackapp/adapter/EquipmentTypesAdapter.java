package com.example.lubetrackapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lubetrackapp.R;
import com.example.lubetrackapp.Utils.BuildingResponse;
import com.example.lubetrackapp.Utils.EquipmentMaster;

import java.util.List;

public class EquipmentTypesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<EquipmentMaster> locslist;
    private OnItemClickListener itemClickListener;
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    public interface OnItemClickListener {
        void onItemClick(View view, EquipmentMaster obj, int position);
    }

    public void setOnItemClickListener(final EquipmentTypesAdapter.OnItemClickListener mItemClickListener) {
        this.itemClickListener = mItemClickListener;
    }

    public EquipmentTypesAdapter(List<EquipmentMaster> locslist) {
        this.locslist = locslist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


       // if (viewType == VIEW_TYPE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.equipment_type_items, parent, false);
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

            EquipmentTypesAdapter.ItemViewHolder holder = (EquipmentTypesAdapter.ItemViewHolder) ItemViewHolder;
            Context context = holder.holderCardView.getContext();

            holder.image.setImageResource(R.drawable.gear);
            holder.NameText.setText(response.getName());

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

        TextView NameText;
        ImageView image;
        CardView holderCardView;

        ItemViewHolder(View view) {
            super(view);
            holderCardView = view.findViewById(R.id.placeHolderCardView);
            image = view.findViewById(R.id.productImageView);
            NameText = view.findViewById(R.id.productTextView);
        }
    }
}
