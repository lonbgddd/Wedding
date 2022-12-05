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
import com.example.wedding.Domain.Monan;
import com.example.wedding.databinding.ItemListdvBinding;

import java.util.ArrayList;
import java.util.List;

public class KhongGianAdapter extends RecyclerView.Adapter<KhongGianAdapter.ViewHolder> implements Filterable {
    List<Khonggiantiec> list;
    List<Khonggiantiec> listOld;
    CallBack callBack;
    interface CallBack {
        void OnClick(Khonggiantiec khonggiantiec);
    }
    public KhongGianAdapter(List<Khonggiantiec> list, CallBack callBack) {
        this.list = list;
        this.listOld = list;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemListdvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Khonggiantiec khonggiantiec = listOld.get(position);
            if (khonggiantiec == null){
                return;
            } else
                holder.initData(khonggiantiec);
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
                    List<Khonggiantiec> listBien = new ArrayList<>();
                    for (Khonggiantiec model : list) {
                        if (model.getTenkhonggian().toLowerCase().contains(strName.toLowerCase())) {
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
                listOld = (List<Khonggiantiec>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView anh;
        ConstraintLayout layout;
        public ViewHolder(@NonNull ItemListdvBinding binding) {
            super(binding.getRoot());
            name  = binding.tvName;
            anh = binding.imgImage;
            layout = binding.layout;
        }
        void initData(Khonggiantiec monan){
            name.setText(monan.getTenkhonggian());
            anh.setImageResource(Integer.parseInt(monan.getAnh()));
            layout.setOnClickListener(v -> callBack.OnClick(monan));
        }
    }

}
