package com.example.wedding.fragmnet.home;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.wedding.BaseFragment;
import com.example.wedding.Domain.Foods;
import com.example.wedding.Domain.Thietlap;
import com.example.wedding.Helper.Sqldatabase;
import com.example.wedding.dao.MonanDao;
import com.example.wedding.dao.ThietLapDao;
import com.example.wedding.databinding.FragmentThucdonBinding;
import com.example.wedding.databinding.SaleBottomBinding;

public class ThucDonFragment extends BaseFragment implements ThucDonAdapter.CallBack {


    private FragmentThucdonBinding binding = null;
    Sqldatabase sqldatabase;
    public ThucDonFragment() {
        // Required empty public constructor
    }

    public static ThucDonFragment newInstance() {
        ThucDonFragment fragment = new ThucDonFragment();
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
        binding = FragmentThucdonBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listening();
    }

    @Override
    public void loadData() {
        MonanDao monanDao = new MonanDao(requireContext());
        Log.d("TAG", "loadData: "+monanDao.getAll().size());
        ThucDonAdapter thucDonAdapter = new ThucDonAdapter(monanDao.getAll(), ThucDonFragment.this);
        binding.rcvList.setAdapter(thucDonAdapter);
        binding.searchThucdon.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                thucDonAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                thucDonAdapter.getFilter().filter(newText);
                return true;
            }
        });

    }

    @Override
    public void listening() {
        binding.imgBack.setOnClickListener(v -> backStack());
    }

    @Override
    public void OnClick(Foods monan) {
        
        final Dialog dialog = new Dialog(requireContext());
        SaleBottomBinding bindingDialog = SaleBottomBinding.inflate(LayoutInflater.from(requireContext()));
        dialog.setContentView(bindingDialog.getRoot());
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        window.setAttributes(layoutParams);

        bindingDialog.txTitle.setText(monan.getName());
        bindingDialog.txDescription.setText(monan.getReview());
        bindingDialog.imgItem.setImageResource(Integer.parseInt(monan.getImage()));
        bindingDialog.cancelBtn.setOnClickListener(v -> dialog.cancel());
        bindingDialog.addBtn.setOnClickListener(v -> {
            ThietLapDao thietLapDao = new ThietLapDao(requireContext());
            Thietlap thietlap = new Thietlap();
            thietlap.setId_thietlap(2);
            thietlap.setTitle(monan.getName());
            thietlap.setReview( monan.getReview());
            thietlap.setAnh(monan.getImage());
            thietLapDao.insert(thietlap);
            Toast.makeText(requireContext(), "Thiết lập thành công", Toast.LENGTH_SHORT).show();
            dialog.cancel();
        });
        dialog.show();
    }
}