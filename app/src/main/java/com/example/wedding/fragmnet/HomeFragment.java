package com.example.wedding.fragmnet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wedding.BaseFragment;
import com.example.wedding.Domain.PhotosSlider;
import com.example.wedding.Domain.Thietlap;
import com.example.wedding.R;
import com.example.wedding.dao.ThietLapDao;
import com.example.wedding.databinding.FragmentHomeBinding;
import com.example.wedding.fragmnet.home.DichVuFragment;
import com.example.wedding.fragmnet.home.KhongGianFragment;
import com.example.wedding.fragmnet.home.SliderImageAdapter;
import com.example.wedding.fragmnet.home.ThucDonFragment;

import java.util.ArrayList;


public class HomeFragment extends BaseFragment implements ThietLapAdapter.CallBack {
    private FragmentHomeBinding binding = null;
    ThietLapAdapter thietLapAdapter;
    ArrayList<PhotosSlider> listPhotos;

    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int currentItems = binding.imgAnh.getCurrentItem();
            if(currentItems == listPhotos.size() - 1){
                binding.imgAnh.setCurrentItem(0);
            }else {
                binding.imgAnh.setCurrentItem(currentItems + 1);
            }
        }
    };
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
        Log.d("TAG", "loadData: "+R.drawable.mon3);
        Log.d("TAG", "loadData: "+R.drawable.mon4);
//        Log.d("TAG", "loadData: "+R.drawable.listmon3);
//
//////        Log.d("TAG", "loadData: "+R.drawable.sanh4);
//
//        Log.d("TAG", "loadData: "+R.drawable.dichvu);
//        Log.d("TAG", "loadData: "+R.drawable.dichvu2);
//        Log.d("TAG", "loadData: "+R.drawable.dichvu3);
//        Log.d("TAG", "loadData: "+R.drawable.dichvu4);
//
//        Log.d("TAG", "loadData: "+R.drawable.food);
//        Log.d("TAG", "loadData: "+R.drawable.listmon2);
//        Log.d("TAG", "loadData: "+R.drawable.listmon3);

//        Log.d("TAG", "loadData: "+R.drawable.listmon1);
//        Log.d("TAG", "loadData: "+R.drawable.listmon2);
//        Log.d("TAG", "loadData: "+R.drawable.listmon3);

        ThietLapDao thietLapDao = new ThietLapDao(requireContext());
        thietLapAdapter  = new ThietLapAdapter(thietLapDao.getAll(), HomeFragment.this);
        binding.rvSale.setVisibility(View.VISIBLE);
        binding.rvSale.setAdapter(thietLapAdapter);

        binding.imgAnh.setOffscreenPageLimit(3);
        binding.imgAnh.setClipToPadding(false);
        binding.imgAnh.setClipChildren(false);
        listPhotos = getListPhotos();

        SliderImageAdapter photoAdapter = new SliderImageAdapter(listPhotos);
        binding.imgAnh.setAdapter(photoAdapter);
        binding.imgAnh.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,2500);
            }
        });
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

    public ArrayList<PhotosSlider> getListPhotos (){
        ArrayList<PhotosSlider> listPhotos = new ArrayList<>();
        listPhotos.add(new PhotosSlider(R.drawable.about));
        listPhotos.add(new PhotosSlider(R.drawable.dichvu1));
        listPhotos.add(new PhotosSlider(R.drawable.dichvu2));
        listPhotos.add(new PhotosSlider(R.drawable.dichvu5));
        return listPhotos;
    }
    @Override
    public void OnClick(Thietlap thietlap) {

    }
}