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
import android.widget.SearchView;
import android.widget.Toast;

import com.example.wedding.BaseFragment;
import com.example.wedding.Domain.Space;
import com.example.wedding.Domain.Thietlap;
import com.example.wedding.dao.KhonggiantiecDao;
import com.example.wedding.dao.ThietLapDao;
import com.example.wedding.databinding.FragmentKhonggiantiecBinding;
import com.example.wedding.databinding.SaleBottomBinding;


public class KhongGianFragment extends BaseFragment implements KhongGianAdapter.CallBack {
    private FragmentKhonggiantiecBinding binding = null;
    public KhongGianFragment() {
        // Required empty public constructor
    }
    public static KhongGianFragment newInstance() {
        KhongGianFragment fragment = new KhongGianFragment();
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listening();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentKhonggiantiecBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void loadData() {
        KhonggiantiecDao khonggiantiecDao = new KhonggiantiecDao(requireContext());
        KhongGianAdapter khongGianAdapter = new KhongGianAdapter(khonggiantiecDao.getAll() , KhongGianFragment.this);
        binding.rcvList.setAdapter(khongGianAdapter);
        binding.searchKhonggiantiec.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                khongGianAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                khongGianAdapter.getFilter().filter(newText);
                return true;
            }
        });

    }

    @Override
    public void listening() {
        binding.imgBack.setOnClickListener(v -> backStack());
    }

    @Override
    public void OnClick(Space khonggiantiec) {
        final Dialog dialog = new Dialog(requireContext());
        SaleBottomBinding bindingDialog = SaleBottomBinding.inflate(LayoutInflater.from(requireContext()));
        dialog.setContentView(bindingDialog.getRoot());
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        window.setAttributes(layoutParams);

        bindingDialog.txTitle.setText(khonggiantiec.getName());
        bindingDialog.txDescription.setText(khonggiantiec.getReview());
        bindingDialog.imgItem.setImageResource(Integer.parseInt(khonggiantiec.getImage()));
        bindingDialog.cancelBtn.setOnClickListener(v -> dialog.cancel());
        bindingDialog.addBtn.setOnClickListener(v -> {
            ThietLapDao thietLapDao = new ThietLapDao(requireContext());
            thietLapDao.insert(new Thietlap(1,khonggiantiec.getName(), khonggiantiec.Review, khonggiantiec.getImage()));
            Toast.makeText(requireContext(), "Thiết lập thành công", Toast.LENGTH_SHORT).show();
            dialog.cancel();
        });
        dialog.show();
    }
}