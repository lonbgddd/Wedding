package com.example.wedding.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.wedding.Adapter.PopularAdapter;
import com.example.wedding.Domain.Popular;
import com.example.wedding.Helper.Sqldatabase;
import com.example.wedding.R;
import com.example.wedding.databinding.ActivityMainBinding;
import com.example.wedding.fragmnet.CartFragment;
import com.example.wedding.fragmnet.ContactFragment;
import com.example.wedding.fragmnet.HomeFragment;
import com.example.wedding.fragmnet.UserFragment;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().add(R.id.fade_control, HomeFragment.newInstance()).commit();

        Sqldatabase sqldatabase = new Sqldatabase(this);
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

                }

                return true;
            }
        });


    }

}