package com.example.wedding.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.Domain.Popular;
import com.example.wedding.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularVH> {
    ArrayList<Popular> populars;

    public PopularAdapter(ArrayList<Popular> populars) {
        this.populars = populars;
    }

    @NonNull
    @Override
    public PopularVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new PopularVH(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularVH holder, int position) {
        Popular popular = populars.get(position);
        holder.popularName.setText(popular.getTitle());
        holder.popularPic.setImageResource(popular.getImg());

    }

    @Override
    public int getItemCount() {

        return populars.size();
    }

    public class PopularVH extends RecyclerView.ViewHolder{
        TextView popularName;
        ImageView popularPic;
        ConstraintLayout popularLayout;

        public PopularVH(@NonNull View itemView) {
            super(itemView);
            popularName=itemView.findViewById(R.id.popularName);
            popularPic=itemView.findViewById(R.id.popularPic);
            popularLayout=itemView.findViewById(R.id.popularLayout);
        }
    }
}
