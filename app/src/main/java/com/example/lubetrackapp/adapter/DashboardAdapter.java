package com.example.lubetrackapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.lubetrackapp.R;
import com.example.lubetrackapp.Utils.Utils;
import com.example.lubetrackapp.object.DashboardVO;

import java.util.ArrayList;
import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DashboardVO> productsList;
    private OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, DashboardVO product, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.itemClickListener = mItemClickListener;
    }

    public DashboardAdapter(ArrayList<DashboardVO> productsList) {
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_items, parent, false);
        return new ProductsViewHolder(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProductsViewHolder) {


            DashboardVO productsVO = productsList.get(position);
                ProductsViewHolder productsViewHolder = (ProductsViewHolder) holder;
                Context context = productsViewHolder.productImageView.getContext();

                productsViewHolder.productTextView.setText(productsVO.getName());

            int productImageId = Utils.getDrawableInt(context, productsVO.getIcon());
            Glide.with(context)
                    .load(productImageId)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(productsViewHolder.productImageView);


//                Utils.setCircleImageToImageView(context, productsViewHolder.productImageView, productImageId, 0, 0);

            if (itemClickListener != null) {
                ((ProductsViewHolder) holder).productConstraintLayout.setOnClickListener(view -> itemClickListener.onItemClick(view, productsList.get(position), position));
            }

        }
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout productConstraintLayout;
        ImageView productImageView;
        TextView productTextView;

        public ProductsViewHolder(View itemView) {
            super(itemView);
            productConstraintLayout = itemView.findViewById(R.id.productConstraint);
            productImageView = itemView.findViewById(R.id.productImageView);
            productTextView = itemView.findViewById(R.id.productTextView);
        }
    }
}
