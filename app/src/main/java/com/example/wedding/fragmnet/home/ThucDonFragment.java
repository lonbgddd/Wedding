package com.example.wedding.fragmnet.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wedding.BaseFragment;
import com.example.wedding.R;
import com.example.wedding.databinding.FragmentThucdonBinding;

public class ThucDonFragment extends BaseFragment {
    private FragmentThucdonBinding binding = null;
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

    }

    @Override
    public void listening() {
        binding.imgBack.setOnClickListener(v -> backStack());
    }
}