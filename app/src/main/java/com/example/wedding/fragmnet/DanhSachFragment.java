package com.example.wedding.fragmnet;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.wedding.BaseFragment;
import com.example.wedding.Domain.Thietlap;
import com.example.wedding.R;
import com.example.wedding.dao.ThietLapDao;
import com.example.wedding.databinding.BottomDeleteBinding;
import com.example.wedding.databinding.FragmentDanhsachthietlapBinding;

public class DanhSachFragment extends BaseFragment implements ThietLapAdapter.CallBack {
    private FragmentDanhsachthietlapBinding binding = null;
    ThietLapAdapter thietLapAdapter;
    public DanhSachFragment() {
        // Required empty public constructor
    }

    public static DanhSachFragment newInstance() {
        DanhSachFragment fragment = new DanhSachFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDanhsachthietlapBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listening();
    }

    @Override
    public void loadData() {
        ThietLapDao thietLapDao = new ThietLapDao(requireContext());
        thietLapAdapter  = new ThietLapAdapter(thietLapDao.getAll(), DanhSachFragment.this);
        binding.rcv.setAdapter(thietLapAdapter);
    }

    @Override
    public void listening() {
        binding.imgBack.setOnClickListener(v -> backStack());
    }

    @Override
    public void OnClick(Thietlap thietlap) {
        final Dialog dialog = new Dialog(requireContext());
        BottomDeleteBinding bindingDialog = BottomDeleteBinding.inflate(LayoutInflater.from(requireContext()));
        dialog.setContentView(bindingDialog.getRoot());
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        window.setAttributes(layoutParams);

        bindingDialog.txTitle.setText(thietlap.getTitle());
        bindingDialog.imgItem.setImageResource(Integer.parseInt(thietlap.getAnh()));
        bindingDialog.cancelBtn.setOnClickListener(v -> dialog.cancel());
        bindingDialog.addBtn.setOnClickListener(v -> {
            ThietLapDao thietLapDao = new ThietLapDao(requireContext());
            thietLapDao.deleteById(thietlap.getId_thietlap());
            Toast.makeText(requireContext(), "Xoá thành công", Toast.LENGTH_SHORT).show();
            loadData();
            dialog.cancel();
        });
        dialog.show();
    }
}