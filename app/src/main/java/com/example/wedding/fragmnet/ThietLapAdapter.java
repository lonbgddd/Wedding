package com.example.wedding.fragmnet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.Domain.Thietlap;
import com.example.wedding.R;

import java.util.List;

public class ThietLapAdapter extends RecyclerView.Adapter<ThietLapAdapter.ViewHolder> {
    List<Thietlap> list;
    CallBack callBack;
    interface CallBack {
        void OnClick(Thietlap thietlap);
    }
    public ThietLapAdapter(List<Thietlap> list, CallBack callBack) {
        this.list = list;
        this.callBack = callBack;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listds,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Thietlap thietlap = list.get(position);
        if (thietlap ==null){
            return;
        } else
            holder.initData(thietlap);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitler;
        ImageView anh;
        ConstraintLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitler = itemView.findViewById(R.id.tv_name);
            anh =itemView.findViewById(R.id.img_image);
            layout = itemView.findViewById(R.id.layout);
        }
        void initData(Thietlap thietlap){
            tvTitler.setText(thietlap.getTitle());
            anh.setImageResource(Integer.parseInt(thietlap.getAnh()));
            layout.setOnClickListener(v -> callBack.OnClick(thietlap));
        }

    }
}
