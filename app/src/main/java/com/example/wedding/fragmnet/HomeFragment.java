package com.example.wedding.fragmnet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wedding.BaseFragment;
import com.example.wedding.R;
import com.example.wedding.databinding.FragmentHomeBinding;
import com.example.wedding.fragmnet.home.DichVuFragment;
import com.example.wedding.fragmnet.home.KhongGianFragment;
import com.example.wedding.fragmnet.home.ThucDonFragment;


public class HomeFragment extends BaseFragment {
    private FragmentHomeBinding binding = null;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listening();
    }

    @Override
    public void loadData() {
        Log.d("TAG", "loadData: "+R.drawable.listmon1);
        Log.d("TAG", "loadData: "+R.drawable.listmon2);
        Log.d("TAG", "loadData: "+R.drawable.listmon3);
////        Log.d("TAG", "loadData: "+R.drawable.sanh4);
    }

    @Override
    public void listening() {
        binding.imageView20.setOnClickListener(v -> {
            replaceFragment(ThucDonFragment.newInstance());
        });
        binding.imageView21.setOnClickListener(v -> {
            replaceFragment(DichVuFragment.newInstance());
        });
        binding.imageView22.setOnClickListener(v -> {
            replaceFragment(KhongGianFragment.newInstance());
        });
    }
}