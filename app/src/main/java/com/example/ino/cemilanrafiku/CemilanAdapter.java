package com.example.ino.cemilanrafiku;

import android.app.Activity;
import android.content.Context;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class CemilanAdapter extends RecyclerView.Adapter<CemilanAdapter.AyamViewHolder> {
    public interface ItemClickListener {
        void onClick(View view, int position);
    }

    public ImageView image;
    private ArrayList<Cemilan> dataList;
    private ItemClickListener clickListener;
    private Context context;

    public CemilanAdapter(ArrayList<Cemilan> dataList, Activity activity, Context
            context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public CemilanAdapter.AyamViewHolder onCreateViewHolder(ViewGroup viewGroup, int
            i) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        return new AyamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CemilanAdapter.AyamViewHolder ayamViewHolder, int
            i) {
        Glide.with(context).load(dataList.get(i).getImage()).into(ayamViewHolder.ayamImage);
        ayamViewHolder.ayamName.setText(dataList.get(i).getName());
        ayamViewHolder.ayamName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        ayamViewHolder.ayamPrice.setText("Rp " +
                decimalFormat.format(dataList.get(i).getPrice()));
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class AyamViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private ImageView ayamImage;
        private TextView ayamName;
        private TextView ayamPrice;
        private CardView cardView;

        public AyamViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);
            ayamImage = (ImageView) view.findViewById(R.id.ayamImage);
            ayamName = (TextView) view.findViewById(R.id.ayamName);
            ayamPrice = (TextView) view.findViewById(R.id.ayamPrice);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view,
                    getAdapterPosition());
        }
    }
}

