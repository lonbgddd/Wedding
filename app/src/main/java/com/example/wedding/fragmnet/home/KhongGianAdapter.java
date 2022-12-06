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

import com.example.wedding.Domain.Space;
import com.example.wedding.databinding.ItemListdvBinding;

import java.util.ArrayList;
import java.util.List;

public class KhongGianAdapter extends RecyclerView.Adapter<KhongGianAdapter.ViewHolder> implements Filterable {
    List<Space> list;
    List<Space> listOld;
    CallBack callBack;
    interface CallBack {
        void OnClick(Space khonggiantiec);
    }
    public KhongGianAdapter(List<Space> list, CallBack callBack) {
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
            Space khonggiantiec = listOld.get(position);
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
                    List<Space> listBien = new ArrayList<>();
                    for (Space model : list) {
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
                listOld = (List<Space>) results.values;
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
        void initData(Space monan){
            name.setText(monan.getName());
            anh.setImageResource(Integer.parseInt(monan.getImage()));
            layout.setOnClickListener(v -> callBack.OnClick(monan));
        }
    }

}
