package com.example.lubetrackapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lubetrackapp.R;
import com.example.lubetrackapp.Utils.Utils;
import com.example.lubetrackapp.object.DashboardVO;

import java.util.ArrayList;


/**
 * Created by Panacea-Soft on 19/7/18.
 * Contact Email : teamps.is.cool@gmail.com
 * Website : http://www.panacea-soft.com
 */
public class DashbaordItems extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

private ArrayList<DashboardVO> itemArrayList;
private OnItemClickListener itemClickListener;

public interface OnItemClickListener {
    void onItemClick(View view, DashboardVO obj, int position);
}

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.itemClickListener = mItemClickListener;
    }

    public DashbaordItems(ArrayList<DashboardVO> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_items, parent, false);

        return new PlaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder reholder, int position) {

        if(reholder instanceof PlaceViewHolder) {
            PlaceViewHolder holder = (PlaceViewHolder) reholder;
            DashboardVO item = itemArrayList.get(position);

            holder.categoryNameTextView.setText(item.getName());

            //String productCount = item.count + " Products";
           // holder.productCountTextView.setText(productCount);

            holder.productCountTextView.setVisibility(View.INVISIBLE);

            Context context = holder.placeHolderCardView.getContext();

            int id = Utils.getDrawableInt(context, item.getIcon());
            Utils.setImageToImageView(context, holder.itemImageView, id);
 //           Utils.setCircleImageToImageView(context, holder.itemImageView, id, 0, 0);
            //Utils.setCircleImageToImageView(context, holder.placeImageView, id, 20, R.color.md_white_1000);
            //Utils.setCircleImageToImageView(getApplicationContext(), imageView, R.drawable.white_background, color, 10, R.color.colorLine);


            holder.placeHolderCardView.setOnClickListener(view -> {
                if(itemClickListener != null) {
                    itemClickListener.onItemClick(view, itemArrayList.get(position), position);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

public class PlaceViewHolder extends RecyclerView.ViewHolder {

    public CardView placeHolderCardView;
    public ImageView itemImageView;
    public TextView categoryNameTextView;
    public TextView productCountTextView;


    public PlaceViewHolder(View view) {
        super(view);

       // categoryNameTextView = view.findViewById(R.id.categoryNameTextView);
       // itemImageView = view.findViewById(R.id.itemImageView);
      //  productCountTextView = view.findViewById(R.id.productCountTextView);
        placeHolderCardView = view.findViewById(R.id.placeHolderCardView);
    }
}

}


