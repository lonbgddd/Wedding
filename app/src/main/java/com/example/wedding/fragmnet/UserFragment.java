package com.example.wedding.fragmnet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wedding.BaseFragment;
import com.example.wedding.R;
import com.example.wedding.databinding.FragmentNguoidungBinding;
import com.example.wedding.databinding.FragmentUserBinding;

public class UserFragment extends BaseFragment {
    private FragmentNguoidungBinding binding = null;
    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment newInstance() {
        UserFragment fragment = new UserFragment();
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
        binding = FragmentNguoidungBinding.inflate(inflater, container, false);
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
        binding.btnDs.setOnClickListener(v -> replaceFragment(DanhSachFragment.newInstance()));

    }
}