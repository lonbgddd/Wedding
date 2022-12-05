package com.example.wedding.fragmnet.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.Domain.Dichvu;
import com.example.wedding.Domain.Khonggiantiec;
import com.example.wedding.databinding.ItemListdvBinding;

import java.util.ArrayList;
import java.util.List;

public class DichVuAdapter extends RecyclerView.Adapter<DichVuAdapter.ViewHolder> implements Filterable {
    List<Dichvu> list;
    List<Dichvu> listOld;
    CallBack callBack;
    ConstraintLayout layout;
    public DichVuAdapter(List<Dichvu> list, CallBack callBack) {
        this.list = list;
        this.callBack = callBack;
        this.listOld = list;
    }

    interface CallBack {
        void OnClick(Dichvu dichvu);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemListdvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dichvu dichvu = listOld.get(position);
        if (dichvu == null){
            return;
        } else
            holder.initData(dichvu);
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
                    List<Dichvu> listBien = new ArrayList<>();
                    for (Dichvu model : list) {
                        if (model.getKhonggiantiec().toLowerCase().contains(strName.toLowerCase())) {
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
                listOld = (List<Dichvu>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView ten;
        ImageView anh;
        ConstraintLayout layout;
        public ViewHolder(@NonNull ItemListdvBinding binding) {
            super(binding.getRoot());
            ten = binding.tvName;
            anh = binding.imgImage;
            layout = binding.layout;
        }

        void initData(Dichvu dichvu){
            ten.setText(dichvu.getKhonggiantiec());
            anh.setImageResource(Integer.parseInt(dichvu.getAnh()));
            layout.setOnClickListener(v -> callBack.OnClick(dichvu));
        }
    }

}
