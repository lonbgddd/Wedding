package com.example.wedding.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wedding.Domain.Popular;
import com.example.wedding.Helper.Sqldatabase;
import com.example.wedding.R;
import com.example.wedding.fragmnet.CartFragment;
import com.example.wedding.fragmnet.ContactFragment;
import com.example.wedding.fragmnet.HomeFragment;
import com.example.wedding.fragmnet.UserFragment;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewPopularlist;
    private Sqldatabase sqldatabase;

    private ActivityMainBinding binding = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().add(R.id.fade_control, HomeFragment.newInstance()).commit();

        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fade_control, HomeFragment.newInstance()).commit();
                        break;
                    case R.id.action_cart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fade_control, CartFragment.newInstance()).commit();
                        break;
                    case R.id.action_contact:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fade_control, ContactFragment.newInstance()).commit();
                        break;
                    case R.id.action_user:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fade_control, UserFragment.newInstance()).commit();
                        break;

        sqldatabase = new Sqldatabase(this);


        recyclerViewPopular();
    }
                }


    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPopularlist = findViewById(R.id.view1);
        recyclerViewPopularlist.setLayoutManager(linearLayoutManager);
        recyclerViewPopularlist.setItemAnimator(new DefaultItemAnimator());
        recyclerViewPopularlist.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
                return true;
            }
        });

        ArrayList<Popular> popularlist = new ArrayList<>();
        popularlist.add(new Popular(1, "Tôm hùm", "hi hi hi", R.drawable.mon1));
        popularlist.add(new Popular(1, "Tôm hùm", "hi hi hi", R.drawable.mon1));
        popularlist.add(new Popular(1, "Tôm hùm", "hi hi hi", R.drawable.mon1));
        popularlist.add(new Popular(1, "Tôm hùm", "hi hi hi", R.drawable.mon1));

    }

}