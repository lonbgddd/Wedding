package com.example.wedding.fragmnet.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.Domain.Foods;
import com.example.wedding.databinding.ItemListdsBinding;

import java.util.ArrayList;
import java.util.List;

public class ThucDonAdapter extends RecyclerView.Adapter<ThucDonAdapter.ViewHolder> implements Filterable {
    List<Foods> list;
    List<Foods> listOld;
    CallBack callBack;
    interface CallBack {
        void OnClick(Foods monan);
    }
    public ThucDonAdapter(List<Foods> list, CallBack callBack) {
        this.list = list;
        this.callBack = callBack;
        this.listOld = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemListdsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Foods monan = listOld.get(position);
        if (monan == null){
            return;
        } else
          holder.initData(monan);
    }

    @Override
    public int getItemCount() {
        return listOld.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strName = constraint.toString();
                if (strName.isEmpty()) {
                    listOld = list;
                } else {
                    List<Foods> listBien = new ArrayList<>();
                    for (Foods model : list) {
                        if (model.getName().toLowerCase().contains(strName.toLowerCase())) {
                            listBien.add(model);
                        }
                    }
                    listOld = listBien;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listOld;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listOld = (List<Foods>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView anh;

        ConstraintLayout view;
        public ViewHolder(@NonNull ItemListdsBinding binding) {
            super(binding.getRoot());
            name  = binding.tvName;
            anh = binding.imgImage;
            view = binding.layout;
        }
        void initData(Foods monan){
            name.setText(monan.getName());
            anh.setImageResource(Integer.parseInt(monan.getImage()));
            view.setOnClickListener(v -> callBack.OnClick(monan));
        }

    }
}
