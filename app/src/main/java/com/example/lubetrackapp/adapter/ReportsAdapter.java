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
import com.example.lubetrackapp.Utils.BuildingResponse;

import java.util.List;

public class ReportsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<BuildingResponse> locslist;
    private OnItemClickListener itemClickListener;
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    public interface OnItemClickListener {
        void onItemClick(View view, BuildingResponse obj, int position);
    }

    public void setOnItemClickListener(final ReportsAdapter.OnItemClickListener mItemClickListener) {
        this.itemClickListener = mItemClickListener;
    }

    public ReportsAdapter(List<BuildingResponse> locslist) {
        this.locslist = locslist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


       // if (viewType == VIEW_TYPE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_items, parent, false);
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


            BuildingResponse response = locslist.get(position);

            ReportsAdapter.ItemViewHolder holder = (ReportsAdapter.ItemViewHolder) ItemViewHolder;
            Context context = holder.holderCardView.getContext();

            holder.ClientNameText.setText(response.getLocationName());
            holder.LocationNameText.setText(response.getAddress());


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

        TextView ClientNameText,LocationNameText;
        CardView holderCardView;

        ItemViewHolder(View view) {
            super(view);
            holderCardView = view.findViewById(R.id.holderCardView);
            ClientNameText = view.findViewById(R.id.ClientNameText);
            LocationNameText = view.findViewById(R.id.LocationNameText);
        }
    }
}
