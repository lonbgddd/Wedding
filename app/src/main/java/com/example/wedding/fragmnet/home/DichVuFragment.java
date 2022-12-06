package com.example.wedding.fragmnet.home;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.wedding.BaseFragment;
import com.example.wedding.Domain.Service;
import com.example.wedding.Domain.Thietlap;
import com.example.wedding.dao.DichvuDao;
import com.example.wedding.dao.ThietLapDao;
import com.example.wedding.databinding.FragmentDichvuBinding;
import com.example.wedding.databinding.SaleBottomBinding;

public class DichVuFragment extends BaseFragment implements DichVuAdapter.CallBack {
    private FragmentDichvuBinding binding = null;
    public DichVuFragment() {
        // Required empty public constructor
    }

    public static DichVuFragment newInstance() {
        DichVuFragment fragment = new DichVuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDichvuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listening();
    }

    @Override
    public void loadData() {
        DichvuDao dichvuDao  = new DichvuDao(requireContext());
        DichVuAdapter dichVuAdapter = new DichVuAdapter(dichvuDao.getAll(), DichVuFragment.this);
        binding.rcvList.setAdapter(dichVuAdapter);
    }

    @Override
    public void listening() {
         binding.imgBack.setOnClickListener(v -> backStack());
    }

    @Override
    public void OnClick(Service dichvu) {
        final Dialog dialog = new Dialog(requireContext());
        SaleBottomBinding bindingDialog = SaleBottomBinding.inflate(LayoutInflater.from(requireContext()));
        dialog.setContentView(bindingDialog.getRoot());
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        window.setAttributes(layoutParams);

        bindingDialog.txTitle.setText(dichvu.getReview());
        bindingDialog.txDescription.setText(dichvu.getDate());
        bindingDialog.imgItem.setImageResource(Integer.parseInt(dichvu.getImage()));
        bindingDialog.cancelBtn.setOnClickListener(v -> dialog.cancel());
        bindingDialog.addBtn.setOnClickListener(v -> {
            ThietLapDao thietLapDao = new ThietLapDao(requireContext());
            thietLapDao.insert(new Thietlap(0,dichvu.getReview(), dichvu.getName(), dichvu.getImage()));
            Toast.makeText(requireContext(), "Thiết lập thành công", Toast.LENGTH_SHORT).show();
            dialog.cancel();
        });
        dialog.show();
    }
}